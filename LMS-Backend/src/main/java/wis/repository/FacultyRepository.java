package wis.repository;

import java.util.List;
import java.util.Observable;

import org.springframework.data.jpa.repository.JpaRepository;

import wis.domain.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Long>{
	
	List<Faculty> findAllByUniversityId(long universityId);

}
