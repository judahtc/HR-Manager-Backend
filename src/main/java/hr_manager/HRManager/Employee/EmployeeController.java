package hr_manager.HRManager.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/employees/")
public class EmployeeController {
    public EmployeeServiceImp employeeServiceImp;
    @Autowired
    public EmployeeController(EmployeeServiceImp employeeServiceImp) {
        this.employeeServiceImp = employeeServiceImp;
    }



    @GetMapping("all")
    public List<Employee> getEmployees(){

        return employeeServiceImp.getEmployees();
    }

    @GetMapping("{email}")
    public Optional<Employee> getEmployee(@PathVariable String email){
        return employeeServiceImp.findByEmail(email);
    }

    @PostMapping("add")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeServiceImp.addEmployee(employee);
    }

    @PutMapping("update/{email}")
    public Employee updateEmployee(@RequestBody Employee employee,@PathVariable String email){
        return employeeServiceImp.updateEmployee(employee,email);

    }

    @DeleteMapping("delete/{email}")
    public void DeleteEmployee(@PathVariable String email)
    {
        employeeServiceImp.deleteEmployee(email);
    }
}
