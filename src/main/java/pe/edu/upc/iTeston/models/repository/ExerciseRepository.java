package pe.edu.upc.iTeston.models.repository;

import pe.edu.upc.iTeston.models.entities.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, String>{

}
