package pe.edu.upc.iTeston.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.iTeston.business.crud.ApprovalService;
import pe.edu.upc.iTeston.business.crud.CommentService;
import pe.edu.upc.iTeston.business.crud.QuestionBankService;
import pe.edu.upc.iTeston.business.crud.QuizService;
import pe.edu.upc.iTeston.business.crud.StudentService;
import pe.edu.upc.iTeston.business.crud.impl.LoginService;
import pe.edu.upc.iTeston.models.entities.Approval;
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
	private ApprovalService approvalService;
	
	@Autowired
	private LoginService loginService; 
	
	@GetMapping("misnotas")
	public String list(Model model) {
		try {
            Optional<Quiz> quizzes=quizService.findById("QU01");
            model.addAttribute("quizzes", quizzes.get());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return "";
	}
	
	@GetMapping("new")
	public String newApproval(Model model) {
		try {
			List<Student> students = studentService.getAll();
			List<QuestionBank> questions = questionService.getAll();
			model.addAttribute("students", students);
			model.addAttribute("questions", questions);
			model.addAttribute("approval", new Approval());
		} catch (Exception e) {
			// TODO: handle exception
		}		
		return "";
	}
	
	@PostMapping("saveNew")
	public String saveNew(Model model, @Valid @ModelAttribute("approval") Approval approval, 
			BindingResult result) {
		if(result.hasErrors()) {
			
		}
		try {
			approval.setApprovalDate(new Date());
			approval.setStudent(loginService.getStudent());
			Approval approvalSaved= approvalService.create(approval);		
			model.addAttribute("approval", approvalSaved);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "";
	}
	
	
	@GetMapping("mostrarsimulacro")
	public String mostrarsimulacro(Model model) throws Exception { //name of method is for html part
		List<QuestionBank> questionBanks =  questionService.getAll();
		
		model.addAttribute("approval",new Approval());
		model.addAttribute("questionBanks", questionBanks);
		return "";
	}
	
}
