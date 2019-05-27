package wis.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Permission {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)
	private String title;

	@OneToMany(mappedBy = "permission")
	private Set<AccountPermission> userPermissions;

	public Permission() {

	}

	public Permission(Long id, String title, Set<AccountPermission> userPermissions) {
		super();
		this.id = id;
		this.title = title;
		this.userPermissions = userPermissions;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<AccountPermission> getUserPermissions() {
		return userPermissions;
	}

	public void setUserPermissions(Set<AccountPermission> userPermissions) {
		this.userPermissions = userPermissions;
	}

}
