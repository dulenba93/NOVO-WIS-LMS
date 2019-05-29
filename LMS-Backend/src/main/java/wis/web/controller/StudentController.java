package wis.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import wis.domain.Student;
import wis.dto.StudentDTO;
import wis.mapper.StudentMapper;
import wis.service.AccountsService;
import wis.service.AddressService;
import wis.service.StudentService;
import wis.service.StudentYearService;
import wis.utils.View.HideOptionalProperties;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/students")
public class StudentController{

	@Autowired
	StudentService ts;
	
	@Autowired
	AddressService as;
	
	@Autowired
	AccountsService acs;
	
	@Autowired
	StudentYearService sys;
	
	@Autowired
	StudentMapper smpr;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public ResponseEntity<Iterable<StudentDTO>> getAllStudents() {
		List<Student> students = ts.getAllStudents();
		return ResponseEntity.ok(smpr.toDTO(students));
	}

	@Transactional
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<Student> addStudent(@RequestBody Student student) {
		acs.addAccount(student.getAccount());
		as.addAddress(student.getAddress());
		ts.addStudent(student);
		return new ResponseEntity<Student>(student, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
		ts.updateStudent(id, student);
		return new ResponseEntity<Student>(student, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public StudentDTO getStudentById(@PathVariable Long id) {
		Student student = ts.getStudentById(id);
		return smpr.toDTO(student);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Student> removeStudent(@PathVariable Long id) {
		try {
			ts.removeStudent(id);
		}catch (Exception e) {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
	}
}
