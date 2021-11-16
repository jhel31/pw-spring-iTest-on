package pe.edu.upc.iTeston.business.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.iTeston.business.crud.QuestionBankService;
import pe.edu.upc.iTeston.models.entities.QuestionBank;
import pe.edu.upc.iTeston.models.repository.QuestionBankRepository;

@Service
public class QuestionBankServiceImpl implements QuestionBankService{

	@Autowired
	private QuestionBankRepository questionBankRepository;
	
	@Override
	public JpaRepository<QuestionBank, String> getJpaRepository() {
		// TODO Auto-generated method stub
		return questionBankRepository;
	}

}
