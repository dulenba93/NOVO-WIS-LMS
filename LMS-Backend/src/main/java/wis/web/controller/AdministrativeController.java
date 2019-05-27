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
import wis.domain.Teacher;
import wis.service.AccountsService;
import wis.service.AddressService;
import wis.service.AdministrativeService;
import wis.service.TeacherService;
import wis.utils.View.HideOptionalProperties;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/administrative")
public class AdministrativeController {
	
	@Autowired
	AdministrativeService ads;
	
	@Autowired
	AddressService as;
	
	@Autowired
	AccountsService acs;
	
	@JsonView(HideOptionalProperties.class)
	@RequestMapping()
	public ResponseEntity<Iterable<Administration>> getAllTeacher() {
		return new ResponseEntity<Iterable<Administration>>(ads.getAdminstrations(), HttpStatus.OK);
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<Administration> addAdministration(@RequestBody Administration administration) {
		acs.addAccount(administration.getAccount());
		as.addAddress(administration.getAddress());
		ads.addAdministration(administration);
		return new ResponseEntity<Administration>(administration, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Administration> updateAdministration(@PathVariable Long id, @RequestBody Administration administration) {
		ads.updateAdministration(id, administration);
		return new ResponseEntity<Administration>(administration, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Administration> getAdministrationById(@PathVariable Long id) {
		Optional<Administration> administration = ads.getAdminstration(id);
		if(administration.isPresent()) {
			return new ResponseEntity<Administration>(administration.get(), HttpStatus.OK);
		}
		return new ResponseEntity<Administration>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Administration> removeAdministration(@PathVariable Long id) {
		try {
			ads.deleteAdministration(id);
		}catch (Exception e) {
			return new ResponseEntity<Administration>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Administration>(HttpStatus.NO_CONTENT);
	}
	
}

