package pe.edu.upc.iTeston.business.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.iTeston.business.crud.CareerService;
import pe.edu.upc.iTeston.models.entities.Career;
import pe.edu.upc.iTeston.models.repository.CareerRepository;

@Service
public class CareerServiceImpl implements CareerService {

	@Autowired
	private CareerRepository careerRepository;

	@Override
	public JpaRepository<Career, String> getJpaRepository() {
		return careerRepository;
	}

	@Override
	public List<Career> findByName(String name) throws Exception {
		return careerRepository.findByName(name);
	}

}
