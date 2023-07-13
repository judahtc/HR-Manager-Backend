package hr_manager.HRManager.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> helloWorld() {
        return studentRepository.findAll();

    }


    public Optional<Student> getStudentByEmail(String email) {
        return studentRepository.findByEmail(email);
    }

    public void  addStudent(Student student){
        Optional<Student> studentOptional= this.studentRepository.findByEmail(student.getEmail());

        if (studentOptional.isPresent()){
            throw new IllegalStateException("email is taken");
        }

        else{
            this.studentRepository.save(student);
        }
    }


}
