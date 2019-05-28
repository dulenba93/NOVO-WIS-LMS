package wis.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wis.domain.Student;
import wis.repository.StudentRepository;
import wis.repository.YearOfStudyRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	YearOfStudyRepository yearOfStudyRepository;

	public StudentService() {}
	
	public List<Student> getAllStudents(){//u maperu radimo sa listama pa moramo korisiti listu
		return studentRepository.findAll();
	}
	
	public Student getStudentById(Long id){//changed Optional argument, not to be used apparently
		return studentRepository.findById(id).orElse(null);//if not found, return null
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
