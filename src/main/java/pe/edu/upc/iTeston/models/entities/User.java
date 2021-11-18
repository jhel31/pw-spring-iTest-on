package pe.edu.upc.iTeston.models.entities;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users", indexes = { @Index(columnList = "username", name = "user_index_username") })
public class User {
	// EmbeddedId primary key
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "user_id", columnDefinition = "Numeric(6)")
	private Integer id;

	@NotNull
	@NotBlank
	@Size(max = 30)
	@Column(name = "username", length = 30, nullable = false)
	private String username;
	
	@NotNull
	@NotBlank
	@Size(max = 60)
	@Column(name = "password", length = 60, nullable = false)
	private String password;

	@Column(name = "enable")
	private Boolean enable;

	@OneToMany
	@JoinColumn(name = "user")
	private List<Authority> authority;
	
	@OneToOne(mappedBy = "user")
	private Student student; // virtualWallet

	@OneToOne(mappedBy = "user")
	private Teacher teacher; 
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	public List<Authority> getAuthority() {
		return authority;
	}

	public void setAuthority(List<Authority> authority) {
		this.authority = authority;
	}

	@Override
	public int hashCode() {
		return Objects.hash(authority, enable, id, password, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(authority, other.authority) && Objects.equals(enable, other.enable)
				&& Objects.equals(id, other.id) && Objects.equals(password, other.password)
				&& Objects.equals(username, other.username);
	}

	public User(Integer id, @NotNull @NotBlank @Size(max = 30) String username,
			@NotNull @NotBlank @Size(max = 60) String password, Boolean enable, List<Authority> authority) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.enable = enable;
		this.authority = authority;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
