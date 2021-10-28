package pe.edu.upc.iTeston.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class FrontController {

	@GetMapping("inicio")	// request
	public String index() {
		return "index";
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

}
