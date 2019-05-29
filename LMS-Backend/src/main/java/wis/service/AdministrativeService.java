package wis.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wis.domain.Administrative;
import wis.repository.AdministrationRepository;

@Service
public class AdministrativeService {
	@Autowired
	AdministrationRepository ar;

	public AdministrativeService() {
	}

	public List<Administrative> getAdminstrations() {
		return ar.findAll();
	}

	public Administrative getAdminstration(Long id) {
		return ar.findById(id).orElse(null);
	}

	public void addAdministration(Administrative administration) {
		ar.save(administration);
	}

	public void deleteAdministration(Long id) {
		Optional<Administrative> administration = ar.findById(id);
		ar.delete(administration.get());
	}
	
	public void updateAdministration(Long id, Administrative administration) {
		Optional<Administrative> administrative = ar.findById(id);
		if(administrative.isPresent()) {
			administration.setId(administrative.get().getId());
			ar.save(administration);
		}
	}
} 