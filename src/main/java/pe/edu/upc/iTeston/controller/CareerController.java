package pe.edu.upc.iTeston.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.iTeston.business.crud.CareerService;
import pe.edu.upc.iTeston.models.entities.Career;

@Controller
@RequestMapping("/careers")
@SessionAttributes("career")
public class CareerController {
	@Autowired
	private CareerService careerService;
	
	@GetMapping
	public String list(Model model) {
		try {
			List<Career> careers = careerService.getAll();
			model.addAttribute("careers", careers);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "careers/list";
	}
}
