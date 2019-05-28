package wis.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import wis.domain.Faculty;
import wis.dto.FacultyDTO;


@Component
public class FacultyMapper implements Mapper<Faculty, FacultyDTO>  {
	
	@Autowired
	AddressMapper addressMapper;
	
	@Autowired
	UniversityMapper universityMapper;

	@Override
	public FacultyDTO toDTO(Faculty faculty) {
		// TODO Auto-generated method stub
		
		if(faculty == null) {
			return null;
		}
		
		FacultyDTO retVal = new FacultyDTO();
			retVal.setId(faculty.getId());
			retVal.setName(faculty.getName());
			retVal.setDescription(faculty.getDescription());
			retVal.setAddress(addressMapper.toDTO(faculty.getAddress()));
			retVal.setUniversity(universityMapper.toDTO(faculty.getUniversity()));
			
			return retVal;
	}

	@Override
	public Faculty toEntity(FacultyDTO facultyDto) {
		// TODO Auto-generated method stub
		
		if(facultyDto == null) {
			return null;		
		}
		
		Faculty faculty = new Faculty();
		
		faculty.setId(facultyDto.getId());
		faculty.setAddress(addressMapper.toEntity(facultyDto.getAddress()));
		faculty.setDescription(facultyDto.getDescription());
		faculty.setUniversity(universityMapper.toEntity(facultyDto.getUniversity()));
		faculty.setName(facultyDto.getName());
		faculty.setVersion(facultyDto.getVersion());
		return faculty;
	}

	@Override
	public List<FacultyDTO> toDTO(List<Faculty> faculty) {
		// TODO Auto-generated method stub
		if(faculty == null) {
			return null;
		}
		
		List<FacultyDTO > retVal = new ArrayList<FacultyDTO >();
		for (Faculty faculties: faculty) {
			retVal.add(toDTO(faculties));
		}
		return retVal;
	}

	@Override
	public Collection<Faculty> toEntityList(Collection<FacultyDTO> facultyDto) {
		// TODO Auto-generated method stub
		if(facultyDto == null) {
			return null;
		}
		
		Collection<Faculty> faculty = new ArrayList<Faculty>(facultyDto.size());
		for(FacultyDTO fDto: facultyDto) {
			faculty.add(toEntity(fDto));
		}
		
		return faculty;
	}

}
