package wis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import wis.domain.Country;
 		
public interface CountryRepository extends JpaRepository<Country, Long>{

	Country findByName(String name);
}
