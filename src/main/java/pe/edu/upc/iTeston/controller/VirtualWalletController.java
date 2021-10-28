package pe.edu.upc.iTeston.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.iTeston.business.crud.VirtualWalletService;
import pe.edu.upc.iTeston.models.entities.VirtualWallet;

@Controller
@RequestMapping("/virtualWallets") //como me dirijo a apartado html
public class VirtualWalletController {
	@Autowired 
	private VirtualWalletService virtualWalletService;
	
	@GetMapping
	public String list(Model model ){
		
		try {
			List<VirtualWallet> virtualWallets=virtualWalletService.getAll();
			model.addAttribute("virtualWallets", virtualWallets);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "billeteraVirtual??/list";//html
	}
	
	
	public String edit(Model model, @PathVariable("id") String id) {
		try {
			if (virtualWalletService.existsById(id)) { //si existe hace tal
				Optional<VirtualWallet>optional=virtualWalletService.findById(id);
				model.addAttribute("virtualWallet",optional.get());
			}
		}catch (Exception e){
			//si no existe
		}
		return "billeteraVirtual??/list";//html
	}
}
