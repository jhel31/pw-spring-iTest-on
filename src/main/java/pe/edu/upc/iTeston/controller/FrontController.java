package pe.edu.upc.iTeston.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.iTeston.business.crud.QuestionBankService;
import pe.edu.upc.iTeston.models.entities.QuestionBank;


@Controller
@RequestMapping("/")
public class FrontController {
	
	@Autowired
	@GetMapping("inicio-docente")	// request
	public String landingTeacher() {
		return "landingTeacher";
	}
	
	@GetMapping("simulacro")
	public String quizz() {
		return "quizzes/quizz";
	}

	@GetMapping("nuevo-balotario")
	public String newQuestionBank() {
		return "newQuestionBank";
	}
	
	
	
	
	
	
	
	@Autowired //injeccion de dependencias
	private QuestionBankService questionBankService;
	
	@GetMapping("mis-balotarios")
	public String allQuestionBanks(Model model)throws Exception  {
	List<QuestionBank> questionBanks=questionBankService.getAll();
	model.addAttribute("questionBanks", questionBanks);

		return "allQuestionBanks";
	}
	//llama información de plan 
	@GetMapping("premium")
	public String planPremium() {
		return "planPremium";
	}
	
	//llama formulario de datos de pago
	@GetMapping("pago")
	public String creditCard() {
		return "creditCard";
		//return "viewSuscription";
	}
	@GetMapping("suscripcionRealizada")
	public String viewSuscription() {
		return "viewSuscription";
	}
	
	
	
	
	
	
	@GetMapping("inicio-estudiante")
	public String landingEstudiante() {
		return "landingEstudiante";
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
