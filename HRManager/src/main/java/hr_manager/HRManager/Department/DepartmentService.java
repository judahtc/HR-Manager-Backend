package hr_manager.HRManager.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    List<Department> getDepartments();
    List<DepartmentProjections> getAllDepartment();

    Optional<Department> findByName(String name);
    Optional<DepartmentProjections> findDeptByName(String name);

    void AddDepartment(Department department);
    void deleteDepartment(Long id);

    Department updateDepartment(Department department,String name);
}
