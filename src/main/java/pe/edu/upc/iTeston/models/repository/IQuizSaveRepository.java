package pe.edu.upc.iTeston.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.iTeston.models.entities.QuizzSave;

@Repository
public interface IQuizSaveRepository extends JpaRepository<QuizzSave, Integer> {

	List<QuizzSave>findByStudentId(String id);
	List<QuizzSave>findByQuizzId(String id);
}
