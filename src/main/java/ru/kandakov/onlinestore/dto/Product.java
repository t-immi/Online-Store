package ru.kandakov.onlinestore.dto;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false, updatable = false, unique = true)
    private Long productId;

    @Column(name = "label", nullable = false)
    private String label;

    @Column(name = "price"/*, nullable = false*/)
    private int price;

//    @ManyToOne(optional = false, cascade = CascadeType.ALL)
//    @JoinColumn(name = "product_id")    //, insertable = false, updatable = false
//    private ShoppingCartGoods shoppingCartGoods;

    public Product() {

    }

    public Product(Long product_id, String label, int price) {
        this.productId = product_id;
        this.label = label;
        this.price = price;

    }

    public Long getProduct_id() {
        return productId;
    }

    public String getLabel() {
        return label;
    }

    public int getPrice() {
        return price;
    }

    public void setId(Long product_id){
        this.productId = product_id;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
