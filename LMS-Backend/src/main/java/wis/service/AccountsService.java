package wis.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wis.domain.Accounts;
import wis.repository.AccountsRepository;

@Service
public class AccountsService {

	@Autowired
	AccountsRepository accountsRepository;
	
	public AccountsService() {}
	
	public Iterable<Accounts> getAllAccounts(){
		return accountsRepository.findAll();
	}
	
	public Optional<Accounts> getAccountById(Long id){
		return accountsRepository.findById(id);
	}
	
	public void addAccount(Accounts account) {
		accountsRepository.save(account);
	}
	
	public void removeAccount(Long id) {
		Optional<Accounts> student = accountsRepository.findById(id);
		accountsRepository.delete(student.get());
	}
	
	public void updateAccount(Long id,Accounts account) {
		Optional<Accounts> u = accountsRepository.findById(id);
		if(u.isPresent()){
			account.setId(u.get().getId());
			accountsRepository.save(account);
		}
	}
}
