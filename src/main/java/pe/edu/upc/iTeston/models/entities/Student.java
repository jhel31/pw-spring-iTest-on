package pe.edu.upc.iTeston.models.entities;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Students")
public class Student {

	@NotBlank
	@Id 
	@Column(name = "id_student", length = 20, nullable = false)
	private String id;

	@NotNull
	@NotBlank //garantiza tamaño de name no sea mayor de 30
	@Size (max=30)
	@Column(name = "name_student", length = 30)//validacion para bd
	private String name;

	@NotNull
	@NotBlank 
	@Size (max=100)
	@Column(name = "lastname_student", length = 100)
	private String lastname;

	@NotNull
	@NotBlank 
	@Size (max=40)
	@Column(name = "email_student", length = 40)
	private String email;

	@ManyToOne
	@JoinColumn(name = "id_freemium", nullable = false)
	private Freemium freemium;
	
	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
	private List<Comment> comments;
	
	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
	private List<Approval> approvals;
	
	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
	private List<Subscription> subscriptions;
	
	@OneToOne
	private User user;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public Freemium getFreemium() {
		return freemium;
	}

	public void setFreemium(Freemium freemium) {
		this.freemium = freemium;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Approval> getApprovals() {
		return approvals;
	}

	public void setApprovals(List<Approval> approvals) {
		this.approvals = approvals;
	}

	public List<Subscription> getSubscriptions() {
		return subscriptions;
	}

	public void setSubscriptions(List<Subscription> subscriptions) {
		this.subscriptions = subscriptions;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		return Objects.hash(approvals, comments, email, freemium, id, lastname, name, subscriptions, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(approvals, other.approvals) && Objects.equals(comments, other.comments)
				&& Objects.equals(email, other.email) && Objects.equals(freemium, other.freemium)
				&& Objects.equals(id, other.id) && Objects.equals(lastname, other.lastname)
				&& Objects.equals(subscriptions, other.subscriptions) && Objects.equals(user, other.user);
	}

	public Student(@NotBlank String id, @NotNull @NotBlank @Size(max = 30) String name,
			@NotNull @NotBlank @Size(max = 100) String lastname, @NotNull @NotBlank @Size(max = 40) String email,
			@NotNull @NotBlank @Size(max = 30) String password, Freemium freemium, List<Comment> comments,
			List<Approval> approvals, List<Subscription> subscriptions, User user) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.freemium = freemium;
		this.comments = comments;
		this.approvals = approvals;
		this.subscriptions = subscriptions;
		this.user = user;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
}
