package wis.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Where;

@Entity
@Where(clause = "deleted = 'false'")
@Table(name = "users")
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
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
	
	@Column(length=64, nullable = false)
	private String role;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Teacher teacher;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Student student;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Admin admin;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Administration administration;

	@NotNull
	private Boolean deleted = false;
	
	@Version
	private int version = 0;
	
	public Users() {}

	public Users(String firstName, String lastName, String username, String password, String email, String role){
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
	}
	

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
	
	
	
	
	
	
}
