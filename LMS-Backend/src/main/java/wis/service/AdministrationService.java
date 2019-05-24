package wis.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wis.domain.Administration;
import wis.repository.AdministrationRepository;

@Service
public class AdministrationService {

	@Autowired
	private AdministrationRepository administrationRepo;
	
	public AdministrationService() {}
	
	public Iterable<Administration> getAllUsers(){
		return administrationRepo.findAll();
	}
	
	public Optional<Administration> getUsersById(Long id){
		return administrationRepo.findById(id);
	}
	
	public void addUser(Administration administration) {
		administrationRepo.save(administration);
	}
	
	public void removeUser(Long id) {
		Optional<Administration> admin = administrationRepo.findById(id);
		administrationRepo.delete(admin.get());
	}
	
	public void updateUser(Long id,Administration administration) {
		Optional<Administration> u = administrationRepo.findById(id);
		if(u.isPresent()){
			administration.setId(u.get().getId());
			administrationRepo.save(administration);
		}
	}
}
