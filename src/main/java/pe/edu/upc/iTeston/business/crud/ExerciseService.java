package pe.edu.upc.iTeston.business.crud;

import java.util.List;

import pe.edu.upc.iTeston.models.entities.Exercise;
import pe.edu.upc.iTeston.models.entities.ResultExercise;

public interface ExerciseService extends CrudService<Exercise, String>{

	List<ResultExercise> newQuizResults(String idQuiz);
	
}
