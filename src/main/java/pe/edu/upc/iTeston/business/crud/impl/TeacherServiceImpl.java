package pe.edu.upc.iTeston.business.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.iTeston.business.crud.TeacherService;
import pe.edu.upc.iTeston.models.entities.Teacher;
import pe.edu.upc.iTeston.models.repository.TeacherRepository;

@Service
public class TeacherServiceImpl implements TeacherService {
	

	@Autowired
	private TeacherRepository teacherRepository;
	
	@Override
	public JpaRepository<Teacher, String> getJpaRepository() {
		
		return teacherRepository;
	}

}
