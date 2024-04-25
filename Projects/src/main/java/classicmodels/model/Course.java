package classicmodels.model;

import glab._4_1B.model.Department;
import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 50) private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deptId")
    private Department dept;

    @ManyToMany
    @JoinTable(name = "facultycourse", joinColumns = @JoinColumn(name = "courseId"), inverseJoinColumns = @JoinColumn(name = "facultyId"))
    private Set<Faculty> faculties = new LinkedHashSet<>();

    @OneToMany(mappedBy = "course") private Set<Studentcourse> studentcourses = new LinkedHashSet<>();

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Department getDept() { return dept; }

    public void setDept(Department dept) { this.dept = dept; }

    public Set<Faculty> getFaculties() { return faculties; }

    public void setFaculties(Set<Faculty> faculties) { this.faculties = faculties; }

    public Set<Studentcourse> getStudentcourses() { return studentcourses; }

    public void setStudentcourses(Set<Studentcourse> studentcourses) { this.studentcourses = studentcourses; }

}