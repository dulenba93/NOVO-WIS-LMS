package wis.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import wis.domain.Student;
import wis.dto.StudentDTO;
import wis.mapper.StudentMapper;
import wis.service.StudentService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/user-manage")
public class UserManagementController {
	
	@Autowired
	StudentService ss;
	
	@Autowired
	StudentMapper smpr;
	
	@RequestMapping()
	public ResponseEntity<Iterable<StudentDTO>> getAllStudents() {
		System.out.println("anything");
		List<Student> students = ss.getAllStudents();
		return ResponseEntity.ok(smpr.toDTO(students));
	}

}
