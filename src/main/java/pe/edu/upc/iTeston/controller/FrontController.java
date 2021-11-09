package pe.edu.upc.iTeston.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.iTeston.business.crud.CareerService;
import pe.edu.upc.iTeston.models.entities.Career;

@Controller
@RequestMapping("/")
public class FrontController {
	
	@Autowired
	private CareerService careerService;

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
	public String beforeQuizz(Model model) throws Exception {
		List<Career> careers = careerService.getAll();
		model.addAttribute("careers", careers);
		model.addAttribute("career", new Career());
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
