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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.iTeston.business.crud.ApprovalService;
import pe.edu.upc.iTeston.business.crud.QuestionBankService;
import pe.edu.upc.iTeston.business.crud.QuizService;
import pe.edu.upc.iTeston.business.crud.impl.LoginService;
import pe.edu.upc.iTeston.models.entities.Approval;
import pe.edu.upc.iTeston.models.entities.QuestionBank;
import pe.edu.upc.iTeston.models.entities.Quiz;

@Controller
@RequestMapping("/questionBanks")
@SessionAttributes("quiz")

public class QuestionBankController {

	@Autowired //injeccion de dependencias
    private QuestionBankService questionBankService;
    @Autowired
    private QuizService quizService;
    @Autowired
    private LoginService loginService;
    @Autowired
    private ApprovalService approvalService;
    
    @GetMapping
    public String list(Model model ){

        try {
            Optional<Quiz> quizzes=quizService.findById("QU02");
            model.addAttribute("quizzes", quizzes.get());
            List<QuestionBank> questionBanks=questionBankService.getAll();
            model.addAttribute("questionBanks", questionBanks);
            model.addAttribute("approval",new Approval());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "quizz";//html
    }
    @PostMapping("saveNew")
    public String saveNew(Model model, @Valid @ModelAttribute("approval") Approval approval, 
            BindingResult result) throws Exception {
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
        return "quizz";
    }
}
