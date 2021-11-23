package pe.edu.upc.iTeston.models.repository;

import pe.edu.upc.iTeston.models.entities.Quiz;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface QuizRepository extends JpaRepository<Quiz, String> {
	List<Quiz> findByUniversityId(String id) throws Exception;
	
	List<Quiz> findBySubscriptionStudentId(String id) throws Exception;
}
