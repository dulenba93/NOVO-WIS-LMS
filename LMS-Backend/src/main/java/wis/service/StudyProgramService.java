package wis.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wis.domain.Faculty;
import wis.domain.StudyProgram;
import wis.repository.FacultyRepository;
import wis.repository.StudyProgramRepository;

@Service
public class StudyProgramService {
	@Autowired
	StudyProgramRepository sr;
	
	@Autowired
	FacultyRepository fr;

	public StudyProgramService() {
	}

	public List<StudyProgram> getStudyProgram() {
		return sr.findAll();
	}

	public Optional<StudyProgram> getStudyProgram(Long id) {
		return sr.findById(id);
	}

	public void addStudyProgram(StudyProgram studyprogram) {
		Optional<Faculty> faculty = fr.findById(studyprogram.getFaculty().getId());
		if (faculty.isPresent()) {
			studyprogram.setFaculty(faculty.get());
			sr.save(studyprogram);			
		}

	}
	
	public List<StudyProgram> getAllByFacultyId(Long facultyId){
		return sr.findAllByFacultyId(facultyId);
	}

	public void deleteStudyProgram(Long id) {
		Optional<StudyProgram> studyprogram = sr.findById(id);
		sr.delete(studyprogram.get());
	}
	
	public void updateStudyProgram(Long id, StudyProgram studyProgram) {
		Optional<StudyProgram> stdps = sr.findById(id);
		if(stdps.isPresent()) {
			studyProgram.setId(stdps.get().getId());
			sr.save(studyProgram);
		}
	}
}