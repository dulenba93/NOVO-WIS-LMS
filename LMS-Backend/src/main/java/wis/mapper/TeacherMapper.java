package wis.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import wis.domain.Teacher;
import wis.dto.StudentDTO;
import wis.dto.TeacherDTO;

@Component
public class TeacherMapper implements Mapper<Teacher, TeacherDTO>{

	@Override
	public TeacherDTO toDTO(Teacher entity) {
		if (entity == null) {
			return null;
		}
		
		TeacherDTO retVal = new TeacherDTO();
		
		retVal.setId(entity.getId());
		retVal.setEmail(entity.getEmail());
		retVal.setFirstName(entity.getFirstName());
		retVal.setLastName(entity.getLastName());
		retVal.setPersonalIdentificationNumber(entity.getPersonalIdentificationNumber());
		
		return retVal;
	}

	@Override
	public Teacher toEntity(TeacherDTO edto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TeacherDTO> toDTO(List<Teacher> entityList) {
		if (entityList == null) {
			return null;
		}
		
		List<TeacherDTO> list = new ArrayList<TeacherDTO>(entityList.size());
		for (Teacher teacher : entityList) {
			list.add(toDTO(teacher));
		}
		
		return list;
	}

	@Override
	public Collection<Teacher> toEntityList(Collection<TeacherDTO> edtos) {
		// TODO Auto-generated method stub
		return null;
	}

}
