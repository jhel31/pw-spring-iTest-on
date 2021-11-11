	package pe.edu.upc.iTeston.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.iTeston.business.crud.ApprovalService;
import pe.edu.upc.iTeston.models.entities.Approval;

@Controller
@RequestMapping("/approvals")
public class ApprovalController {
	
	@Autowired
	private ApprovalService approvalService;
	
	@GetMapping
	public String list(Model model) {
		try {
			List<Approval> approvals = approvalService.getAll();
			model.addAttribute("approvals",approvals);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "approvals/student";
	}
	
}
