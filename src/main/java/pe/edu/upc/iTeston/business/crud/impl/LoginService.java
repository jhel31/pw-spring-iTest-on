package pe.edu.upc.iTeston.business.crud.impl;

import org.springframework.stereotype.Service;

import pe.edu.upc.iTeston.models.entities.Student;
import pe.edu.upc.iTeston.models.entities.Teacher;
import pe.edu.upc.iTeston.models.repository.StudentRepository;
import pe.edu.upc.iTeston.models.repository.TeacherRepository;

@Service
public class LoginService {

	private TeacherRepository teacherRepository;

	private StudentRepository studentRepository;

	private Teacher teacher;
	private Student student;

	public LoginService(TeacherRepository teacherRepository, StudentRepository studentRepository) {
		this.teacherRepository = teacherRepository;
		this.studentRepository = studentRepository;
//		teacher = teacherRepository.findById("TEA01").get();
//		student = studentRepository.findById("ST01").get();
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
