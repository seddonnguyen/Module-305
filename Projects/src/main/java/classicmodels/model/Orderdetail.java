package classicmodels.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "orderdetails", indexes = {@Index(name = "productCode", columnList = "productCode")})
public class Orderdetail {
    @EmbeddedId private OrderdetailId id;

    @MapsId("orderNumber")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "orderNumber", nullable = false)
    private Order orderNumber;

    @MapsId("productCode")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "productCode", nullable = false)
    private Product productCode;

    @Column(name = "quantityOrdered", nullable = false) private Integer quantityOrdered;

    @Column(name = "priceEach", nullable = false, precision = 10, scale = 2) private BigDecimal priceEach;

    @Column(name = "orderLineNumber", nullable = false) private Short orderLineNumber;

    public OrderdetailId getId() { return id; }

    public void setId(OrderdetailId id) { this.id = id; }

    public Order getOrderNumber() { return orderNumber; }

    public void setOrderNumber(Order orderNumber) { this.orderNumber = orderNumber; }

    public Product getProductCode() { return productCode; }

    public void setProductCode(Product productCode) { this.productCode = productCode; }

    public Integer getQuantityOrdered() { return quantityOrdered; }

    public void setQuantityOrdered(Integer quantityOrdered) { this.quantityOrdered = quantityOrdered; }

    public BigDecimal getPriceEach() { return priceEach; }

    public void setPriceEach(BigDecimal priceEach) { this.priceEach = priceEach; }

    public Short getOrderLineNumber() { return orderLineNumber; }

    public void setOrderLineNumber(Short orderLineNumber) { this.orderLineNumber = orderLineNumber; }

}