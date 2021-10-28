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
import pe.edu.upc.iTeston.models.entities.Student;

@Controller
@RequestMapping("/students") //como me dirijo a apartado html
public class StudentController {
	
	
	@Autowired //injeccion de dependencias
	private StudentService studentService;
	
	@GetMapping
	public String list(Model model ){
		
		try {
			List<Student> students=studentService.getAll();
			model.addAttribute("students", students);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "estudiantes??/list";//html
	}
	
	
	public String edit(Model model, @PathVariable("id") String id) {
		try {
			if (studentService.existsById(id)) { //si existe hace tal
				Optional<Student>optional=studentService.findById(id);
				model.addAttribute("student",optional.get());
			}
		}catch (Exception e){
			//si no existe
		}
		return "estudiantes??/list";//html
	}

}
