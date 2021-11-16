package pe.edu.upc.iTeston.models.repository;

import java.util.List;

import pe.edu.upc.iTeston.models.entities.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UniversityRepository extends JpaRepository<University, String> {

	List<University>findByName(String name)throws Exception;
	
}
