package pe.edu.upc.iTeston.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.iTeston.business.crud.impl.LoginService;
@Controller
@RequestMapping("/")
public class LoginController {

	@Autowired
	private LoginService loginservice;
	
	
	
	@GetMapping("login")	// request
	public String login() {
		loginservice.setTeacher(null);
		loginservice.setStudent(null);
		return "login";
		
	}
	
	@GetMapping("")	// request
	public String irLogin() {
		loginservice.setTeacher(null);
		loginservice.setStudent(null);
		return "login";
	}	
	
	@GetMapping("logout")	// request
	public String logout() {
		loginservice.setTeacher(null);
		loginservice.setStudent(null);
		return "login";
	}
	
	
	
}
