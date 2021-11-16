package pe.edu.upc.iTeston.business.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import pe.edu.upc.iTeston.business.crud.VirtualWalletService;
import pe.edu.upc.iTeston.models.entities.VirtualWallet;
import pe.edu.upc.iTeston.models.repository.VirtualWalletRepository;

@Service
public class VirtualWalletServiceImpl implements VirtualWalletService {

	@Autowired
	private VirtualWalletRepository virtualWalletRepository;

	@Override
	public JpaRepository<VirtualWallet, String> getJpaRepository() {

		return virtualWalletRepository;
	}

}
