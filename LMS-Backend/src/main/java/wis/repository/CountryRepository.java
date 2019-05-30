package wis.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import wis.domain.Country;
 		
public interface CountryRepository extends JpaRepository<Country, Long>{

	Optional<Country> findByName(String name);
}
