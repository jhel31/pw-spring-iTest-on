package pe.edu.upc.iTeston.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.iTeston.business.crud.QuestionBankService;
import pe.edu.upc.iTeston.business.crud.SubscriptionService;
import pe.edu.upc.iTeston.models.entities.QuestionBank;
import pe.edu.upc.iTeston.models.entities.Subscription;



@Controller
@RequestMapping("/search")
public class SearchControlller {
	
	/*	@Autowired //injeccion de dependencias
		private QuestionBankService questionBankService;
		
		@PostMapping("questionBank")
		public String searchQuestionBank(Model model,@ModelAttribute("questionBankSearch")QuestionBankSearch questionBankSearch){
			
			List<QuestionBank> questionBanks=new ArrayList<>();
			
			
			try {
				
				model.addAttribute("questionBanks", questionBanks);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return "courseSerached";//html
		}
		*/


}
