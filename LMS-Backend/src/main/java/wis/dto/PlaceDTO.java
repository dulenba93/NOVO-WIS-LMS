package wis.dto;

import java.util.Collection;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class PlaceDTO {
	
	@JacksonXmlProperty(isAttribute = true)
	private Long id;
	@JacksonXmlProperty(isAttribute = true)
	private int version = 0;
	
	private String name;
	
	private Collection<String> address;
	private CountryDTO countryDto;
	
	/////////////////////////////////////////////////
	
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public Collection<String> getAddress() {
		return address;
	}
	public void setAddress(Collection<String> address) {
		this.address = address;
	}
	public CountryDTO getCountryDto() {
		return countryDto;
	}
	public void setCountryDto(CountryDTO countryDto) {
		this.countryDto = countryDto;
	}



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
	
	public PlaceDTO() {
		super();
	}

}
