package pe.edu.upc.iTeston.init;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pe.edu.upc.iTeston.models.entities.Student;
import pe.edu.upc.iTeston.models.entities.Teacher;
import pe.edu.upc.iTeston.models.entities.User;
import pe.edu.upc.iTeston.models.repository.StudentRepository;
import pe.edu.upc.iTeston.models.repository.TeacherRepository;
import pe.edu.upc.iTeston.models.repository.UserRepository;

@Service
public class InitUser implements CommandLineRunner{
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private TeacherRepository teacherRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
//		BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
//		Optional<Student> optional = studentRepository.findById("ST01");
//		if(optional.isPresent()) {
//			Student student = optional.get();
//			User user = new User("april", bcpe.encode("april"), student);	
//			user.addAuthority("ROLE_STUDENT");
//			userRepository.save(user);
//		}
//		Optional<Teacher> optionalt = teacherRepository.findById("TEA01");
//		if(optionalt.isPresent()) {
//			Teacher teacher = optionalt.get();
//			User user = new User("pedro", bcpe.encode("pedro"),teacher);	
//			user.addAuthority("ROLE_TEACHER");
//			userRepository.save(user);
//		}
	}

}
