package pe.edu.upc.iTeston.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.iTeston.business.crud.TeacherService;
import pe.edu.upc.iTeston.business.crud.VirtualWalletService;
import pe.edu.upc.iTeston.business.crud.impl.LoginService;
import pe.edu.upc.iTeston.models.entities.Teacher;
import pe.edu.upc.iTeston.models.entities.VirtualWallet;

@Controller
@RequestMapping("/virtualWallets")
@SessionAttributes("virtualWallet")
public class VirtualWalletController {

	@Autowired
	private VirtualWalletService virtualWalletService;
	@Autowired
	private LoginService loginService;
	@Autowired
	private TeacherService teacherService;
	@GetMapping("/saldo")
	public String showMoney(Model model) throws Exception { // quitar
		Teacher teacher = loginService.getTeacher();
		Float saldo = teacher.getVirtualWallet().getSaldo();
		model.addAttribute("saldo", saldo);
		model.addAttribute("walletRetiro", new VirtualWallet());
		return "virtualWallet";
	}

	@PostMapping("/edit")
	public String virtualWallet(Model model, @ModelAttribute("walletRetiro") VirtualWallet walletRetiro,
			BindingResult bindingResult) throws Exception { //
		Teacher teacher = loginService.getTeacher();
		Float saldo = teacher.getVirtualWallet().getSaldo();
		teacher.getVirtualWallet().setSaldo(saldo-walletRetiro.getSaldo());
		virtualWalletService.update(teacher.getVirtualWallet());
		loginService.setTeacher(teacher);
		
		return "redirect:/virtualWallets/saldo";
	}

}
