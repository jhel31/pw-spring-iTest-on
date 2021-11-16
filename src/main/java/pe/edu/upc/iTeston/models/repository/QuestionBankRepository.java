package pe.edu.upc.iTeston.models.repository;

import pe.edu.upc.iTeston.models.entities.QuestionBank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface QuestionBankRepository extends JpaRepository<QuestionBank, String>{

}
