package ru.kandakov.onlinestore.dto;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", nullable = false, updatable = false, unique = true)
    private Long customerId;

    @Column(name = "role_id", nullable = false, updatable = false, unique = true)
    private Long roleId;

    @ManyToOne (optional = false, cascade = CascadeType.ALL)
    @JoinColumn (name = "role_id", insertable = false, updatable = false) //role_id
    private Role role;

    @OneToOne (optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name = "shopping_cart_id")
    private ShoppingCart shoppingCart;

    @OneToMany (mappedBy = "customer", fetch = FetchType.EAGER)
    private Collection<Order> orders;

    public Customer() {

    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public Collection<Order> getOrders() {
        return orders;
    }

    public void setOrders(Collection<Order> orders) {
        this.orders = orders;
    }
}
