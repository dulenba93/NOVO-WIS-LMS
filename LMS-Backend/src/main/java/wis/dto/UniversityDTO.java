package wis.dto;

import java.util.Collection;
import java.util.Date;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class UniversityDTO {

	@JacksonXmlProperty(isAttribute = true)
	private Long id;
	@JacksonXmlProperty(isAttribute = true)
	private int version = 0;
	private String name;
	private Date establishmentDate;
	private String description;
	//private Collection<String> faculties;
	//private Collection<String> teachers;
	private AddressDTO address;
	
	public UniversityDTO() {}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getEstablishmentDate() {
		return establishmentDate;
	}

	public void setEstablishmentDate(Date establishmentDate) {
		this.establishmentDate = establishmentDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public AddressDTO getAddress() {
		return address;
	}

	public void setAddress(AddressDTO address) {
		this.address = address;
	}


	
}
