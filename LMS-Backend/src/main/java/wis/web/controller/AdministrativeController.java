package wis.web.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import wis.domain.Administrative;
import wis.dto.AdministrativeDTO;
import wis.mapper.AdministrativeMapper;
import wis.service.AccountsService;
import wis.service.AddressService;
import wis.service.AdministrativeService;

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
	
	@Autowired
	AdministrativeMapper admpr;
	
	@RequestMapping()
	public ResponseEntity<Iterable<AdministrativeDTO>> getAllTeacher() {
		List<Administrative> administration = ads.getAdminstrations();
		return ResponseEntity.ok(admpr.toDTO(administration));
	}
	
	@Transactional
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<Administrative> addAdministration(@RequestBody Administrative administration) {
		acs.addAccount(administration.getAccount());
		as.addAddress(administration.getAddress());
		ads.addAdministration(administration);
		return new ResponseEntity<Administrative>(administration, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Administrative> updateAdministration(@PathVariable Long id, @RequestBody Administrative administration) {
		ads.updateAdministration(id, administration);
		return new ResponseEntity<Administrative>(administration, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public AdministrativeDTO getAdministrationById(@PathVariable Long id) {
		Administrative administration = ads.getAdminstration(id);
		return admpr.toDTO(administration);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Administrative> removeAdministration(@PathVariable Long id) {
		try {
			ads.deleteAdministration(id);
		}catch (Exception e) {
			return new ResponseEntity<Administrative>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Administrative>(HttpStatus.NO_CONTENT);
	}
	
}

