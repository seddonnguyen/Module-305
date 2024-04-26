package glab._5_3B.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cohort", schema = "teacher_db")
@NoArgsConstructor
@Data
public class Cohort {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cohortId;

    private String cohortName;
    private String duration;

    public Cohort(String cohortName, String duration) {
        this.cohortName = cohortName;
        this.duration = duration;
    }
}