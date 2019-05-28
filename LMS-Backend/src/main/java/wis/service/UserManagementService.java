package wis.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import wis.domain.Student;
import wis.repository.AdministrationRepository;
import wis.repository.StudentRepository;
import wis.repository.TeacherRepository;

@Service
public class UserManagementService {
	
	private final Logger log = LoggerFactory.getLogger(UserManagementService.class);
	
	@Autowired
	private StudentRepository studentRepo;
	
	@Autowired
	private TeacherRepository teacherRepo;
	
	@Autowired
	private AdministrationRepository administrativeRepo;
	
	///students///
	public Page<Student> findAll(Pageable pageable){
		log.debug("Request for all students");
		return studentRepo.findAll(pageable);
	}
}
