package hr_manager.HRManager.Department;

import hr_manager.HRManager.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("api/departments/")
public class DepartmentController {
    DepartmentServiceImp departmentServiceImp;
    @Autowired
    public DepartmentController(DepartmentServiceImp departmentServiceImp) {
        this.departmentServiceImp = departmentServiceImp;
    }

    @GetMapping("view")
    public List<Department> getDepartments(){
        return departmentServiceImp.getDepartments();
    }

    @GetMapping("view-all")
    public List<DepartmentProjections> getAllDepartments(){
        return departmentServiceImp.getAllDepartment();
    }

    @GetMapping("one/{name}")
    public Optional<Department> getOneDepartment(@PathVariable String name){
        return departmentServiceImp.findByName(name);
    }

    @GetMapping("dept/{name}")
    public Optional<DepartmentProjections> getDepartment(@PathVariable String name){
        return Optional.ofNullable(departmentServiceImp.findDeptByName(name).orElseThrow(() -> new ResourceNotFoundException("Department not found with name: " + name)));
    }

    @PostMapping("add")
    public void addDepartment(@RequestBody Department department){
        departmentServiceImp.AddDepartment(department);
    }


    @DeleteMapping("{id}")
    public void deleteDepartment(@PathVariable long id){

        departmentServiceImp.deleteDepartment(id);
    }

    @PutMapping("/{name}")
    public Department updateDept(@PathVariable String name, @RequestBody Department department)

    {
        return departmentServiceImp.updateDepartment(department,name);

    }
    }

