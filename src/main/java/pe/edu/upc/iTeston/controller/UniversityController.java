package pe.edu.upc.iTeston.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.iTeston.business.crud.UniversityService;
import pe.edu.upc.iTeston.models.entities.University;


@Controller
@RequestMapping("/universities")
@SessionAttributes("university")
public class UniversityController {
	@Autowired
	private UniversityService universityService; 
	
	@GetMapping
	public String list(Model model) {
		try {
			List<University> universities = universityService.getAll();
			model.addAttribute("universities", universities);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "university/list";
	}
}
