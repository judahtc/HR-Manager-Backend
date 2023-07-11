package hr_manager.HRManager.Department;

import hr_manager.HRManager.Student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
//import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    Optional<DepartmentProjections> findDeptByName(String name);
    Optional<Department> findByName(String name);

    Department findDepByName(String name);
    @Query("select u from Department u")
    List<DepartmentProjections> getAllDepartment();

//    @Query("select u Department u where u.id = :id")
//    Optional<DepartmentProjections> findProjectedById(@Param("id") Long id);
}
