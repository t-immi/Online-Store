package ru.kandakov.onlinestore.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer /*implements UserDetails*/ {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", nullable = false, updatable = false, unique = true)
    private Long customerId;

    @Column(name = "role_id", updatable = false)
    private Long roleId;

    @Column(name = "name", nullable = false)
    private String name;

//    @Column
//    private String password;
//
//    @Transient
//    private String passwordConfirm;

    @JsonManagedReference(value = "customer-shoppingCart")
    @OneToOne (optional = false, cascade=CascadeType.ALL)
    @JoinTable(name = "customer_shoppingCart", joinColumns = @JoinColumn(name = "shopping_cart_id"))
    private ShoppingCart shoppingCart;

    @JsonManagedReference(value = "customer-order")
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Order> orders;

    @JsonManagedReference(value = "customer-customerRoles")
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private Set<CustomerRoles> customerRoles = new HashSet<>();

    public Customer() {

    }

//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public String getPasswordConfirm() {
//        return passwordConfirm;
//    }
//
//    public void setPasswordConfirm(String passwordConfirm) {
//        this.passwordConfirm = passwordConfirm;
//    }


    public Set<CustomerRoles> getCustomerRoles() {
        return customerRoles;
    }

    public void setCustomerRoles(Set<CustomerRoles> customerRoles) {
        this.customerRoles = customerRoles;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    //    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return name;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
}
