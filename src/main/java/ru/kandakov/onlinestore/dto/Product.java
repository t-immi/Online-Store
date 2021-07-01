package ru.kandakov.onlinestore.dto;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productid", nullable = false, updatable = false, unique = true)
    private Long id;

    @Column(name = "label", nullable = false)
    private String label;

    @Column(name = "price"/*, nullable = false*/)
    private int price;

    public Product() {

    }

    public Product(Long id, String label, int price) {
        this.id = id;
        this.label = label;
        this.price = price;

    }

    public Long getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public int getPrice() {
        return price;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
