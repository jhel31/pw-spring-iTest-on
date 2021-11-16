package pe.edu.upc.iTeston.business.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.iTeston.business.crud.PaymentMethodService;
import pe.edu.upc.iTeston.models.entities.PaymentMethod;
import pe.edu.upc.iTeston.models.repository.PaymentMethodRepository;
@Service
public class PaymentMethodServiceImpl implements PaymentMethodService {

	@Autowired
	private PaymentMethodRepository paymentMethodRepository;
	
	@Override
	public JpaRepository<PaymentMethod, String> getJpaRepository() {
		return paymentMethodRepository ;
	}

}
