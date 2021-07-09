package ru.kandakov.onlinestore.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", nullable = false, updatable = false, unique = true)
    private Long customerId;

    @Column(name = "role_id", nullable = false, updatable = false, unique = true)
    private Long roleId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column
    private String password;

    @Transient
    private String passwordConfirm;

//    @OneToMany(mappedBy = "customer", fetch =  FetchType.EAGER)
//    private Collection<Role> roles;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;

    @OneToOne (optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name = "shopping_cart_id")
    private ShoppingCart shoppingCart;

//    @ManyToOne (optional = false, cascade = CascadeType.ALL)
//    @JoinColumn(name = "customer_id", insertable = false, updatable = false)
//    private Order order;
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private Collection<Order> orders;

    public Customer() {

    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
