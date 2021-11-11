package pe.edu.upc.iTeston.business.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.iTeston.business.crud.QuizService;
import pe.edu.upc.iTeston.models.entities.Quiz;
import pe.edu.upc.iTeston.models.repository.QuizRepository;

@Service
public class QuizServiceImpl implements QuizService {

	@Autowired
	private QuizRepository quizRepository;
	

	@Override
	public JpaRepository<Quiz, String> getJpaRepository() {
		
		return quizRepository;
	}


	@Override
	public List<Quiz> findByUniversityId(String id) throws Exception {
		
		return quizRepository.findByUniversityId(id);
	}

	

}
