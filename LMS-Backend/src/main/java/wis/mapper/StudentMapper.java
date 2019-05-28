package wis.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import wis.domain.Student;
import wis.dto.StudentDTO;

@Component
public class StudentMapper implements Mapper<Student, StudentDTO> {
	
	public Student toEntity(StudentDTO studentDTO) {
		if (studentDTO == null) {
	    	return null;
		}
		Student retVal = new Student();

		retVal.setId(studentDTO.getId());
		return retVal;
	}
	
	public Collection<Student> toEntityList(Collection<StudentDTO> dtoList) {
	    if ( dtoList == null ) {
	        return null;
	    }
	    Collection<Student> collection = new ArrayList<Student>(dtoList.size());
	    for (StudentDTO student : dtoList) {
	        collection.add(toEntity(student));
	    }

	    return collection;
	}

	public StudentDTO toDTO(Student entity) {
		if (entity == null) {
		    return null;
		}

		StudentDTO retVal = new StudentDTO();

		retVal.setId(entity.getId());
		retVal.setEmail(entity.getEmail());
		retVal.setFirstName(entity.getFirstName());
		retVal.setLastName(entity.getLastName());
		retVal.setCardNumber(entity.getCardNumber());

		return retVal;
	}

	@Override
	public List<StudentDTO> toDTO(List<Student> entityList) {
		 if ( entityList == null ) {
		        return null;
		    }

		    List<StudentDTO> list = new ArrayList<StudentDTO>(entityList.size());
		    for (Student student : entityList) {
		    	list.add(toDTO(student));
		    }

		    return list;
	}


}
