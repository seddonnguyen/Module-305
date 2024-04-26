package glab._5_2B.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "teacher", schema = "teacher_db")
@Data
@NoArgsConstructor
public class Teacher implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teacherId;
    private String salary;

    private String teacherName;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    public Teacher(String salary, String teacherName, Department department) {
        this(salary, teacherName);
    }

    public Teacher(String salary, String teacherName) {
        super();
        this.salary = salary;
        this.teacherName = teacherName;
    }
}