package pe.edu.upc.iTeston.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.iTeston.business.crud.QuestionBankService;
import pe.edu.upc.iTeston.business.crud.impl.LoginService;
import pe.edu.upc.iTeston.models.entities.QuestionBank;
import pe.edu.upc.iTeston.models.entities.Teacher;

@Controller
@RequestMapping("/")
public class FrontController {

	@Autowired
	private LoginService loginService;
	@Autowired //injeccion de dependencias
	private QuestionBankService questionBankService;
	@Autowired
	@GetMapping("inicio-docente") // request
	public String landingTeacher() {
		return "landingTeacher";
	}
	
	@GetMapping("login")	// request
	public String login() {
		return "login";
	}
	
	@GetMapping("nuevo-balotario")
	public String newQuestionBank() { // quitar
		return "newQuestionBank";
	}

	
	@GetMapping("mis-balotarios")


	public String allQuestionBanks(Model model) throws Exception {
		List<QuestionBank> questionBanks = questionBankService.getAll();
		model.addAttribute("questionBanks", questionBanks);
		return "allQuestionBanks";
	}

	
	@GetMapping("inicio-estudiante")
	public String landingEstudiante() {
		return "landingEstudiante";
	}

	
	@GetMapping("premium")
	public String planPremium() { 
		return "planPremium";
	}

	
	@GetMapping("pago")
	public String creditCard() { // quitar
		
		return "creditCard";
	}

	
	@GetMapping("retirar")
	public String gainTeacher() { // quitar
		return "gainTeacher";
	}

	@GetMapping("saldo")
	public String showMoney(Model model) throws Exception { // quitar
		Teacher teacher = loginService.getTeacher();
		Float saldo = teacher.getVirtualWallet().getSaldo();
		model.addAttribute("saldo", saldo);
		return "virtualWallet";
	}

	@GetMapping("edit")
	public String virtualWallet(Model model) throws Exception { //
		Teacher teacher = loginService.getTeacher();
		Float saldo = teacher.getVirtualWallet().getSaldo();
		Object walletRetiro = new Object();

		model.addAttribute("saldo", saldo);
		return "virtualWallet";
	}
	@GetMapping("suscripcionRealizada")
	public String viewSuscription() {
		return "viewSuscription";
	}

	@GetMapping("perfil-docente")
	public String teacherProfile() {
		return "teacherProfile";
	}

	@GetMapping("perfil-estudiante")
	public String studentProfile() {
		return "studentProfile";
	}
	
	

}
