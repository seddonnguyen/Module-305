package classicmodels.model;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "department", schema = "classicmodels")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 30)
    private String name;

    @OneToMany(mappedBy = "dept")
    private Set<Course> courses = new LinkedHashSet<>();

    @OneToMany(mappedBy = "deptid")
    private Set<Faculty> faculties = new LinkedHashSet<>();

    @OneToMany(mappedBy = "major")
    private Set<Student> students = new LinkedHashSet<>();

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Set<Course> getCourses() { return courses; }

    public void setCourses(Set<Course> courses) { this.courses = courses; }

    public Set<Faculty> getFaculties() { return faculties; }

    public void setFaculties(Set<Faculty> faculties) { this.faculties = faculties; }

    public Set<Student> getStudents() { return students; }

    public void setStudents(Set<Student> students) { this.students = students; }
}