package pe.edu.upc.iTeston.business.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.iTeston.business.crud.SubscriptionService;
import pe.edu.upc.iTeston.models.entities.Subscription;
import pe.edu.upc.iTeston.models.repository.SubscriptionRepository;
@Service
public class SubscriptionServiceImpl implements SubscriptionService{

	
	@Autowired
	private SubscriptionRepository subscriptionRepository;
	@Override
	public JpaRepository <Subscription, Integer> getJpaRepository() {
		return subscriptionRepository;
	}

}
