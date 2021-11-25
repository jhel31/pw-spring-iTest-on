package pe.edu.upc.iTeston.models.entities;

import java.util.Date;
import java.util.List;

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


	public QuestionBank() {
		super();
		// TODO Auto-generated constructor stub
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


	public QuestionBank(@NotBlank @Size(max = 8) String id, @NotNull Quiz quiz, @NotNull Teacher teacher,
			@Size(max = 100) String description, @Max(9999) @Min(1) Integer results,
			@NotNull @NotBlank Date creationDate, List<Exercise> exercises, List<Approval> approvals) {
		super();
		this.id = id;
		this.quiz = quiz;
		this.teacher = teacher;
		this.description = description;
		this.results = results;
		this.creationDate = creationDate;
		this.exercises = exercises;
		this.approvals = approvals;
	}

	

}
