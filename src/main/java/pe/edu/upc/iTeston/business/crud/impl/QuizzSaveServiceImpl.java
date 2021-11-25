package pe.edu.upc.iTeston.business.crud.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.iTeston.business.crud.QuizSaveService;
import pe.edu.upc.iTeston.models.entities.QuestionBank;
import pe.edu.upc.iTeston.models.entities.Quiz;
import pe.edu.upc.iTeston.models.entities.QuizzSave;
import pe.edu.upc.iTeston.models.repository.IQuizSaveRepository;
import pe.edu.upc.iTeston.models.repository.QuestionBankRepository;

@Service
public class QuizzSaveServiceImpl implements QuizSaveService {
	@Autowired
	private IQuizSaveRepository qsRepository;
	@Autowired
	private QuestionBankRepository questionBankRepository;

	@Override
	public JpaRepository<QuizzSave, Integer> getJpaRepository() {
		return qsRepository;
	}

	@Override
	public List<QuizzSave> findByStudentId(String id) {
		// TODO Auto-generated method stub
		return qsRepository.findByStudentId(id);
	}

	@Override
	public List<QuizzSave> findByTeacherId(String id) {
		// TODO Auto-generated method stub
		List<QuestionBank> questionsBanks = questionBankRepository.findByTeacherId(id);
		List<QuizzSave> quizzesSaves = new ArrayList<QuizzSave>();
		List<QuizzSave> quizzesSavesAux = new ArrayList<QuizzSave>();
		Quiz quiz = new Quiz();
		QuizzSave quizSave = new QuizzSave();
		for (int i = 0; i < questionsBanks.size(); i++) {
			quiz = questionsBanks.get(i).getQuiz();
			quizzesSavesAux = qsRepository.findByQuizzId(quiz.getId());
			for (int j = 0; j < quizzesSavesAux.size(); j++) {
				quizSave = quizzesSavesAux.get(j);

				if (!quizzesSaves.contains(quizSave)) {
					quizzesSaves.add(quizSave);
				}
			}
		}
		return quizzesSaves;
	}

}
