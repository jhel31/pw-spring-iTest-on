package pe.edu.upc.iTeston.models.repository;

import pe.edu.upc.iTeston.models.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TeacherRepository extends JpaRepository<Teacher, String> {

}
