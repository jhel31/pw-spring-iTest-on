package pe.edu.upc.iTeston.models.entities;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Comments")
public class Comment {
	
	@NotNull
	@NotBlank
	@Size(max = 20)
	@Id
	@Column(name = "id_comment", length = 20, nullable = false)
	private String id;

	@NotNull
	@NotBlank
	@Size(max = 1000)
	@Column(name = "description_comment", length = 1000, nullable = false)
	private String description;

	@Column(name = "date_comment", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date date;

	@ManyToOne
	@JoinColumn(name = "id_student", nullable = false)
	private Student student;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_question_bank", nullable = true)
	private QuestionBank questionBank;

	public Comment(String id, String description, Date date, Student student, QuestionBank questionBank) {
		super();
		this.id = id;
		this.description = description;
		this.date = date;
		this.student = student;
		this.questionBank = questionBank;
	}

	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, description, id, questionBank, student);
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public QuestionBank getQuestionBank() {
		return questionBank;
	}

	public void setQuestionBank(QuestionBank questionBank) {
		this.questionBank = questionBank;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comment other = (Comment) obj;
		return Objects.equals(date, other.date) && Objects.equals(description, other.description)
				&& Objects.equals(id, other.id) && Objects.equals(questionBank, other.questionBank)
				&& Objects.equals(student, other.student);
	}



}
