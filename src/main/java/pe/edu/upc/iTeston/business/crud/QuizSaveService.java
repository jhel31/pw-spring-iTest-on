package pe.edu.upc.iTeston.business.crud;

import java.util.List;

import pe.edu.upc.iTeston.models.entities.QuizzSave;

public interface QuizSaveService extends CrudService<QuizzSave, Integer> {
	List<QuizzSave>findByStudentId(String id);
	List<QuizzSave>findByTeacherId(String id);
}
