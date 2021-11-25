package pe.edu.upc.iTeston.business.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.iTeston.business.crud.QuizSaveService;
import pe.edu.upc.iTeston.models.entities.Course;
import pe.edu.upc.iTeston.models.entities.QuizzSave;
import pe.edu.upc.iTeston.models.repository.CourseRepository;
import pe.edu.upc.iTeston.models.repository.IQuizSaveRepository;

@Service
public class QuizzSaveServiceImpl implements QuizSaveService {
	@Autowired
	private IQuizSaveRepository qsRepository;
	
	@Override
	public JpaRepository<QuizzSave, Integer> getJpaRepository() {
		return qsRepository;
	}

}
