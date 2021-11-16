package pe.edu.upc.iTeston.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.iTeston.business.crud.CommentService;
import pe.edu.upc.iTeston.business.crud.QuestionBankService;
import pe.edu.upc.iTeston.business.crud.QuizService;
import pe.edu.upc.iTeston.business.crud.StudentService;
import pe.edu.upc.iTeston.business.crud.impl.LoginService;
import pe.edu.upc.iTeston.models.entities.Comment;
import pe.edu.upc.iTeston.models.entities.QuestionBank;
import pe.edu.upc.iTeston.models.entities.Quiz;
import pe.edu.upc.iTeston.models.entities.Student;

@Controller
@RequestMapping("/quizzes")
@SessionAttributes("quiz")
public class QuizController {
	@Autowired
	private StudentService studentService; 
	@Autowired
	private QuizService quizService; 
	@Autowired
	private QuestionBankService questionService; 
	@Autowired
	private CommentService commentService; 
	
	@Autowired
	private LoginService loginService; 
	
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
                model.addAttribute("quizes", new Quiz());
                List<QuestionBank> questionBanks =  questionService.getAll();
        		
        		model.addAttribute("comment",new Comment());
        		model.addAttribute("questionBanks", questionBanks);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "quizzes/showQuizz";
    }
	
	@GetMapping("new")
	public String newComent(Model model) {
		try {
			List<Student> students = studentService.getAll();
			List<QuestionBank> questions = questionService.getAll();
			model.addAttribute("students", students);
			model.addAttribute("questions", questions);
			model.addAttribute("comment", new Comment());
			
		} catch (Exception e) {
			// TODO: handle exception
		}		
		return "quizzes/new";
	}
	
	@PostMapping("saveNew")
	public String saveNew(Model model, @Valid @ModelAttribute("comment") Comment comment, 
			BindingResult result) throws Exception {
		List<QuestionBank> questionBanks = questionService.getAll();
		if(result.hasErrors()) {
			
		}
		try {
			comment.setDate(new Date());
			comment.setStudent(loginService.getStudent());
			Comment commentSaved= commentService.create(comment);		
			model.addAttribute("comment", commentSaved);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		model.addAttribute("questionBanks", questionBanks);
		return "quizzes/showQuizz";
	}
	
	
	
	
}
