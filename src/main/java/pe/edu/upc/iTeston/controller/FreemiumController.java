package pe.edu.upc.iTeston.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.iTeston.business.crud.FreemiumService;
import pe.edu.upc.iTeston.models.entities.Freemium;

@Controller
@RequestMapping("/freemiums")
public class FreemiumController {
	@Autowired
	private FreemiumService freemiumService;
	
	@GetMapping
	public String list(Model model) {
		try {
			List<Freemium> freemiums = freemiumService.getAll();
			model.addAttribute("freemiums", freemiums);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return "freemiums/list";
	}
}
