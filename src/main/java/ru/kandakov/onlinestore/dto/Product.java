package ru.kandakov.onlinestore.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;

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

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    @JsonManagedReference(value = "product-orderGoods")
    private Collection<OrderGoods> orderGoods;

    @OneToMany (mappedBy = "product", fetch = FetchType.LAZY)
    @JsonManagedReference(value = "product-shoppingCartGoods")
    private Collection<ShoppingCartGoods> shoppingCartGoods;

    public Product() {

    }

    public Collection<OrderGoods> getOrderGoods() {
        return orderGoods;
    }

    public void setOrderGoods(Collection<OrderGoods> orderGoods) {
        this.orderGoods = orderGoods;
    }

    public Collection<ShoppingCartGoods> getShoppingCartGoods() {
        return shoppingCartGoods;
    }

    public void setShoppingCartGoods(Collection<ShoppingCartGoods> shoppingCartGoods) {
        this.shoppingCartGoods = shoppingCartGoods;
    }

    public Long getProductId() {
        return productId;
    }

    public String getLabel() {
        return label;
    }

    public int getPrice() {
        return price;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setPrice(int price) {
        this.price = price;
    }



}
