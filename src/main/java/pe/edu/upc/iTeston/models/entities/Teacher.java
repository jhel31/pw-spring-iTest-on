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
@Table(name = "Teachers")
public class Teacher {
	@NotNull
	@NotBlank
	@Size(max = 10)
	@Id
	@Column(name = "id_teacher", length = 10, nullable = false)
	private String id;
	
	@NotNull
	@NotBlank
	@Size(max = 30)
	@Column(name = "name_teacher", length = 30, nullable = false)
	private String name;
	
	@NotNull
	@NotBlank
	@Size(max = 30)
	@Column(name = "lastname_teacher", length = 30, nullable = false)
	private String lastname;
	
	@NotNull
	@NotBlank
	@Size(max = 100)
	@Column(name = "email_teacher", length = 100, nullable = false)
	private String email;
	

	@NotNull
	@Column(name = "document_experience", length = 30, nullable = false)
	private Boolean documentExperience;

	@OneToOne
	@JoinColumn(name = "virtualWallet_id", nullable = true)
	private VirtualWallet virtualWallet; // virtualWallet
	
	@ManyToOne
	@JoinColumn(name = "course_id", nullable = false)
	private Course course; // course_id
	
	@OneToOne
	private User user;
	
	@OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY)
	private List<QuestionBank> questionBanks;
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Teacher(String id, String name, String lastname, String email, String password, Boolean documentExperience,
			VirtualWallet virtualWallet, Course course, List<QuestionBank> questionBanks) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.documentExperience = documentExperience;
		this.virtualWallet = virtualWallet;
		this.course = course;
		this.questionBanks = questionBanks;
	}


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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public Boolean getDocumentExperience() {
		return documentExperience;
	}

	public void setDocumentExperience(Boolean documentExperience) {
		this.documentExperience = documentExperience;
	}

	public VirtualWallet getVirtualWallet() {
		return virtualWallet;
	}

	public void setVirtualWallet(VirtualWallet virtualWallet) {
		this.virtualWallet = virtualWallet;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public List<QuestionBank> getQuestionBanks() {
		return questionBanks;
	}

	public void setQuestionBanks(List<QuestionBank> questionBanks) {
		this.questionBanks = questionBanks;
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(course, documentExperience, email, id, lastname, name, questionBanks,
//				virtualWallet);
//	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Teacher other = (Teacher) obj;
		return Objects.equals(course, other.course) && Objects.equals(documentExperience, other.documentExperience)
				&& Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(lastname, other.lastname) && Objects.equals(name, other.name)
				&& Objects.equals(virtualWallet, other.virtualWallet);
	}

}
