package pe.edu.upc.iTeston.business.crud.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.iTeston.business.crud.UniversityService;
import pe.edu.upc.iTeston.models.entities.University;
import pe.edu.upc.iTeston.models.repository.UniversityRepository;
@Service
public class UniversityServiceImpl implements UniversityService{

	@Autowired
	private UniversityRepository universityRepository; 
	@Override
	public JpaRepository<University, String> getJpaRepository() {
		return universityRepository;
	}

	@Override
	public List<University> findByName(String name) throws Exception {
		return universityRepository.findByName(name);
	}

	@Override
	public Optional<University> findById(String idUniversity) throws Exception {
		return universityRepository.findById(idUniversity);
	}
	
}
