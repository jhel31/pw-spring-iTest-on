package pe.edu.upc.iTeston.models.repository;

import pe.edu.upc.iTeston.models.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

}
