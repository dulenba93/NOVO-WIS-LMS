package wis.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wis.domain.Country;
import wis.repository.CountryRepository;

@Service
public class CountryService {
	@Autowired
	CountryRepository cr;

	public CountryService() {
	}

	public List<Country> getCountry() {
		return cr.findAll();
	}

	public Country getCountry(Long id) {
		return cr.findById(id).orElse(null);
	}

	public void addCountry(Country country) {
		cr.save(country);
	}

	public void deleteCountry(Long id) {
		Optional<Country> country = cr.findById(id);
		cr.delete(country.get());
	}
	
	public void updateCountry(Long id, Country country) {
		Optional<Country> cntr = cr.findById(id);
		if(cntr.isPresent()) {
			country.setId(cntr.get().getId());
			cr.save(country);
		}
	}
}