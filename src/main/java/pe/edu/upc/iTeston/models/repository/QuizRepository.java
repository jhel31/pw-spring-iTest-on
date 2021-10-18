package pe.edu.upc.iTeston.models.repository;

import pe.edu.upc.iTeston.models.entities.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface QuizRepository extends JpaRepository<Quiz, String> {

}
