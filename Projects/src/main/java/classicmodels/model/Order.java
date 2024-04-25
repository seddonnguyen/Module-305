package classicmodels.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "orders", indexes = {@Index(name = "customerNumber", columnList = "customerNumber")})
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderNumber", nullable = false)
    private Integer id;

    @Column(name = "orderDate", nullable = false) private LocalDate orderDate;

    @Column(name = "requiredDate", nullable = false) private LocalDate requiredDate;

    @Column(name = "shippedDate") private LocalDate shippedDate;

    @Column(name = "status", nullable = false, length = 15) private String status;

    @Lob
    @Column(name = "comments")
    private String comments;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customerNumber", nullable = false)
    private Customer customerNumber;

    @OneToMany(mappedBy = "orderNumber") private Set<Orderdetail> orderdetails = new LinkedHashSet<>();

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public LocalDate getOrderDate() { return orderDate; }

    public void setOrderDate(LocalDate orderDate) { this.orderDate = orderDate; }

    public LocalDate getRequiredDate() { return requiredDate; }

    public void setRequiredDate(LocalDate requiredDate) { this.requiredDate = requiredDate; }

    public LocalDate getShippedDate() { return shippedDate; }

    public void setShippedDate(LocalDate shippedDate) { this.shippedDate = shippedDate; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public String getComments() { return comments; }

    public void setComments(String comments) { this.comments = comments; }

    public Customer getCustomerNumber() { return customerNumber; }

    public void setCustomerNumber(Customer customerNumber) { this.customerNumber = customerNumber; }

    public Set<Orderdetail> getOrderdetails() { return orderdetails; }

    public void setOrderdetails(Set<Orderdetail> orderdetails) { this.orderdetails = orderdetails; }

}