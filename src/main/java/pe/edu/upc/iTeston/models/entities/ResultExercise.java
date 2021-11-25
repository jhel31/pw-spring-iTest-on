package pe.edu.upc.iTeston.models.entities;

public class ResultExercise {

	private Exercise exercise;
	private int result;

	public ResultExercise(Exercise exercise, int result) {
		super();
		this.exercise = exercise;
		this.result = result;
	}

	public ResultExercise() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Exercise getExercise() {
		return exercise;
	}

	public void setExercise(Exercise exercise) {
		this.exercise = exercise;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

}
