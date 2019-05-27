package wis.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class AccountPermission {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Accounts account;
	
	@ManyToOne
	private Permission permission;
	
	public AccountPermission() {}
	
	public AccountPermission(Long id, Accounts account, Permission permission) {
		super();
		this.id = id;
		this.account = account;
		this.permission = permission;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Accounts getAccount() {
		return account;
	}

	public void setUser(Accounts account) {
		this.account = account;
	}

	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

}
