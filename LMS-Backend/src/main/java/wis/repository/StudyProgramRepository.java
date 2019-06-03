package wis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import wis.domain.Faculty;
import wis.domain.StudyProgram;

public interface StudyProgramRepository extends JpaRepository<StudyProgram, Long>{
	
	
	List<StudyProgram> findAllByFacultyId(Long facultyId);

}
