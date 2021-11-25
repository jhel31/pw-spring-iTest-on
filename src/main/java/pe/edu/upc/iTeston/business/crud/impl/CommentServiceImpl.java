package pe.edu.upc.iTeston.business.crud.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.iTeston.business.crud.CommentService;
import pe.edu.upc.iTeston.models.entities.Comment;
import pe.edu.upc.iTeston.models.repository.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentRepository commentRepository;
	@Override
	public JpaRepository<Comment, String> getJpaRepository() {
		
		return commentRepository;
	}
	
	@Override
	public List<Comment> findByDescription(String description) throws Exception{
		return commentRepository.findByDescription(description);
	}
	
}
