 package wis.service; 

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wis.domain.Address;
import wis.domain.Country;
import wis.domain.Place;
import wis.repository.AddressRepository;
import wis.repository.CountryRepository;
import wis.repository.PlaceRepository;

@Service
public class AddressService {
	@Autowired
	AddressRepository ar;
	@Autowired
	PlaceRepository pr; 
	@Autowired
	CountryRepository cr;
	@Autowired
	PlaceService placeService; 
	@Autowired
	CountryService countryService;
	

	public AddressService() {
	}

	public List<Address> getAddress() {
		return ar.findAll();
	}

	public Optional<Address> getAddress(Long id) {
		return ar.findById(id);
	}

	public void addAddress(Address address) {
		Optional<Country> country = cr.findByName(address.getPlace().getCountry().getName());
		Optional<Place> place = pr.findByName(address.getPlace().getName());
		
		if(place.isPresent()) {
			address.setPlace(place.get());
			ar.save(address);
		}else {
			if(country.isPresent()) {
				placeService.addPlace(address.getPlace());
				Optional<Place> p = pr.findByName(address.getPlace().getName());
				address.setPlace(p.get());
				ar.save(address);
				
			}else {
				countryService.addCountry(address.getPlace().getCountry());
				placeService.addPlace(address.getPlace());
				Optional<Place> p = pr.findByName(address.getPlace().getName());
				address.setPlace(p.get());
				ar.save(address);
			}
		}
	}

	public void deleteAddress(Long id) {
		Optional<Address> address = ar.findById(id);
		ar.delete(address.get());
	}
	
	public void updateAddress(Long id, Address address) {
		Optional<Address> adr = ar.findById(id);
		if(adr.isPresent()) {
			address.setId(adr.get().getId());
			ar.save(address);
		}
	}
}
