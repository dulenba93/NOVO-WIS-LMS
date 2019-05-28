package wis.web.controller;

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

import wis.domain.Place;
import wis.dto.PlaceDTO;
import wis.mapper.PlaceMapper;
import wis.service.PlaceService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/place")
public class PlaceController {
	
	@Autowired
	PlaceService ps;
	
	@Autowired
	PlaceMapper pmpr;
	
	@RequestMapping()
	public ResponseEntity<Iterable<PlaceDTO>> getAllPlace() {
		List<Place> places = ps.getPlace();
		return ResponseEntity.ok(pmpr.toDTO(places));
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<Place> addPlace(@RequestBody Place place) {
		ps.addPlace(place);
		return new ResponseEntity<Place>(place, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Place> updatePlace(@PathVariable Long id, @RequestBody Place place) {
		ps.updatePlace(id, place);
		return new ResponseEntity<Place>(place, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public PlaceDTO getPlaceById(@PathVariable Long id) {
		Place place = ps.getPlace(id);
		return pmpr.toDTO(place);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Place> removePlace(@PathVariable Long id) {
		try {
			ps.deletePlace(id);
		}catch (Exception e) {
			return new ResponseEntity<Place>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Place>(HttpStatus.NO_CONTENT);
	}
	
}
