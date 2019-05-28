package wis.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import wis.domain.University;
import wis.dto.UniversityDTO;
import wis.mapper.UniversityMapper;
import wis.service.UniversityService;
import wis.utils.View.HideOptionalProperties;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/university")
public class UniversityController {
	
	@Autowired
	UniversityService us;
	
	@Autowired
	UniversityMapper universityMapper;
	
//	@JsonView(HideOptionalProperties.class)
	@RequestMapping()
	public ResponseEntity<Iterable<UniversityDTO>> getAllUniversity() {
		List<University> university = us.getUniversity();
		return ResponseEntity.ok(universityMapper.toDTO(university));
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<University> addUniversity(@RequestBody University university) {
		us.addUniversity(university);
		return new ResponseEntity<University>(university, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<University> updateUniversity(@PathVariable Long id, @RequestBody University university) {
		us.updateUniversity(id, university);
		return new ResponseEntity<University>(university, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public UniversityDTO  getUniversityById(@PathVariable Long id) {
		University university = us.getUniversity(id).get();
		return universityMapper.toDTO(university);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<University> removeUniversity(@PathVariable Long id) {
		try {
			us.deleteUniversity(id);
		}catch (Exception e) {
			return new ResponseEntity<University>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<University>(HttpStatus.NO_CONTENT);
	}
	
}