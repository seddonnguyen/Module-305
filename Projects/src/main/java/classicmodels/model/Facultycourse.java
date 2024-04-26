package classicmodels.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "facultycourse")
public class Facultycourse {
    @EmbeddedId
    private FacultycourseId id;

    public FacultycourseId getId() { return id; }

    public void setId(FacultycourseId id) { this.id = id; }
}