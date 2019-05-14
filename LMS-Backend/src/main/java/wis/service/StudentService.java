package wis.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wis.domain.Admin;
import wis.domain.Student;
import wis.domain.StudentYear;
import wis.domain.YearOfStudy;
import wis.repository.AdminRepository;
import wis.repository.StudentRepository;
import wis.repository.YearOfStudyRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	YearOfStudyRepository yearOfStudyRepository;

	public StudentService() {}
	
	public Iterable<Student> getAllStudents(){
		return studentRepository.findAll();
	}
	
	public Optional<Student> getStudentById(Long id){
		return studentRepository.findById(id);
	}
	
	public void addStudent(Student student) {
		studentRepository.save(student);
	}
	
	public void removeStudent(Long id) {
		Optional<Student> student = studentRepository.findById(id);
		studentRepository.delete(student.get());
	}
	
	public void updateStudent(Long id,Student student) {
		Optional<Student> u = studentRepository.findById(id);
		if(u.isPresent()){
			student.setId(u.get().getId());
			studentRepository.save(student);
		}
	}
	
	
	
	/*
	
	public void enrolleInFirstYear(Student student) {
		YearOfStudy yearOfStudy = yearOfStudyRepository.findFirstByNumberOfYear(1);
		StudentYear studentYear = new StudentYear();
		studentYear.setYearOfStudy(yearOfStudy);
		student.getStudentYears().add(studentYear);
		studentRepository.save(student);
	}
	

	public Student findByCardNumber(String cardNumber) {
		return studentRepository.findByCardNumber(cardNumber);
	}
	*/

	
}
