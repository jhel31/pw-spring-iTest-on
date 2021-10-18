package pe.edu.upc.iTeston.business.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.iTeston.business.crud.FreemiumService;
import pe.edu.upc.iTeston.models.entities.Freemium;
import pe.edu.upc.iTeston.models.repository.FreemiumRepository;

@Service
public class FreemiumServiceImpl implements FreemiumService {

	@Autowired
	private FreemiumRepository freemiumRepository;

	@Override
	public JpaRepository<Freemium, String> getJpaRepository() {

		return freemiumRepository;
	}

}
