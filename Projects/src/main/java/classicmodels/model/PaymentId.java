package classicmodels.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PaymentId implements Serializable {
    private static final long serialVersionUID = 2349203382643874653L;
    @Column(name = "customerNumber", nullable = false)
    private Integer customerNumber;

    @Column(name = "checkNumber", nullable = false, length = 50)
    private String checkNumber;

    public Integer getCustomerNumber() { return customerNumber; }

    public void setCustomerNumber(Integer customerNumber) { this.customerNumber = customerNumber; }

    public String getCheckNumber() { return checkNumber; }

    public void setCheckNumber(String checkNumber) { this.checkNumber = checkNumber; }

    @Override
    public int hashCode() {
        return Objects.hash(checkNumber, customerNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) { return false; }
        PaymentId entity = (PaymentId) o;
        return Objects.equals(this.checkNumber, entity.checkNumber) && Objects.equals(this.customerNumber, entity.customerNumber);
    }
}