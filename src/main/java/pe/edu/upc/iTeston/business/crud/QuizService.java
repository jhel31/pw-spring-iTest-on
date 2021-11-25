package pe.edu.upc.iTeston.business.crud;

import java.util.List;

import pe.edu.upc.iTeston.models.entities.Quiz;

public interface QuizService extends CrudService<Quiz, String>{
	List<Quiz> findByUniversityId(String id) throws Exception;
	List<Quiz> findBySubscriptionStudentId(String id) throws Exception;
}
