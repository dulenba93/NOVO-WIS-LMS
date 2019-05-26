package wis.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wis.domain.Administration;
import wis.repository.AdministrationRepository;

@Service
public class AdministrativeService {
	@Autowired
	AdministrationRepository ar;

	public AdministrativeService() {
	}

	public Iterable<Administration> getAdminstrations() {
		return ar.findAll();
	}

	public Optional<Administration> getAdminstration(Long id) {
		return ar.findById(id);
	}

	public void addAdministration(Administration administration) {
		ar.save(administration);
	}

	public void deleteAdministration(Long id) {
		Optional<Administration> administration = ar.findById(id);
		ar.delete(administration.get());
	}
	
	public void updateAdministration(Long id, Administration administration) {
		Optional<Administration> administrative = ar.findById(id);
		if(administrative.isPresent()) {
			administration.setId(administrative.get().getId());
			ar.save(administration);
		}
	}
} 