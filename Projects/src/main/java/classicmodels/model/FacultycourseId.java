package classicmodels.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class FacultycourseId implements Serializable {
    private static final long serialVersionUID = 7450461309984737510L;
    @Column(name = "facultyId") private Integer facultyId;

    @Column(name = "courseId") private Integer courseId;

    public Integer getFacultyId() { return facultyId; }

    public void setFacultyId(Integer facultyId) { this.facultyId = facultyId; }

    public Integer getCourseId() { return courseId; }

    public void setCourseId(Integer courseId) { this.courseId = courseId; }

    @Override
    public int hashCode() {
        return Objects.hash(facultyId, courseId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) { return false; }
        FacultycourseId entity = (FacultycourseId) o;
        return Objects.equals(this.facultyId, entity.facultyId) && Objects.equals(this.courseId, entity.courseId);
    }

}