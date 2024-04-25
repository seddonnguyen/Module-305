package classicmodels.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "studentcourse")
public class Studentcourse {
    @EmbeddedId private StudentcourseId id;

    @Column(name = "progress") private Integer progress;

    @Column(name = "startDate") private LocalDate startDate;

    public StudentcourseId getId() { return id; }

    public void setId(StudentcourseId id) { this.id = id; }

    public Integer getProgress() { return progress; }

    public void setProgress(Integer progress) { this.progress = progress; }

    public LocalDate getStartDate() { return startDate; }

    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

}