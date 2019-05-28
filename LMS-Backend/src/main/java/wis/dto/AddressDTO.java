package wis.dto;

import java.util.Collection;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;



public class AddressDTO {
	
	@JacksonXmlProperty(isAttribute = true)
	private Long id;
	private String street;
	private String number;
	private PlaceDTO placeDto;
	
	//private Collection<String> student;
	//private Collection<String> teacher;
	
	public AddressDTO(){}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public PlaceDTO getPlaceDto() {
		return placeDto;
	}

	public void setPlaceDto(PlaceDTO placeDto) {
		this.placeDto = placeDto;
	}
	
	
}
