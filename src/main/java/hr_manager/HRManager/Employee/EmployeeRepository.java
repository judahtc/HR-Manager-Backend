package hr_manager.HRManager.Employee;

import hr_manager.HRManager.Department.DepartmentProjections;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByEmail(String email);
    Employee findEmpByEmail(String email);

    Employee deleteByEmail(String email);


    @Query("select u from Employee u")
    List<EmployeeProjections> getAllEmployee();
}
