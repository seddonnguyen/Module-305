package glab._4_1B.model;

import jakarta.persistence.*;

@Entity
@Table(name = "USER", schema = "usersDb")
public class User {
    @Column(name = "USER_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String fullName;
    private String email;
    private String password;
    private int age;
    private double salary;
    private String city;

    public User(String fullName, String email, String password, int age, double salary, String city) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.age = age;
        this.salary = salary;
        this.city = city;
    }

    public User() { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}