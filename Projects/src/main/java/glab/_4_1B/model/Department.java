package glab._4_1B.model;

import classicmodels.model.Course;
import classicmodels.model.Faculty;
import classicmodels.model.Student;
import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "DEPARTMENT")
public class Department {
    @Column(name = "DEPARTMENT_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String name;
    private String state;

    @OneToMany(mappedBy = "dept") private Set<Course> courses = new LinkedHashSet<>();

    @OneToMany(mappedBy = "deptid") private Set<Faculty> faculties = new LinkedHashSet<>();

    @OneToMany(mappedBy = "major") private Set<Student> students = new LinkedHashSet<>();

    public Department(String name, String state) {
        this.name = name;
        this.state = state;
    }

    public Department() {

    }

    public Set<Student> getStudents() { return students; }

    public void setStudents(Set<Student> students) { this.students = students; }

    public Set<Faculty> getFaculties() { return faculties; }

    public void setFaculties(Set<Faculty> faculties) { this.faculties = faculties; }

    public Set<Course> getCourses() { return courses; }

    public void setCourses(Set<Course> courses) { this.courses = courses; }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}