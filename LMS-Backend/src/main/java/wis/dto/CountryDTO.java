package wis.dto;

import java.util.Collection;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import wis.domain.Place;

public class CountryDTO {
	
	@JacksonXmlProperty(isAttribute = true)
	private Long id;
	private String name;
	//private Collection<String> places;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	/*
	public Collection<String> getPlaces() {
		return places;
	}
	public void setPlaces(Collection<String> places) {
		this.places = places;
	}
	*/
	public CountryDTO() {
		super();
	}

}
