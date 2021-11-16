package pe.edu.upc.iTeston.business.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.iTeston.business.crud.StudentService;
import pe.edu.upc.iTeston.models.entities.Student;
import pe.edu.upc.iTeston.models.repository.StudentRepository;

@Service
class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	@Override
	public JpaRepository<Student, String> getJpaRepository() {
		return studentRepository;
	}

}
