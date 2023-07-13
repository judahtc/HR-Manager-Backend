package hr_manager.HRManager.Grades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/grades/")
public class gradesController {
    private gradesServiceImp gradesServiceImp;
    @Autowired
    public gradesController(hr_manager.HRManager.Grades.gradesServiceImp gradesServiceImp) {
        this.gradesServiceImp = gradesServiceImp;
    }


    @GetMapping("all")
    public List<grades> getGrades(){
        return gradesServiceImp.getEmployeeGrades();
    }
}
