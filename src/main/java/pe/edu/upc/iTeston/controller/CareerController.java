package pe.edu.upc.iTeston.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.iTeston.business.crud.CareerService;
import pe.edu.upc.iTeston.business.crud.QuizService;
import pe.edu.upc.iTeston.business.crud.UniversityService;
import pe.edu.upc.iTeston.models.entities.Career;
import pe.edu.upc.iTeston.models.entities.Quiz;
import pe.edu.upc.iTeston.models.entities.University;

@Controller
@RequestMapping("/careers")
@SessionAttributes("career")

public class CareerController {
    @Autowired
    private CareerService careerService;
    @Autowired
    private UniversityService universityService; 
    @Autowired
    private QuizService quizService; 

    @GetMapping("simulacro")
    public String listCareers(Model model) {
        try {

            List<University> universities = universityService.getAll();
            model.addAttribute("universities", universities);
            //model.addAttribute("university", new University());

            List<Career> careers = careerService.getAll();
            model.addAttribute("careers", careers);
            model.addAttribute("career", new Career());

            List<Quiz> quizes = quizService.getAll();
            model.addAttribute("quizes",quizes);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "careers/list";
    }

}
