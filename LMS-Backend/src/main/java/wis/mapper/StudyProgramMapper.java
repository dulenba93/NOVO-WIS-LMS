package wis.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import wis.domain.StudyProgram;

import wis.dto.StudyProgramDTO;


@Component
public class StudyProgramMapper implements Mapper<StudyProgram, StudyProgramDTO>  {
	
	@Autowired
	FacultyMapper facultyMapper;
	

	@Override
	public StudyProgramDTO toDTO(StudyProgram studyProgram) {
		// TODO Auto-generated method stub
		
		if(studyProgram == null) {
			return null;
		}
		
		StudyProgramDTO retVal = new StudyProgramDTO();
			retVal.setId(studyProgram.getId());
			retVal.setName(studyProgram.getName());
			retVal.setDescription(studyProgram.getDescription());
			retVal.setFaculty(facultyMapper.toDTO(studyProgram.getFaculty()));
			
			return retVal;
	}

	@Override
	public StudyProgram toEntity(StudyProgramDTO studyProgramDto) {
		// TODO Auto-generated method stub
		
		if(studyProgramDto == null) {
			return null;		
		}
		
		StudyProgram studyProgram = new StudyProgram();
		
		studyProgram.setId(studyProgramDto.getId());
		studyProgram.setDescription(studyProgramDto.getDescription());
		studyProgram.setFaculty(facultyMapper.toEntity(studyProgramDto.getFaculty()));
		studyProgram.setName(studyProgramDto.getName());

		return studyProgram;
	}

	@Override
	public List<StudyProgramDTO> toDTO(List<StudyProgram> studyProgram) {
		// TODO Auto-generated method stub
		if(studyProgram == null) {
			return null;
		}
		
		List<StudyProgramDTO > retVal = new ArrayList<StudyProgramDTO >();
		for (StudyProgram studyPrograms: studyProgram) {
			retVal.add(toDTO(studyPrograms));
		}
		return retVal;
	}

	@Override
	public Collection<StudyProgram> toEntityList(Collection<StudyProgramDTO> studyProgramDto) {
		// TODO Auto-generated method stub
		if(studyProgramDto == null) {
			return null;
		}
		
		Collection<StudyProgram> studyProgram = new ArrayList<StudyProgram>(studyProgramDto.size());
		for(StudyProgramDTO fDto: studyProgramDto) {
			studyProgram.add(toEntity(fDto));
		}
		
		return studyProgram;
	}

}
