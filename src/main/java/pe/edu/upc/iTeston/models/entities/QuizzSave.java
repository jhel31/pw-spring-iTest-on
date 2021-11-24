package pe.edu.upc.iTeston.models.entities;


import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class QuizzSave {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idQuizzSave;

	private int result;

	private Date date;

	@OneToOne
	private Quiz quizz;
	
	@Transient
	List<ResultExercise> results;

	public QuizzSave(int idQuizzSave, int result, Date date, Quiz quizz, List<ResultExercise> results) {
		super();
		this.idQuizzSave = idQuizzSave;
		this.result = result;
		this.date = date;
		this.quizz = quizz;
		this.results = results;
	}

	public QuizzSave() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdQuizzSave() {
		return idQuizzSave;
	}

	public void setIdQuizzSave(int idQuizzSave) {
		this.idQuizzSave = idQuizzSave;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Quiz getQuizz() {
		return quizz;
	}

	public void setQuizz(Quiz quizz) {
		this.quizz = quizz;
	}

	public List<ResultExercise> getResults() {
		return results;
	}

	public void setResults(List<ResultExercise> results) {
		this.results = results;
	}
	
	
}
