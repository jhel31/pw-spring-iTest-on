package pe.edu.upc.iTeston.models.repository;

import pe.edu.upc.iTeston.models.entities.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Integer>{

}
