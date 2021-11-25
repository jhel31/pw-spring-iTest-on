package pe.edu.upc.iTeston.models.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Approvals")
public class Approval {
	@NotNull
	@NotBlank
	@Size(max = 20)
	@Id
	@Column(name = "id_approval", length = 20, nullable = false)
	private String id;

	@Max(value = 5)
	@Min(value = 0)
	@Column(name = "level_approval")
	private Integer approvalLevel;
	
	@ManyToOne
	@JoinColumn(name = "id_student", nullable = true)
	private Student student;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_quizSave", nullable = true)
	private QuizzSave quizSave;

	@Column(name = "date_approval")
	@Temporal(TemporalType.DATE)
	private Date approvalDate;

	public Approval() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getApprovalLevel() {
		return approvalLevel;
	}

	public void setApprovalLevel(Integer approvalLevel) {
		this.approvalLevel = approvalLevel;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public QuizzSave getQuizSave() {
		return quizSave;
	}

	public void setQuizSave(QuizzSave quizSave) {
		this.quizSave = quizSave;
	}

	public Date getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate(Date approvalDate) {
		this.approvalDate = approvalDate;
	}

	public Approval(@NotNull @NotBlank @Size(max = 20) String id, @Max(5) @Min(0) Integer approvalLevel,
			Student student, QuizzSave quizSave, Date approvalDate) {
		super();
		this.id = id;
		this.approvalLevel = approvalLevel;
		this.student = student;
		this.quizSave = quizSave;
		this.approvalDate = approvalDate;
	}




}
