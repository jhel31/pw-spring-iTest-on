package pe.edu.upc.iTeston.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.iTeston.business.crud.TeacherService;
import pe.edu.upc.iTeston.models.entities.Teacher;

@Controller
@RequestMapping("/teachers") //como me dirijo a apartado html
public class TeacherController {
			
		
		@Autowired 
		private TeacherService teacherService;
		
		@GetMapping
		public String list(Model model ){
			
			try {
				List<Teacher> teachers=teacherService.getAll();
				model.addAttribute("teachers", teachers);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			return "profesores??/list";//html
		}
		
		
		public String edit(Model model, @PathVariable("id") String id) {
			try {
				if (teacherService.existsById(id)) { //si existe hace tal
					Optional<Teacher>optional=teacherService.findById(id);
					model.addAttribute("teacher",optional.get());
				}
			}catch (Exception e){
				//si no existe
			}
			return "estudiantes??/list";//html
		}
}
