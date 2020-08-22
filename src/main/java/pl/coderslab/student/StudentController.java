package pl.coderslab.student;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
public class StudentController {
    @ModelAttribute("countries")
    public List<String> countries() {
        return Arrays.asList("Poland", "Germany", "France", "Russia", "Denmark");
    }

    @ModelAttribute("programmingSkills")
    public List<String> programmingSkills() {
        return Arrays.asList("C++", "Java", "PHP", "Python", "JavaScript");
    }

    @ModelAttribute("hobbies")
    public List<String> hobbies() {
        return Arrays.asList("sport", "gry komputerowe", "muzyka", "używki", "filmy i seriale");
    }

    @GetMapping("/student/add")
    public String addStudent(Model model) {
        model.addAttribute("student", new Student());
        return "student/form";
    }

    @PostMapping("/student/add")
    @ResponseBody
    public String saveStudent(@ModelAttribute Student student) {
        return student.toString();
    }
}
