package hr_manager.HRManager.Department;

import hr_manager.HRManager.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImp implements DepartmentService{
    DepartmentRepository departmentRepository;
    @Autowired
    public DepartmentServiceImp(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public List<DepartmentProjections> getAllDepartment() {
        return departmentRepository.getAllDepartment();
    }

    @Override
    public Optional<Department> findByName(String name) {
        return departmentRepository.findByName(name);
    }

    @Override
    public Optional<DepartmentProjections> findDeptByName(String name) {
        return departmentRepository.findDeptByName(name);
    }

    @Override
    public void AddDepartment(Department department) {
        Optional<Department> departmentOptional=this.departmentRepository.findByName(department.getName());
        if(departmentOptional.isPresent())
        {
            throw new IllegalStateException("name is taken");
        }
        else
        {
                departmentRepository.save(department);
        }
    }

    @Override
    public void deleteDepartment(Long id) {
        Optional<Department> departmentOptional1=this.departmentRepository.findById(id);
        if(departmentOptional1.isPresent()){
            departmentRepository.deleteById(id);
        }
        else{
            throw new ResourceNotFoundException("Department not found with id: " + id);
        }
    }

    @Override
    public Department updateDepartment(Department department, String name) {
        Department existingDept=this.departmentRepository.findDepByName(name);
        if(existingDept!=null) {
            existingDept.setName(department.getName());
            existingDept.setManager(department.getManager());
            existingDept.setDescription(department.getDescription());

            return departmentRepository.save(existingDept);
        }

        else{
            throw new ResourceNotFoundException("Department not found with name: " + name);
        }
    }
}
