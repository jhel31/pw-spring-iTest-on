package pe.edu.upc.iTeston.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.iTeston.models.entities.Approval;

@Repository
public interface ApprovalRepository extends JpaRepository<Approval, String> {
	List<Approval> findByApprovalLevel(Integer level) throws Exception;
	
}
