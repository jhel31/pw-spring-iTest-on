package pe.edu.upc.iTeston.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
	@Autowired // injeccion de dependencias
	private QuestionBankService questionBankService;

	@GetMapping("inicio") // request
	public String landing() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		boolean hasTeacherRole = authentication.getAuthorities().stream()
				.anyMatch(r -> r.getAuthority().equals("ROLE_TEACHER"));
		boolean hasStudentRole = authentication.getAuthorities().stream()
				.anyMatch(r -> r.getAuthority().equals("ROLE_STUDENT"));
		System.out.println(hasTeacherRole);
		System.out.println(hasStudentRole);
		if (hasTeacherRole)
			return "landingTeacher";
		else
			return "landingEstudiante";
		
	}

	@GetMapping("inicio-docente") // request
	public String landingTeacher() {
		return "landingTeacher";
	}

	@GetMapping("inicio-estudiante")
	public String landingEstudiante() {
		return "landingEstudiante";
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
