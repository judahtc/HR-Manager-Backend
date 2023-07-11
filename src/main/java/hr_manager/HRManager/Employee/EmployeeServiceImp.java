package hr_manager.HRManager.Employee;

import hr_manager.HRManager.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EmployeeServiceImp implements EmployeeService {
    public EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeServiceImp(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override


    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findByEmail(String email) {
        Optional<Employee> Emp=employeeRepository.findByEmail(email);

        if(Emp.isPresent()) {
            return Emp;
        }
        else{
            throw new ResourceNotFoundException("Employee not found with email: " + email);
        }
    }

    @Override
    public Employee addEmployee(Employee employee) {
        Optional<Employee> emp=this.employeeRepository.findByEmail(employee.getEmail());

        if(emp.isPresent()){
            throw new ResourceNotFoundException("An employee with that email already exists:"+employee.getEmail());

        }
        else {
            employeeRepository.save(employee);
            return employee;
        }

    }

    @Override
    public Employee updateEmployee(Employee employee, String email) {
        Employee employeeOptional =this.employeeRepository.findEmpByEmail(email);

        if(employeeOptional!=null){
            employeeOptional.setAddress(employee.getAddress());
            employeeOptional.setFirstName(employee.getFirstName());
            employeeOptional.setLastName(employee.getLastName());
            employeeOptional.setPhone(employee.getPhone());
            employeeOptional.setNextOfKinPhone(employee.getNextOfKinPhone());
            employeeRepository.save(employeeOptional);
            return employeeOptional;
        }
        else{
            throw new ResourceNotFoundException("An employee with that email doesn't exists:"+employee.getEmail());

        }

    }

    @Override
    public void deleteEmployee(String email) {
        employeeRepository.deleteByEmail(email);
    }
}
