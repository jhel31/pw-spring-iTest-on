package pe.edu.upc.iTeston.models.repository;

import pe.edu.upc.iTeston.models.entities.VirtualWallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface VirtualWalletRepository extends JpaRepository<VirtualWallet, String> {

}
