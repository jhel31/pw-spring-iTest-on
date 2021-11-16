package pe.edu.upc.iTeston.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.iTeston.business.crud.CareerService;
import pe.edu.upc.iTeston.business.crud.UniversityService;
import pe.edu.upc.iTeston.models.entities.Career;
import pe.edu.upc.iTeston.models.entities.University;

@Controller
@RequestMapping("/universitiesDetails")
@SessionAttributes("universityDetail")
public class UniversityDetailController {
	
	@Autowired
	private CareerService careerService; 

	@Autowired
	private UniversityService universityService; 
	@GetMapping
	public String list(Model model) {
		try {
			List<Career> careers = careerService.getAll();
			List<University> universities =  universityService.getAll();
			model.addAttribute("careers",careers);
			model.addAttribute("universities", universities);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return "universitiesDetails/list";
	}
	
	
	@GetMapping("new")
	public String newUniversityDetail(Model model) {
		try {
			List<Career> careers = careerService.getAll();
			List<University> universities = universityService.getAll();
			model.addAttribute("careers", careers);
			model.addAttribute("universities", universities);
//			model.addAttribute("UniversityDetail", new UniversityDetail());			
		} catch (Exception e) {
			// TODO: handle exception
		}		
		return "universitiesDetails/new";
	}
	
//	@PostMapping("saveNew")
//	public String saveNew(Model model, @Valid @ModelAttribute("UniversityDetail") UniversityDetail universityDetail, 
//			BindingResult result) {
//		if(result.hasErrors()) {
//			
//		}
//		
//		System.out.println(universityDetail.getId());
//		System.out.println(universityDetail.getCareer());
//		System.out.println(universityDetail.getUniversity());
//		try {
//			UniversityDetail UniversityDetailSaved = universityDetailService.create(universityDetail);		
//			model.addAttribute("universityDetail", UniversityDetailSaved);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		return "niversitiesDetails/savenew";
//	}
	
}
