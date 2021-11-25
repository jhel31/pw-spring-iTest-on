package pe.edu.upc.iTeston.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.iTeston.business.crud.ApprovalService;
import pe.edu.upc.iTeston.business.crud.CommentService;
import pe.edu.upc.iTeston.business.crud.ExerciseService;
import pe.edu.upc.iTeston.business.crud.QuizSaveService;
import pe.edu.upc.iTeston.business.crud.QuizService;
import pe.edu.upc.iTeston.business.crud.impl.LoginService;
import pe.edu.upc.iTeston.models.entities.Approval;
import pe.edu.upc.iTeston.models.entities.Comment;
import pe.edu.upc.iTeston.models.entities.Quiz;
import pe.edu.upc.iTeston.models.entities.QuizzSave;

@Controller
@RequestMapping("/quizSave")
public class QuizSaveController {

	@Autowired
	private ExerciseService eS;

	@Autowired
	private QuizService qS;

	@Autowired
	private QuizSaveService quizSaveServise;

	@Autowired
	private LoginService loginService;

	@Autowired
	private CommentService commentService;
	
	@Autowired
	private ApprovalService approvalService;

	@GetMapping("/misnotas")
	public String list(Model model) {
		try {
			List<QuizzSave> quizesSave = quizSaveServise.findByStudentId(loginService.getStudent().getId());
			model.addAttribute("quizesSave", quizesSave);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "quizzes/myScores";
	}

	@GetMapping("/{idUniversity}")
	public String list(Model model, @PathVariable String idUniversity) {
		String idQuiz;

		if (idUniversity.equals("UN01")) {
			idQuiz = "QU01";

		} else {
			idQuiz = "QU02";
		}

		try {

			QuizzSave quizSave = new QuizzSave();
			Quiz quizz = qS.findById(idQuiz).get();
			quizSave.setQuizz(quizz);
			quizSave.setResults(eS.newQuizResults(idQuiz));
			quizSave.setStudent(loginService.getStudent());

			model.addAttribute("quizSave", quizSave);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "quizSave";// html
	}

	@PostMapping("/saveNew")
	public String saveNew(Model model, @ModelAttribute("quizSave") QuizzSave quizSave, BindingResult result)
			throws Exception {
		quizSave.setDate(new Date());
		quizSave.setResult(0);
		for (int i = 0; i < quizSave.getResults().size(); i++) {
			if (quizSave.getResults().get(i).getResult() == 1) {
				quizSave.setResult(quizSave.getResult() + 2);
			}
		}
		quizSaveServise.create(quizSave);

		return "redirect:/quizSave/misnotas";

	}

	
	@PostMapping("/saveApproval")
	public String saveAproval(Model model, @ModelAttribute("approval") Approval approval, BindingResult result)
			throws Exception {
		approval.setApprovalDate(new Date());
		approvalService.create(approval);
		return "redirect:/quizSave/misnotas";

	}
	@GetMapping("/newApproval/{idQuizzSave}")
	public String newApproval(Model model, @PathVariable int idQuizzSave) {
		Approval approval = new Approval();
		approval.setQuizSave(new QuizzSave());
		approval.getQuizSave().setIdQuizzSave(idQuizzSave);
		approval.setStudent(loginService.getStudent());
		model.addAttribute("approval", approval);
		return "approval";
	}
	@GetMapping("/listApprovals/{idQuizzSave}")
	public String listApprovals(Model model, @PathVariable int idQuizzSave) {
		List<Approval>approvals = approvalService.findByQuizSaveIdQuizzSave(idQuizzSave);
		model.addAttribute("approvals", approvals);
		return "listApprovals";
	}
	
	@PostMapping("/saveComment")
	public String saveComment(Model model, @ModelAttribute("comment") Comment comment, BindingResult result)
			throws Exception {
		comment.setDate(new Date());
		commentService.create(comment);
		return "redirect:/quizSave/misnotas";

	}

	@GetMapping("/newComment/{idQuizzSave}")
	public String newComment(Model model, @PathVariable int idQuizzSave) {
		Comment comment = new Comment();
		comment.setQuizSave(new QuizzSave());
		comment.getQuizSave().setIdQuizzSave(idQuizzSave);
		comment.setStudent(loginService.getStudent());
		model.addAttribute("comment", comment);
		return "comment";
	}
	
	@GetMapping("/misQuizes")
	public String misQuizes(Model model) {
		try {
			List<QuizzSave> quizesSave = quizSaveServise.findByTeacherId(loginService.getTeacher().getId());
			model.addAttribute("quizesSave", quizesSave);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "quizzesTeacher";
	}
	
	@GetMapping("/listComments/{idQuizzSave}")
	public String listComments(Model model, @PathVariable int idQuizzSave) {
		List<Comment>comments = commentService.findByQuizSaveIdQuizzSave(idQuizzSave);
		model.addAttribute("comments", comments);
		return "listComments";
	}
}
