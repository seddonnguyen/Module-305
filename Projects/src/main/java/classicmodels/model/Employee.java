package classicmodels.model;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "employees", indexes = {@Index(name = "officeCode", columnList = "officeCode"), @Index(name = "reportsTo", columnList = "reportsTo")})
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employeeNumber", nullable = false)
    private Integer id;

    @Column(name = "lastName", nullable = false, length = 50)
    private String lastName;

    @Column(name = "firstName", nullable = false, length = 50)
    private String firstName;

    @Column(name = "extension", nullable = false, length = 10)
    private String extension;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "officeCode", nullable = false)
    private Office officeCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reportsTo")
    private Employee reportsTo;

    @Column(name = "jobTitle", nullable = false, length = 50)
    private String jobTitle;

    @ColumnDefault("20")
    @Column(name = "VacationHours")
    private Integer vacationHours;

    @OneToMany(mappedBy = "salesRepEmployeeNumber")
    private Set<Customer> customers = new LinkedHashSet<>();

    @OneToMany(mappedBy = "reportsTo")
    private Set<Employee> employees = new LinkedHashSet<>();

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getExtension() { return extension; }

    public void setExtension(String extension) { this.extension = extension; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public Office getOfficeCode() { return officeCode; }

    public void setOfficeCode(Office officeCode) { this.officeCode = officeCode; }

    public Employee getReportsTo() { return reportsTo; }

    public void setReportsTo(Employee reportsTo) { this.reportsTo = reportsTo; }

    public String getJobTitle() { return jobTitle; }

    public void setJobTitle(String jobTitle) { this.jobTitle = jobTitle; }

    public Integer getVacationHours() { return vacationHours; }

    public void setVacationHours(Integer vacationHours) { this.vacationHours = vacationHours; }

    public Set<Customer> getCustomers() { return customers; }

    public void setCustomers(Set<Customer> customers) { this.customers = customers; }

    public Set<Employee> getEmployees() { return employees; }

    public void setEmployees(Set<Employee> employees) { this.employees = employees; }
}