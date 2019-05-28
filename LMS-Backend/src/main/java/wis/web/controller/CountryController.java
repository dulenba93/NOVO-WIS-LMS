package wis.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import wis.domain.Country;
import wis.domain.Student;
import wis.dto.CountryDTO;
import wis.mapper.CountryMapper;
import wis.service.CountryService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/country")
public class CountryController {
	@Autowired
	CountryService cs;
	
	@Autowired
	CountryMapper cmpr;
	
	@RequestMapping()
	public ResponseEntity<Iterable<CountryDTO>> getAllCountry() {
		List<Country> countries = cs.getCountry();
		return ResponseEntity.ok(cmpr.toDTO(countries));
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<Country> addCountry(@RequestBody Country country) {
		cs.addCountry(country);
		return new ResponseEntity<Country>(country, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Country> updateCountry(@PathVariable Long id, @RequestBody Country country) {
		cs.updateCountry(id, country);
		return new ResponseEntity<Country>(country, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public CountryDTO getCountryById(@PathVariable Long id) {
		Country country = cs.getCountry(id);
		return cmpr.toDTO(country);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Country> removeCountry(@PathVariable Long id) {
		try {
			cs.deleteCountry(id);
		}catch (Exception e) {
			return new ResponseEntity<Country>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Country>(HttpStatus.NO_CONTENT);
	}
	
}
