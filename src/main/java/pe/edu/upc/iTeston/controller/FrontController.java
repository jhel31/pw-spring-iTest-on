package pe.edu.upc.iTeston.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class FrontController {

	@GetMapping("inicio-docente")	// request
	public String landingTeacher() {
		return "landingTeacher";
	}
	
	@GetMapping("simulacro")
	public String quizz() {
		return "quizz";
	}

	@GetMapping("nuevo-balotario")
	public String newQuestionBank() {
		return "newQuestionBank";
	}
	
	@GetMapping("mis-balotarios")
	public String allQuestionBanks() {
		return "allQuestionBanks";
	}
	
	@GetMapping("elegir")
	public String beforeQuizz() {
		return "beforeQuizz";
	}
	
	@GetMapping("inicio-estudiante")
	public String landingEstudiante() {
		return "landingEstudiante";
	}

	@GetMapping("misnotas")
	public String notaQuizz() {
		return "notaQuizz";
	}
	@GetMapping("premium")
	public String planPremium() {
		return "planPremium";
	}
	
	@GetMapping("pago")
	public String creditCard() {
		return "creditCard";
	}
	
	@GetMapping("saldo")
	public String virtualWallet() {
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
