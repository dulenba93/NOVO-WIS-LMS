package wis.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wis.domain.AccountPermission;
import wis.repository.AccountPermissionRepository;

@Service
public class AccountPermissionService {
	@Autowired
	private AccountPermissionRepository userPermissionRepository;
	
	public Set<AccountPermission> getPermissionsByUserId(Long id) {
		return userPermissionRepository.getByUserId(id);
	}
}

