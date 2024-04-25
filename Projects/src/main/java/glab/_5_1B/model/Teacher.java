package glab._5_1B.model;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "teacher", schema = "teacher_db")
public class Teacher implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String salary;
    private String name;

    public Teacher(int id, String salary, String name) {
        this.id = id;
        this.salary = salary;
        this.name = name;
    }

    public Teacher(String salary, String name) {
        super();
        this.salary = salary;
        this.name = name;
    }

    public Teacher(String salary, String name, Department department) {
        super();
        this.salary = salary;
        this.name = name;
    }

    public Teacher() { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}