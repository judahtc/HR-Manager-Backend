package hr_manager.HRManager.Grades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class gradesServiceImp implements gradesService{
    private gradesRepository gradesRepository;
    @Autowired
    public gradesServiceImp(hr_manager.HRManager.Grades.gradesRepository gradesRepository) {
        this.gradesRepository = gradesRepository;
    }

    @Override
    public List<grades> getEmployeeGrades() {
        return gradesRepository.findAll();
    }
}
