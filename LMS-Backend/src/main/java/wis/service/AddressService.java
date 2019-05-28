 package wis.service; 

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wis.domain.Address;
import wis.domain.Place;
import wis.repository.AddressRepository;
import wis.repository.PlaceRepository;

@Service
public class AddressService {
	@Autowired
	AddressRepository ar;
	@Autowired
	PlaceRepository pr; 

	public AddressService() {
	}

	public List<Address> getAddress() {
		return ar.findAll();
	}

	public Optional<Address> getAddress(Long id) {
		return ar.findById(id);
	}

	public void addAddress(Address address) {
		Place place = pr.findByName(address.getPlace().getName());
		address.setPlace(place);
		ar.save(address);
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
