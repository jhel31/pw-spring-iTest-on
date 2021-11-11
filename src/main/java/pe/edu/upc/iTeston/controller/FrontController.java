package pe.edu.upc.iTeston.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.iTeston.business.crud.CareerService;
import pe.edu.upc.iTeston.business.crud.QuizService;
import pe.edu.upc.iTeston.models.entities.Career;
import pe.edu.upc.iTeston.models.entities.Quiz;
import pe.edu.upc.iTeston.business.crud.impl.LoginService;
import pe.edu.upc.iTeston.models.entities.Teacher;



@Controller
@RequestMapping("/")
public class FrontController {
	
	@Autowired 
	private LoginService loginService;
	
	
	@Autowired
	private CareerService careerService;
	@Autowired
	private QuizService quizService;
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

	@GetMapping("premium")
	public String planPremium() { // quitar
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
	public String virtualWallet(Model model) throws Exception { // quitar
		Teacher teacher = loginService.getTeacher();
		Float saldo = teacher.getVirtualWallet().getSaldo();
		
		model.addAttribute("saldo",saldo);
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
