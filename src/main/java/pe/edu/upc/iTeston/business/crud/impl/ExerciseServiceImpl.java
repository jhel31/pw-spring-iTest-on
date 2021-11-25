package pe.edu.upc.iTeston.business.crud.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.iTeston.business.crud.ExerciseService;
import pe.edu.upc.iTeston.models.entities.Exercise;
import pe.edu.upc.iTeston.models.entities.ResultExercise;
import pe.edu.upc.iTeston.models.repository.ExerciseRepository;

@Service
public class ExerciseServiceImpl implements ExerciseService {

	@Autowired
	private ExerciseRepository exerciseRepository;

	@Override
	public JpaRepository<Exercise, String> getJpaRepository() {
		return exerciseRepository;
	}
	
	@Override
	public List<ResultExercise> newQuizResults(String idQuiz) {
		List<Exercise> exercises = exerciseRepository.findByQuestionBankQuizId(idQuiz);
		List<ResultExercise> results = new ArrayList<ResultExercise>();
		
		for(int i=0; i<exercises.size(); i++) {
			results.add(new ResultExercise(exercises.get(i), 0));
		}
		return results;
	}
	
	

}
