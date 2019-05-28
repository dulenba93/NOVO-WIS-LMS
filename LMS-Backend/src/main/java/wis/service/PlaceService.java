package wis.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wis.domain.Country;
import wis.domain.Place;
import wis.repository.CountryRepository;
import wis.repository.PlaceRepository;

@Service
public class PlaceService {
	
	@Autowired
	PlaceRepository pr;
	
	@Autowired
	CountryRepository cr;
	

	public PlaceService() {
	}

	public List<Place> getPlace() {
		return pr.findAll();
	}

	public Place getPlace(Long id) {
		return pr.findById(id).orElse(null);
	}

	public void addPlace(Place place) {
		//treba voditi racuna kada se pokusa sa dodavanjem zemlje koja nije uneta u sistem
		Country country = cr.findByName(place.getCountry().getName());
		place.setCountry(country);
		pr.save(place);
	}

	public void deletePlace(Long id) {
		Optional<Place> place = pr.findById(id);
		pr.delete(place.get());
	}
	
	public void updatePlace(Long id, Place place) {
		Optional<Place> plc = pr.findById(id);
		if(plc.isPresent()) {
			place.setId(plc.get().getId());
			pr.save(place);
		}
	}
	
	
}