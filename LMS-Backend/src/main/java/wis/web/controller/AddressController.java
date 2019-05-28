package wis.web.controller;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import wis.domain.Address;
import wis.domain.Place;
import wis.dto.AddressDTO;
import wis.mapper.AddressMapper;
import wis.service.AddressService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	AddressService as;
	
	@Autowired
	AddressMapper addressMapper;
	
	//@JsonView(HideOptionalProperties.class)
	@RequestMapping()
	public ResponseEntity<Iterable<AddressDTO>> getAllAddress() {
		List<Address> address = as.getAddress();
		return ResponseEntity.ok(addressMapper.toDTO(address));
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<Address> addAddress(@RequestBody Address address) {
		as.addAddress(address);
		return new ResponseEntity<Address>(address, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Address> updateAddress(@PathVariable Long id, @RequestBody Address address) {
		as.updateAddress(id, address);
		return new ResponseEntity<Address>(address, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public AddressDTO getAddressById(@PathVariable Long id) {
		Address address = as.getAddress(id).get();
		return addressMapper.toDTO(address);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Address> removeAddress(@PathVariable Long id) {
		try {
			as.deleteAddress(id);
		}catch (Exception e) {
			return new ResponseEntity<Address>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Address>(HttpStatus.NO_CONTENT);
	}
	
}

