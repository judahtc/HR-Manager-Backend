package hr_manager.HRManager.Student;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table
public class Student {

    @Id
    @SequenceGenerator(
            sequenceName = "student_sequence",
            name = "student_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    private String name;
    private String email;

    private String first_name;


    private String last_name;
    private Integer age;
    private LocalDate dob;
    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }



    public Student() {
    }
    public Student(Long id, String name, String email, Integer age, LocalDate dob, String first_name,String last_name) {
        this.id = id;
        this.name = name;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.age = age;
        this.dob = dob;
    }

    public Student(String name, String email, Integer age, LocalDate dob, String first_name,String last_name) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.dob = dob;
        this.first_name = first_name;
        this.last_name = last_name;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", dob=" + dob +
                '}';
    }

}
