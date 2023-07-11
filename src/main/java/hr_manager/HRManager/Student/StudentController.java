package hr_manager.HRManager.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/students")
public class StudentController {
private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/view")
    public List<Student> viewAll() {
        return this.studentService.helloWorld();
    }


    @GetMapping("/view/{email}")
    public Optional<Student> getStudentById(@PathVariable String email) {
        return this.studentService.getStudentByEmail(email);
    }

    @PostMapping("/addStudent")
    public void addStudent(@RequestBody Student student)
    {

        studentService.addStudent(student);
    }

}
