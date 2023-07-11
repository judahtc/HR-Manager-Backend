package hr_manager.HRManager.Department;

import hr_manager.HRManager.Employee.Employee;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data

public class Department {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private String manager;


    @OneToMany(mappedBy = "department",fetch = FetchType.LAZY)
    private List<Employee> employees;


}
