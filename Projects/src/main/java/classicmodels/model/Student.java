package classicmodels.model;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "firstname", length = 30)
    private String firstname;

    @Column(name = "lastname", length = 50)
    private String lastname;

    @Column(name = "street", length = 50)
    private String street;

    @Column(name = "streetDetail", length = 30)
    private String streetDetail;

    @Column(name = "city", length = 30)
    private String city;

    @Column(name = "state", length = 30)
    private String state;

    @Column(name = "postalCode", length = 5)
    private String postalCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "majorId")
    private Department major;

    @OneToMany(mappedBy = "student")
    private Set<Studentcourse> studentcourses = new LinkedHashSet<>();

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getFirstname() { return firstname; }

    public void setFirstname(String firstname) { this.firstname = firstname; }

    public String getLastname() { return lastname; }

    public void setLastname(String lastname) { this.lastname = lastname; }

    public String getStreet() { return street; }

    public void setStreet(String street) { this.street = street; }

    public String getStreetDetail() { return streetDetail; }

    public void setStreetDetail(String streetDetail) { this.streetDetail = streetDetail; }

    public String getCity() { return city; }

    public void setCity(String city) { this.city = city; }

    public String getState() { return state; }

    public void setState(String state) { this.state = state; }

    public String getPostalCode() { return postalCode; }

    public void setPostalCode(String postalCode) { this.postalCode = postalCode; }

    public Department getMajor() { return major; }

    public void setMajor(Department major) { this.major = major; }

    public Set<Studentcourse> getStudentcourses() { return studentcourses; }

    public void setStudentcourses(Set<Studentcourse> studentcourses) { this.studentcourses = studentcourses; }
}