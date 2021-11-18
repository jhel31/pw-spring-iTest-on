package pe.edu.upc.iTeston.models.entities;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity 
@Table(name = "Universities", 
       indexes = { @Index(columnList = "name_university", name = "Universities_index_name_university")})
public class University {

	@NotNull
	@NotBlank
	@Size(max = 10)
	@Id
	@Column(name = "id_university", length = 10, nullable = false)
	private String id;

	@NotNull
	@NotBlank
	@Size(max = 50)
	@Column(name = "name_university", length = 50, nullable = false)
	private String name;
	
	@OneToMany(mappedBy = "university", fetch = FetchType.LAZY)
	private List<Quiz> quizzes;
	
	@OneToMany(mappedBy = "university", fetch = FetchType.LAZY)
	private List<Career> careers;
	public University() {
		super();
		// TODO Auto-generated constructor stub
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
	public List<Quiz> getQuizzes() {
		return quizzes;
	}
	public void setQuizzes(List<Quiz> quizzes) {
		this.quizzes = quizzes;
	}
	public List<Career> getCareers() {
		return careers;
	}
	public void setCareers(List<Career> careers) {
		this.careers = careers;
	}
	@Override
	public int hashCode() {
		return Objects.hash(careers, id, name, quizzes);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		University other = (University) obj;
		return Objects.equals(careers, other.careers) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(quizzes, other.quizzes);
	}
	public University(@NotNull @NotBlank @Size(max = 10) String id, @NotNull @NotBlank @Size(max = 50) String name,
			List<Quiz> quizzes, List<Career> careers) {
		super();
		this.id = id;
		this.name = name;
		this.quizzes = quizzes;
		this.careers = careers;
	}

	
	
}
