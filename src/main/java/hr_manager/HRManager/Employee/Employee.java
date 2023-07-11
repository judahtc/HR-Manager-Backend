package hr_manager.HRManager.Employee;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import hr_manager.HRManager.Department.Department;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import hr_manager.HRManager.Grades.grades;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity

public class Employee {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private String nextOfKinPhone;
    private String address;
    private LocalDate hireDate;


    @ManyToOne
    private Department department;


}
