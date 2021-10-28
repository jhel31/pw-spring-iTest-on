package pe.edu.upc.iTeston.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.iTeston.business.crud.CommentService;
import pe.edu.upc.iTeston.models.entities.Comment;

@Controller
@RequestMapping("/comments")
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	@GetMapping
	public String list(Model model) {
		try {
			List<Comment> comments = commentService.getAll();
			model.addAttribute("comments", comments);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "comments/list";
	}
}
