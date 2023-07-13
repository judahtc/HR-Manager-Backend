package hr_manager.HRManager.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> getEmployees();
    Optional<Employee> findByEmail(String email);
    Employee addEmployee(Employee employee);
    Employee updateEmployee(Employee employee,String email);
    void deleteEmployee(String email);
}
