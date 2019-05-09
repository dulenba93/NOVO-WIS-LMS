package wis.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import wis.domain.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users,Long> {
	
	Users findByUsername(String username);
	
	Optional<Users> findByUsernameAndPassword(String username,String password);
	
	Optional<Users> findById(Long id);

}
