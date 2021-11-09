package pe.edu.upc.iTeston.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class FrontController {
	
	@Autowired
	@GetMapping("inicio-docente")	// request
	public String landingTeacher() {
		return "landingTeacher";
	}
	
	@GetMapping("nuevo-balotario")
	public String newQuestionBank() { // quitar
		return "newQuestionBank";
	}
	
	@GetMapping("mis-balotarios")
	public String allQuestionBanks() { // quitar
		return "allQuestionBanks";
	}
	
	@GetMapping("inicio-estudiante")
	public String landingEstudiante() { 
		return "landingEstudiante";
	}

	@GetMapping("premium")
	public String planPremium() { // quitar
		return "planPremium";
	}
	
	@GetMapping("pago")
	public String creditCard() { // quitar
		return "creditCard";
	}
	
	@GetMapping("saldo")
	public String virtualWallet() { // quitar
		return "virtualWallet"; 
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
