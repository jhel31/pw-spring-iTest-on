package pe.edu.upc.iTeston.init;

import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import pe.edu.upc.iTeston.models.entities.Student;
import pe.edu.upc.iTeston.models.repository.StudentRepository;

@Service
public class InitUser implements CommandLineRunner {

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	//private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		//System.out.println("Iniciando....gaaaa");
		//BCryptPasswordEncoder bcpe= new BCryptPasswordEncoder();
		
/*	Optional<Student> optional= studentRepository.findById(ST01);
		if (optional.isPresent()) {
			Student student=optional.get();
			User user=new User ("tony",bcpe.encode("tonnyy4444"), student);//crea usuario login
			user.addAuthority("USER_STUDENT");//ROL
			user.addAuthority("ACCES_APPLY");//RESTRICCION DE acceso 
			user.addAuthority("ACCES_EDIT_NAME");//RESTRICCION DE acceso
			//userRepository.save(user);//grabar usuario
		}
*/
		
	/*	Optional<Student> optional= studentRepository.findById(ST01);
		if (optional.isPresent()) {
			Student student=optional.get();
			User user=new User ("tony",bcpe.encode("tonnyy4444"), student);//crea usuario login
			user.addAuthority("USER_STUDENT");//ROL
			user.addAuthority("ACCES_APPLY");//RESTRICCION DE acceso 
			user.addAuthority("ACCES_EDIT_NAME");//RESTRICCION DE acceso
			//userRepository.save(user);//grabar usuario
		}
		*/
	}

}
