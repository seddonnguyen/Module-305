package glab._5_3B.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "teacher", schema = "teacher_db")
@NoArgsConstructor
@Data
public class Teacher implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teacherId;

    private String salary;
    private String teacherName;

    @ManyToMany(targetEntity = Cohort.class)
    private Set<Cohort> cohort;

    public Teacher(String salary, String teacherName, Set<Cohort> cohort) {
        this.salary = salary;
        this.teacherName = teacherName;
        this.cohort = cohort;
    }

    public Teacher(String salary, String teacherName) {
        super();
        this.salary = salary;
        this.teacherName = teacherName;
    }

    public Teacher(String salary, String teacherName, Department department) {
        super();
        this.salary = salary;
        this.teacherName = teacherName;
    }
}