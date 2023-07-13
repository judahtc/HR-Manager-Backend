package hr_manager.HRManager.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
//    Student findById(long id);
    Optional<Student> findByEmail(String email);
}
