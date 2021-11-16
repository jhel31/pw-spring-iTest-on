package pe.edu.upc.iTeston.models.repository;



import pe.edu.upc.iTeston.models.entities.PaymentMethod;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PaymentMethodRepository extends JpaRepository <PaymentMethod, String> {
 
}
