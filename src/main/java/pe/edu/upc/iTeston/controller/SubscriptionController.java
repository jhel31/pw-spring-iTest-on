package pe.edu.upc.iTeston.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@Autowired //injeccion de dependencias
	private StudentService studentService;
	
	
	@GetMapping
	public String list(Model model ){
		
		try {
			List<Subscription> subscriptions=subscriptionService.getAll();
			model.addAttribute("subscriptions", subscriptions);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "creditCard";//html
		
	}
	
	
	
	@GetMapping("viewPago")//funcion que llega el view y subscriptionId
	public String viewDataSubscription(Model model) throws Exception{
		List<Subscription> suscriptions =subscriptionService.getAll();
		model.addAttribute("subscriptions", new Subscription());
		
		return ("viewSubscription");
	}
	
	
	
	/*
	 * 	
	@GetMapping("viewPago/{subscriptionId}")//funcion que llega el view y subscriptionId
	public String viewDataSubscription(Model model,@PathVariable("subscriptionId") Integer subscriptionId){
		
		
		try {
			if(subscriptionService.existsById(subscriptionId)) {
				subscriptionService.findById(subscriptionId);	
			}
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ("viewSubscription");
	}

	 * */
	
	
	@GetMapping("newPago")
	public String newSubscription(Model model) {
		try {
			List<Subscription> subscriptions = subscriptionService.getAll();
			List<Student> students = studentService.getAll();
			model.addAttribute("subscriptions", subscriptions);
			model.addAttribute("students", students);
			model.addAttribute("subscriptions", new Subscription());
		} catch (Exception e) {
			// TODO: handle exception
		}		
		return "viewSubscription";
	}
	
	
	@PostMapping("saveNewPago")
	public String saveNewPago(Model model, @Valid @ModelAttribute("Subscription") Subscription subscription, 
			BindingResult result) {
		if(result.hasErrors()) {
	
		}
		System.out.println(subscription.getId());
		System.out.println(subscription.getIssueDate());
		System.out.println(subscription.getExpire());
		
		
		
		
		try {
			Subscription subscriptionSaved= subscriptionService.create(subscription);		
			model.addAttribute("subscription", subscriptionSaved);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "viewSubscription";
	}
	
	

}