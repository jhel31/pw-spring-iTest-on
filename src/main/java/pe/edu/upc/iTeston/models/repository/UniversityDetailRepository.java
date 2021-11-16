package pe.edu.upc.iTeston.models.repository;

import pe.edu.upc.iTeston.models.entities.UniversityDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UniversityDetailRepository extends JpaRepository<UniversityDetail, String> {

}
