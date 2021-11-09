package pe.edu.upc.iTeston.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.iTeston.business.crud.QuizService;
import pe.edu.upc.iTeston.models.entities.Quiz;

@Controller
@RequestMapping("/quizzes")
@SessionAttributes("quiz")
public class QuizController {
	
	@Autowired
	private QuizService quizService; 
	
	@GetMapping("Misnotas")
	public String list(Model model) {
		try {
			List<Quiz> quizes = quizService.getAll();
			model.addAttribute("quizes",quizes);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return "quizzes/list";
	}
}
