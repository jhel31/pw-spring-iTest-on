package pe.edu.upc.iTeston.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import pe.edu.upc.iTeston.business.crud.impl.LoginService;
import pe.edu.upc.iTeston.models.entities.User;
import pe.edu.upc.iTeston.models.repository.StudentRepository;
import pe.edu.upc.iTeston.models.repository.TeacherRepository;
import pe.edu.upc.iTeston.models.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private LoginService loginService;
	@Autowired
	private TeacherRepository teacherRepository;
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			Optional<User> optional = this.userRepository.findByUsername(username);
			if (optional.isPresent()) {
				User user = optional.get();
				if(user.getId().substring(0,1).equals("S")) {
					loginService.setStudent(studentRepository.findById(user.getId()).get());
				}
				else {
					loginService.setTeacher(teacherRepository.findById(user.getId()).get());
				}
				
				MyUserDetails myUserDetails = new MyUserDetails( optional.get() );
				return myUserDetails;
			}			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		throw new UsernameNotFoundException("The user is not found");	
	}

}
