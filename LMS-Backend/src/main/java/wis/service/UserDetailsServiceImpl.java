package wis.service;

import java.util.ArrayList;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import wis.domain.AccountPermission;
import wis.domain.Accounts;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	AccountsService userService;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Accounts> account = userService.getAccount(username);
		
		if(account.isPresent()) {
			ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
			for(AccountPermission up : account.get().getUserPermissions()) {
				grantedAuthorities.add(new SimpleGrantedAuthority(up.getPermission().getTitle()));
			}
			
			return new org.springframework.security.core.userdetails.User(account.get().getUsername(), account.get().getPassword(), grantedAuthorities);
		}
		
		return null;
	}

}

