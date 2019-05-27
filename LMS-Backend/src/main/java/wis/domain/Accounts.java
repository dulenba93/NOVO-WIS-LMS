package wis.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Where;

@Entity
@Where(clause = "deleted = 'false'")
public class Accounts {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length=64, nullable = false)
	private String username;

	@Column(length=64, nullable = false)
	private String password;
	
	@NotNull
	private Boolean deleted = false;
	
	@Version
	private int version = 0;
	
	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
	private Set<AccountPermission> userPermissions;
	
	public Accounts() {
		
	}
	
	public Accounts(Long id, String username, String password, Set<AccountPermission> userPermissions) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.userPermissions = userPermissions;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
	public Set<AccountPermission> getUserPermissions() {
		return userPermissions;
	}

	public void setUserPermissions(Set<AccountPermission> userPermissions) {
		this.userPermissions = userPermissions;
	}


}
