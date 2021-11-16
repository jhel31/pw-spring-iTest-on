package pe.edu.upc.iTeston.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.iTeston.models.entities.Career;
@Repository
public interface CareerRepository extends JpaRepository<Career, String> {
	
	List<Career> findByName(String name) throws Exception;
}
