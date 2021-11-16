package pe.edu.upc.iTeston.models.repository;

import pe.edu.upc.iTeston.models.entities.Freemium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface FreemiumRepository extends JpaRepository<Freemium, String> {

}
