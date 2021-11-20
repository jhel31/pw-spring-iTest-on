package pe.edu.upc.iTeston.models.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
	// EmbeddedId primary key
	@Id
	@Column(name = "user_id", length = 30, nullable = false)
	private String id;

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

	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Authority> authorities;
	
	@OneToOne(mappedBy = "user")
	private Student student; // virtualWallet

	@OneToOne(mappedBy = "user")
	private Teacher teacher; 
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public List<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}

	@Override
	public int hashCode() {
		return Objects.hash(authorities, enable, id, password, username);
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
		return Objects.equals(authorities, other.authorities) && Objects.equals(enable, other.enable)
				&& Objects.equals(id, other.id) && Objects.equals(password, other.password)
				&& Objects.equals(username, other.username);
	}

	public User(String id, @NotNull @NotBlank @Size(max = 30) String username,
			@NotNull @NotBlank @Size(max = 60) String password, Boolean enable, List<Authority> authority) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.enable = enable;
		this.authorities = authority;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(@NotNull @NotBlank @Size(max = 30) String username, @NotNull @NotBlank @Size(max = 60) String password,
			Student student) {
		this.id=student.getId();
		this.username = username;
		this.password = password;
		this.enable = true;
		this.student = student;
		this.authorities = new ArrayList<>();
		student.setUser(this);
		
	}

	public User(@NotNull @NotBlank @Size(max = 30) String username, @NotNull @NotBlank @Size(max = 60) String password,
			Teacher teacher) {
		this.id=teacher.getId();
		this.username = username;
		this.password = password;
		this.enable = true;
		this.teacher = teacher;
		this.authorities = new ArrayList<>();
		teacher.setUser(this);
		
	}

	public User(@NotNull @NotBlank @Size(max = 30) String username,
			@NotNull @NotBlank @Size(max = 60) String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public void addAuthority(String auth) {
		Authority authority = new Authority();
		authority.setAuthority(auth);
		authority.setUser(this);
		this.authorities.add( authority );
	}
	
}
