package hr_manager.HRManager.Grades;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface gradesRepository extends JpaRepository<grades,Long> {
}
