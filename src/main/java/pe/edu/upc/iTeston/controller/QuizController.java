package pe.edu.upc.iTeston.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.iTeston.business.crud.QuizService;

//import pe.edu.upc.iTeston.business.crud.UniversityService;
import pe.edu.upc.iTeston.models.entities.Quiz;

@Controller
@RequestMapping("/quizzes")
@SessionAttributes("quiz")
public class QuizController {
	
	@Autowired
	private QuizService quizService; 
	
	/*@Autowired
	private UniversityService universityService; */
	
	@GetMapping("misnotas")
	public String list(Model model) {
		try {
			List<Quiz> quizes = quizService.getAll();
			model.addAttribute("quizes",quizes);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return "quizzes/myScores";
	}
	
	
	@GetMapping("{id}/mostrarsimulacro")
	public String mostrarsimulacro(Model model,@PathVariable("id") String id) { //name of method is for html part
		try {
			
				List<Quiz> quizes = quizService.findByUniversityId(id);
				model.addAttribute("quizes",quizes);
				/*model.addAttribute("quizes", new Quiz());*/
				
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return "quizzes/showQuizz";
	}
	
}
