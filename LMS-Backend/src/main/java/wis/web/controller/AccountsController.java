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

import wis.domain.Accounts;
import wis.service.AccountsService;
import wis.service.AddressService;
import wis.utils.View.HideOptionalProperties;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/accounts")
public class AccountsController{

	@Autowired
	AccountsService acs;
	
	@Autowired
	AddressService as;
	
	@JsonView(HideOptionalProperties.class)
	@RequestMapping()
	public ResponseEntity<Iterable<Accounts>> getAllAccounts() {
		return new ResponseEntity<Iterable<Accounts>>(acs.getAllAccounts(), HttpStatus.OK);
	}

	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<Accounts> addAccount(@RequestBody Accounts account) {
		acs.addAccount(account);
		return new ResponseEntity<Accounts>(account, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Accounts> updateAccount(@PathVariable Long id, @RequestBody Accounts account) {
		acs.updateAccount(id, account);
		return new ResponseEntity<Accounts>(account, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Accounts> getAccountById(@PathVariable Long id) {
		Optional<Accounts> account = acs.getAccountById(id);
		if(account.isPresent()) {
			return new ResponseEntity<Accounts>(account.get(), HttpStatus.OK);
		}
		return new ResponseEntity<Accounts>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Accounts> removeAccount(@PathVariable Long id) {
		try {
			acs.removeAccount(id);
		}catch (Exception e) {
			return new ResponseEntity<Accounts>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Accounts>(HttpStatus.NO_CONTENT);
	}
}
