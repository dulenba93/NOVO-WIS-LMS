package wis.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wis.domain.Address;
import wis.domain.Faculty;
import wis.domain.University;
import wis.repository.AddressRepository;
import wis.repository.FacultyRepository;
import wis.repository.UniversityRepository;

@Service
public class FacultyService {
	@Autowired
	FacultyRepository fr;
	@Autowired
	UniversityRepository ur;
	@Autowired
	AddressRepository ar;

	public FacultyService() {
	}

	public List<Faculty> getFaculty() {
		return fr.findAll();
	}

	public Optional<Faculty> getFaculty(Long id) {
		return fr.findById(id);
	}
	
	public List<Faculty> getAllByUniversity(Long id){
		return fr.findAllByUniversityId(id);
	}

	public void addFaculty(Faculty faculty) {
		Optional<Address> address= ar.findById(faculty.getAddress().getId());
		Optional<University> university= ur.findById(faculty.getUniversity().getId());
		if(address.isPresent() && university.isPresent()) {
			faculty.setAddress(address.get());
			faculty.setUniversity(university.get());
			fr.save(faculty);
		}
		
	}

	public void deleteFaculty(Long id) {
		Optional<Faculty> faculty = fr.findById(id);
		fr.delete(faculty.get());
	}
	
	public void updateFaculty(Long id, Faculty faculty) {
		Optional<Faculty> fclt = fr.findById(id);
		if(fclt.isPresent()) {
			faculty.setId(fclt.get().getId());
			fr.save(faculty);
		}
	}
}
