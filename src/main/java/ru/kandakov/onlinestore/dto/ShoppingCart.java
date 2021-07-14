package ru.kandakov.onlinestore.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "shopping_cart")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shoppingCart_id", nullable = false, updatable = false, unique = true)
    private Long shoppingCartId;

    @Column(name = "date_of_creation", nullable = false, updatable = false, unique = true)
    private Date dateOfCreation = new Date();

    @OneToOne (optional = false, cascade=CascadeType.ALL)
    @JoinColumn (name = "shopping_cart_goods_id")
    @JsonManagedReference
    private ShoppingCartGoods shoppingCartGoods;

    @JsonBackReference
    @OneToOne(optional = false, mappedBy="shoppingCart")
    private Customer customer;

    public ShoppingCart() {

    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
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
