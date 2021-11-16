package pe.edu.upc.iTeston.business.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.iTeston.business.crud.UniversityDetailService;
import pe.edu.upc.iTeston.models.entities.UniversityDetail;
import pe.edu.upc.iTeston.models.repository.UniversityDetailRepository;
@Service
public class UniversityDetailServiceImpl implements UniversityDetailService{

	@Autowired
	private UniversityDetailRepository universityDetailRepository;
	
	@Override
	public JpaRepository<UniversityDetail, String> getJpaRepository() {
		return universityDetailRepository;
	}

}
