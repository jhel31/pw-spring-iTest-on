package pe.edu.upc.iTeston.business.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.iTeston.business.crud.ApprovalService;
import pe.edu.upc.iTeston.models.entities.Approval;
import pe.edu.upc.iTeston.models.repository.ApprovalRepository;

@Service
public class ApprovalServiceImpl implements ApprovalService {

	@Autowired
	private ApprovalRepository approvalRepository;
	
	@Override
	public JpaRepository<Approval, String> getJpaRepository() {
		
		return approvalRepository;
	}

	@Override
	public List<Approval> findByLevel(Integer level) throws Exception {
		// TODO Auto-generated method stub
		return approvalRepository.findByApprovalLevel(level);
	}

}
