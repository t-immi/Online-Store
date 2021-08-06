package ru.kandakov.onlinestore.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "shopping_cart")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false, unique = true)
    private Long shoppingCartId;

    @JsonManagedReference(value = "shoppingCartGoods-ShoppingCart")
    @OneToOne (optional = true, cascade=CascadeType.ALL)
    @JoinColumn (name = "shopping_cart_goods_id")
    private ShoppingCartGoods shoppingCartGoods;

    @JsonBackReference(value = "customer-shoppingCart")
    @OneToOne(optional = false)
    @JoinColumn(name = "customer_id", insertable = false, updatable = false)
    private Customer customer;

    public ShoppingCart() {

    }

    public Long getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(Long shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ShoppingCartGoods getShoppingCartGoods() {
        return shoppingCartGoods;
    }

    public void setShoppingCartGoods(ShoppingCartGoods shoppingCartGoods) {
        this.shoppingCartGoods = shoppingCartGoods;
    }
}
