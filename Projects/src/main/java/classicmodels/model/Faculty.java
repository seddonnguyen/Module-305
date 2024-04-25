package classicmodels.model;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "faculty")
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "firstname", length = 30) private String firstname;

    @Column(name = "lastname", length = 50) private String lastname;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deptid")
    private Department deptid;

    @ManyToMany(mappedBy = "faculties") private Set<Course> courses = new LinkedHashSet<>();

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getFirstname() { return firstname; }

    public void setFirstname(String firstname) { this.firstname = firstname; }

    public String getLastname() { return lastname; }

    public void setLastname(String lastname) { this.lastname = lastname; }

    public Department getDeptid() { return deptid; }

    public void setDeptid(Department deptid) { this.deptid = deptid; }

    public Set<Course> getCourses() { return courses; }

    public void setCourses(Set<Course> courses) { this.courses = courses; }

}