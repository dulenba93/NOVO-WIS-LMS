package wis.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class FacultyDTO {
	

	@JacksonXmlProperty(isAttribute = true)
	private Long id;
	@JacksonXmlProperty(isAttribute = true)
	private int version = 0;

	private String name;
	private String description;
//	private Collection<String> studyCourse;
	private UniversityDTO university;
	private AddressDTO address;
//	private Collection<String> teachers;

	
	public FacultyDTO() {}


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


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public UniversityDTO getUniversity() {
		return university;
	}


	public void setUniversity(UniversityDTO university) {
		this.university = university;
	}


	public AddressDTO getAddress() {
		return address;
	}


	public void setAddress(AddressDTO address) {
		this.address = address;
	}

	

}
