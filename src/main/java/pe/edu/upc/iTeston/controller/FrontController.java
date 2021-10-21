package pe.edu.upc.iTeston.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class FrontController {

	@GetMapping("inicio")	// request
	public String index() {
		return "index";
	}
	
}
