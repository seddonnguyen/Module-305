package glab._4_1B.model;

import jakarta.persistence.*;

@Entity
@Table(name = "DEPARTMENT")
public class Department {
    @Column(name = "DEPARTMENT_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String name;
    private String state;

    public Department(String name, String state) {
        this.name = name;
        this.state = state;
    }

    public Department() { }

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