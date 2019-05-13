package wis.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Where;

@Entity
@Where(clause = "deleted = 'false'")
public class Administration {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 64)
	private String personalIdentificationNumber;
	
	@Column(length = 64)
	private String firstName;

	@Column(length = 64)
	private String lastName;
	
	@Column(length=64, nullable = false)
	private String username;

	@Column(length=64, nullable = false)
	private String password;

	@Column(length=64, nullable = false)
	private String email;
	
	@OneToOne
	@JoinColumn(name="addressId")
	private Address address;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getPersonalIdentificationNumber() {
		return personalIdentificationNumber;
	}

	public void setPersonalIdentificationNumber(String personalIdentificationNumber) {
		this.personalIdentificationNumber = personalIdentificationNumber;
	}

	public Administration() {}
}
