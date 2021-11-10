package pe.edu.upc.iTeston.models.entities;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Question_Banks")
public class QuestionBank {
	@NotBlank
	@Size(max = 8)
	@Id
	@Column(name = "id_question_bank", length = 8, nullable = false)
	private String id;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_quiz", nullable = false)
	private Quiz quiz;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_teacher", nullable = false)
	private Teacher teacher;

	@Size(max = 100)
	@Column(name = "description", length = 100)
	private String description;

	@Max(value = 9999)
	@Min(value = 1)
	@Column(name = "results", nullable = false)
	private Integer results;

	@NotNull
	@NotBlank
	@Column(name = "creation_date",nullable = false)
	@Temporal(TemporalType.DATE)
	private Date creationDate;

	@OneToMany(mappedBy = "questionBank")
	private List<Exercise> exercises;

	@OneToMany(mappedBy = "questionBank")
	private List<Approval> approvals;

	@OneToMany(mappedBy = "questionBank")
	private List<Comment> comments;

	public QuestionBank() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QuestionBank(String id, Quiz quiz, Teacher teacher, String description, Integer results, Date creationDate,
			List<Exercise> exercises, List<Approval> approvals, List<Comment> comments) {
		super();
		this.id = id;
		this.quiz = quiz;
		this.teacher = teacher;
		this.description = description;
		this.results = results;
		this.creationDate = creationDate;
		this.exercises = exercises;
		this.approvals = approvals;
		this.comments = comments;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getResults() {
		return results;
	}

	public void setResults(Integer results) {
		this.results = results;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public List<Exercise> getExercises() {
		return exercises;
	}

	public void setExercises(List<Exercise> exercises) {
		this.exercises = exercises;
	
	}
	public List<Approval> getApprovals() {
		return approvals;
	}

	public void setApprovals(List<Approval> approvals) {
		this.approvals = approvals;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	
	
	
	
	public Integer getQuantityExercise(){//Cantidad de ejercicios

		return exercises.size();
	}
	
	
	public float getPromApprovals() {
		int suma=0;
		float promedio=0;
		for(int i=0; i<approvals.size(); i++) {//propiedad de cantidad de aprobación, recorre datos
			suma+=approvals.get(i).getApprovalLevel();
			promedio=(suma/approvals.size());
		}
		return promedio;
	}
	

	
	
	
	
	
	
	
	
	
	

	@Override
	public int hashCode() {
		return Objects.hash(approvals, comments, creationDate, description, exercises, id, quiz, results, teacher);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QuestionBank other = (QuestionBank) obj;
		return Objects.equals(approvals, other.approvals) && Objects.equals(comments, other.comments)
				&& Objects.equals(creationDate, other.creationDate) && Objects.equals(description, other.description)
				&& Objects.equals(exercises, other.exercises) && Objects.equals(id, other.id)
				&& Objects.equals(quiz, other.quiz) && Objects.equals(results, other.results)
				&& Objects.equals(teacher, other.teacher);
	}

}
