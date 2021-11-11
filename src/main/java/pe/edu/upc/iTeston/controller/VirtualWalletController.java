package pe.edu.upc.iTeston.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.iTeston.business.crud.VirtualWalletService;
import pe.edu.upc.iTeston.models.entities.VirtualWallet;


@Controller
@RequestMapping("/virtualWallets") 
@SessionAttributes("virtualWallet")
public class VirtualWalletController {
	@Autowired 
	private VirtualWalletService virtualWalletService;
//	@Autowired
//	private LoginService loginService;
	
	@GetMapping
	public String list(Model model ){
		
		try {
			List<VirtualWallet> virtualWallets=virtualWalletService.getAll();
			model.addAttribute("virtualWallets", virtualWallets);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "virtualWallets/list";//html
	}
	
//	@GetMapping("/edit")
//	public String edit(Model model) {
//		try {
//			loginService.getTeacher().setVirtualWallet();
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		
//		return "countries/edit";
//	}
	
	
}
