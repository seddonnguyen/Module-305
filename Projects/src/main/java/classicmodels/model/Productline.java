package classicmodels.model;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "productlines")
public class Productline {
    @Id
    @Column(name = "productLine", nullable = false, length = 50)
    private String productLine;

    @Column(name = "textDescription", length = 4000) private String textDescription;

    @Lob
    @Column(name = "htmlDescription")
    private String htmlDescription;

    @Column(name = "image") private byte[] image;

    @OneToMany(mappedBy = "productLine") private Set<Product> products = new LinkedHashSet<>();

    public String getProductLine() { return productLine; }

    public void setProductLine(String productLine) { this.productLine = productLine; }

    public String getTextDescription() { return textDescription; }

    public void setTextDescription(String textDescription) { this.textDescription = textDescription; }

    public String getHtmlDescription() { return htmlDescription; }

    public void setHtmlDescription(String htmlDescription) { this.htmlDescription = htmlDescription; }

    public byte[] getImage() { return image; }

    public void setImage(byte[] image) { this.image = image; }

    public Set<Product> getProducts() { return products; }

    public void setProducts(Set<Product> products) { this.products = products; }

}