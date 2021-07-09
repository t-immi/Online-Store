package ru.kandakov.onlinestore.dto;

import javax.persistence.*;

@Entity
@Table(name = "shopping_cart")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shoppingCart_id", nullable = false, updatable = false, unique = true)
    private Long shoppingCartId;

    @Column(name = "customer_id", nullable = false, updatable = false, unique = true)
    private Long customerId;

    @OneToOne (optional=true, cascade=CascadeType.ALL)
    private ShoppingCartGoods shoppingCartGoods;

    @OneToOne(optional = false, mappedBy="shoppingCart")
    private Customer customer;

    public ShoppingCart() {

    }

    public Long getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(Long shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
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
