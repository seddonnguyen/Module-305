package classicmodels.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class StudentcourseId implements Serializable {
    private static final long serialVersionUID = 194262441679468915L;
    @Column(name = "studentId") private Integer studentId;

    @Column(name = "courseId") private Integer courseId;

    public Integer getStudentId() { return studentId; }

    public void setStudentId(Integer studentId) { this.studentId = studentId; }

    public Integer getCourseId() { return courseId; }

    public void setCourseId(Integer courseId) { this.courseId = courseId; }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, courseId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) { return false; }
        StudentcourseId entity = (StudentcourseId) o;
        return Objects.equals(this.studentId, entity.studentId) && Objects.equals(this.courseId, entity.courseId);
    }

}