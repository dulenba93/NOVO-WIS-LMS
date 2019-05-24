package wis.web.controller;

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

import com.fasterxml.jackson.annotation.JsonView;

import wis.domain.Administration;
import wis.service.AdministrationService;
import wis.utils.View.HideOptionalProperties;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/administrator")
public class AdministrationController {
	
	@Autowired
	AdministrationService as;
	
	@JsonView(HideOptionalProperties.class)
	@RequestMapping()
	public ResponseEntity<Iterable<Administration>> getAllAdmin() {
		return new ResponseEntity<Iterable<Administration>>(as.getAllUsers(), HttpStatus.OK);
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<Administration> addUser(@RequestBody Administration administration) {
		as.addUser(administration);
		return new ResponseEntity<Administration>(administration, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Administration> updateAdmin(@PathVariable Long id, @RequestBody Administration administration) {
		as.updateUser(id, administration);
		return new ResponseEntity<Administration>(administration, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Administration> getAdminById(@PathVariable Long id) {
		Optional<Administration> admin = as.getUsersById(id);
		if(admin.isPresent()) {
			return new ResponseEntity<Administration>(admin.get(), HttpStatus.OK);
		}
		return new ResponseEntity<Administration>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Administration> removeAdmin(@PathVariable Long id) {
		try {
			as.removeUser(id);
		}catch (Exception e) {
			return new ResponseEntity<Administration>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Administration>(HttpStatus.NO_CONTENT);
	}

}
