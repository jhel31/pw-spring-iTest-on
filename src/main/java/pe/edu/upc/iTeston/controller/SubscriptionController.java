package pe.edu.upc.iTeston.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.iTeston.business.crud.StudentService;
import pe.edu.upc.iTeston.business.crud.SubscriptionService;
import pe.edu.upc.iTeston.models.entities.Student;
import pe.edu.upc.iTeston.models.entities.Subscription;



@Controller
@RequestMapping("/subscriptions") //como me dirijo a apartado html
public class SubscriptionController {
	
	@Autowired //injeccion de dependencias
	private SubscriptionService subscriptionService;
	
	@GetMapping
	public String list(Model model ){
		
		try {
			List<Subscription> subscriptions=subscriptionService.getAll();
			model.addAttribute("subscriptions", subscriptions);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "subscriptions??/list";//html
	}
	
	


}