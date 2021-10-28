package pe.edu.upc.iTeston.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.iTeston.business.crud.QuestionBankService;
import pe.edu.upc.iTeston.models.entities.QuestionBank;

@Controller
@RequestMapping("/questionBanks")
public class QuestionBankController {

	@Autowired //injeccion de dependencias
	private QuestionBankService questionBankService;
	
	@GetMapping
	public String list(Model model ){
		
		try {
			List<QuestionBank> questionBanks=questionBankService.getAll();
			model.addAttribute("questionBanks", questionBanks);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "questionBanks/list";//html
	}
	
	
	public String edit(Model model, @PathVariable("id") String id) {
		try {
			if (questionBankService.existsById(id)) { //si existe hace tal
				Optional<QuestionBank>optional=questionBankService.findById(id);
				model.addAttribute("questionBank",optional.get());
			}
		}catch (Exception e){
			//si no existe
		}
		return "questionBanks/edit";//html
	}
}
