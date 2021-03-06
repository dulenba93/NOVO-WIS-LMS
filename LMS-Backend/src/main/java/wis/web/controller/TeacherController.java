package wis.web.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

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

import wis.domain.Teacher;
import wis.dto.TeacherDTO;
import wis.mapper.TeacherMapper;
import wis.service.AccountsService;
import wis.service.AddressService;
import wis.service.TeacherService;
import wis.utils.View.HideOptionalProperties;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/teacher")
public class TeacherController {
	
	@Autowired
	TeacherService ts;
	
	@Autowired
	AddressService as;
	
	@Autowired
	AccountsService acs;
	
	@Autowired
	TeacherMapper tmpr;
	
	@RequestMapping()
	public ResponseEntity<Iterable<TeacherDTO>> getAllTeacher() {
		List<Teacher> teachers = ts.getAllTeachers();
		return ResponseEntity.ok(tmpr.toDTO(teachers));
	}
	
	@Transactional
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<Teacher> addTeacher(@RequestBody Teacher teacher) {
		acs.addAccount(teacher.getAccount());
		as.addAddress(teacher.getAddress());
		ts.addTeacher(teacher);
		return new ResponseEntity<Teacher>(teacher, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Teacher> updateTeacher(@PathVariable Long id, @RequestBody Teacher teacher) {
		ts.updateTeacher(id, teacher);
		return new ResponseEntity<Teacher>(teacher, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public TeacherDTO getTeacherById(@PathVariable Long id) {
		Teacher teacher = ts.getTeacher(id);
		return tmpr.toDTO(teacher);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Teacher> removeTeacher(@PathVariable Long id) {
		try {
			ts.deleteTeacher(id);
		}catch (Exception e) {
			return new ResponseEntity<Teacher>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Teacher>(HttpStatus.NO_CONTENT);
	}
	
}

