package kz.bitlab.techorda2025.secondProject.controllers;

import kz.bitlab.techorda2025.secondProject.db.DBManager;
import kz.bitlab.techorda2025.secondProject.db.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static kz.bitlab.techorda2025.secondProject.db.DBManager.setMarkAut;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("cities", DBManager.getCities());
        model.addAttribute("students", DBManager.getStudents());
        return "home";
    }

    @GetMapping("/addSt")
    public String addStudentPage(Model model) {
        model.addAttribute("cities", DBManager.getCities());
        return "/addStudent";
    }
    @GetMapping("/updateSt")
    public String updateStPage(Model model) {
        model.addAttribute("cities", DBManager.getCities());
        return "/editStudent";
    }

    @PostMapping ("/addSt")
    public String addStudent(@RequestParam("name") String stName,
                             @RequestParam("surname") String stSurname,
                             @RequestParam("city") String city,
                            @RequestParam("exam") int stExam) {
        Student student = Student.builder().
                name(stName).
                surname(stSurname).
                city(DBManager.getCities().get(city)).
                exam(stExam).
                build();
        student.setMark(setMarkAut(student.getExam()));
        DBManager.addSt(student);
        return "redirect:/home";
    }

    @GetMapping("/deleteSt")
    public String deleteStudent(@RequestParam("id") Long id) {
        DBManager.deleteStudent(id);
        return "redirect:/home";
    }

    @GetMapping("/editSt")
    public String editStudent(@RequestParam("id") Long id, Model model) {
        Student student = DBManager.getStudentById(id);
        if (student != null) {
            model.addAttribute("cities", DBManager.getCities());
            model.addAttribute("student", student);
            return "editStudent";
        }
        return "redirect:/home";
    }

    @PostMapping("/updateSt")
    public String updateStudent(@RequestParam("id") Long id,
                                @RequestParam("name") String name,
                                @RequestParam("surname") String surname,
                                @RequestParam("city") String city,
                                @RequestParam("exam") int exam) {
        Student student = DBManager.getStudentById(id);
        if (student != null) {
            student.setName(name);
            student.setSurname(surname);
            student.setCity(city);
            student.setExam(exam);
            student.setMark(DBManager.setMarkAut(exam));

            DBManager.updateStudent(student);
        }
        return "redirect:/home";
    }


}
