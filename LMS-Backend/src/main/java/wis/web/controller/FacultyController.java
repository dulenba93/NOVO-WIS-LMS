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

import wis.domain.Faculty;
import wis.dto.FacultyDTO;
import wis.mapper.FacultyMapper;
import wis.service.FacultyService;
import wis.utils.View.HideOptionalProperties;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/faculty")
public class FacultyController {
	
	@Autowired
	FacultyService fs;
	
	
	@Autowired
	FacultyMapper facultyMapper;
	
	//@JsonView(HideOptionalProperties.class)
	@RequestMapping()
	public ResponseEntity<Iterable<FacultyDTO>> getAllFaculty() {
		List<Faculty> faculty = fs.getFaculty();
		return ResponseEntity.ok(facultyMapper.toDTO(faculty));
	}
	@RequestMapping(value="/universityid", method=RequestMethod.GET)
	public ResponseEntity<List<FacultyDTO>> getAllFacultyByUniversity(Long id) {
		List<Faculty> faculty = fs.getAllByUniversity(id);
		return ResponseEntity.ok(facultyMapper.toDTO(faculty));
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<Faculty> addFaculty(@RequestBody Faculty faculty) {
		fs.addFaculty(faculty);
		return new ResponseEntity<Faculty>(faculty, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Faculty> updateFaculty(@PathVariable Long id, @RequestBody Faculty faculty) {
		fs.updateFaculty(id, faculty);
		return new ResponseEntity<Faculty>(faculty, HttpStatus.CREATED);
	}
	//@JsonView(ShowFaculty.class)
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public FacultyDTO getFacultyById(@PathVariable Long id) {
		Faculty faculty = fs.getFaculty(id).get();
		return facultyMapper.toDTO(faculty);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Faculty> removeFaculty(@PathVariable Long id) {
		try {
			fs.deleteFaculty(id);
		}catch (Exception e) {
			return new ResponseEntity<Faculty>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Faculty>(HttpStatus.NO_CONTENT);
	}
	
}
