package pe.edu.upc.iTeston.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.iTeston.business.crud.CourseService;

import pe.edu.upc.iTeston.models.entities.Course;


@Controller
@RequestMapping("/courses") //como me dirijo a apartado html
public class CourseController {
	@Autowired //injeccion de dependencias
	private CourseService courseService;
	
	@GetMapping
	public String list(Model model ){
		
		try {
			List<Course> teachers=courseService.getAll();
			model.addAttribute("courses", teachers);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "cursos??/list";//html
	}
	
	
	public String edit(Model model, @PathVariable("id") String id) {
		try {
			if (courseService.existsById(id)) { //si existe hace tal
				Optional<Course>optional=courseService.findById(id);
				model.addAttribute("course",optional.get());
			}
		}catch (Exception e){
			//si no existe
		}
		return "cursos??/list";//html
	}
}
