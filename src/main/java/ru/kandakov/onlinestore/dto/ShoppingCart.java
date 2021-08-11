package ru.kandakov.onlinestore.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "shopping_cart")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false, unique = true)
    private Long shoppingCartId;

    @Column(name = "customer_id", updatable = false, unique = true)
    private Long customerId;

    @JsonManagedReference(value = "shoppingCartGoods-ShoppingCart")
    @OneToMany (cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "shoppingCart")
//    @JoinColumn (name = "shopping_cart_goods_id")
    private Set<ShoppingCartGoods> shoppingCartGoodsSet;

    @JsonBackReference(value = "customer-shoppingCart")
    @OneToOne(optional = false, fetch = FetchType.LAZY)
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

    public Set<ShoppingCartGoods> getShoppingCartGoodsSet() {
        return shoppingCartGoodsSet;
    }

    public void setShoppingCartGoodsSet(Set<ShoppingCartGoods> shoppingCartGoodsSet) {
        this.shoppingCartGoodsSet = shoppingCartGoodsSet;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
