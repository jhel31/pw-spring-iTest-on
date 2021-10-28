package pe.edu.upc.iTeston.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.iTeston.business.crud.UniversityDetailService;
import pe.edu.upc.iTeston.models.entities.UniversityDetail;

@Controller
@RequestMapping("/UniversitiesDetails")
@SessionAttributes("UniversityDetail")
public class UniversityDetailController {
	
	@Autowired
	private UniversityDetailService universityDetailService; 
	
	@GetMapping
	public String list(Model model) {
		try {
			List<UniversityDetail> universitiesDetails = universityDetailService.getAll();
			model.addAttribute("UniversitiesDetails",universitiesDetails);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "UniversitiesDetails/list";
	}
	
}
