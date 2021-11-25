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

import pe.edu.upc.iTeston.business.crud.ExerciseService;
import pe.edu.upc.iTeston.business.crud.QuizSaveService;
import pe.edu.upc.iTeston.business.crud.QuizService;
import pe.edu.upc.iTeston.models.entities.Approval;
import pe.edu.upc.iTeston.models.entities.Comment;
import pe.edu.upc.iTeston.models.entities.QuestionBank;
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
	private QuizSaveService qsS;

	@GetMapping("")
	public String list(Model model) {

		try {
			QuizzSave quizSave = new QuizzSave();
			Quiz quizz = qS.findById("QU02").get();
			quizSave.setQuizz(quizz);
			quizSave.setResults(eS.newQuizResults("QU02"));

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
		quizSave.setResults(eS.newQuizResults("QU02")); //quitar el seteo
		for (int i = 0; i < quizSave.getResults().size(); i++) {
			if (quizSave.getResults().get(i).getResult() == 1) {
				quizSave.setResult(quizSave.getResult() + 2);
			}
		}
		
		qsS.create(quizSave);

		return "redirect:/quizSave";

	}
}
