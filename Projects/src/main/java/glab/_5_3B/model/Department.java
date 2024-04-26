package glab._5_3B.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "department", schema = "teacher_db")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Department implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(targetEntity = Teacher.class, cascade = CascadeType.ALL)
    private List<Teacher> teacherList;

    public Department(String name) {
        super();
        this.name = name;
    }
}