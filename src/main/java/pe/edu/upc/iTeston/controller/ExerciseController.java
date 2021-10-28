package pe.edu.upc.iTeston.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.iTeston.business.crud.ExerciseService;
import pe.edu.upc.iTeston.models.entities.Exercise;


@Controller
@RequestMapping("/exercises") 
public class ExerciseController {

	@Autowired //injeccion de dependencias
	private ExerciseService exerciseService;
	
	@GetMapping
	public String list(Model model ){
		
		try {
			List<Exercise> exercises=exerciseService.getAll();
			model.addAttribute("exercises", exercises);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "exercises/list";//html
	}
	
	
	public String edit(Model model, @PathVariable("id") String id) {
		try {
			if (exerciseService.existsById(id)) { //si existe hace tal
				Optional<Exercise>optional=exerciseService.findById(id);
				model.addAttribute("exercise",optional.get());
			}
		}catch (Exception e){
			//si no existe
		}
		return "exercises??/edit";//html
	}
}
