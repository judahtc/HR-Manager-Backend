package hr_manager.HRManager.Grades;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import hr_manager.HRManager.Employee.Employee;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

public class grades {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String grade;
    private String salary;
    private String eligibleAllowances;


}
