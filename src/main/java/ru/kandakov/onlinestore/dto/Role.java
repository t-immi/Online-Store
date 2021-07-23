package ru.kandakov.onlinestore.dto;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role /*implements GrantedAuthority*/ {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id", nullable = false, updatable = false, unique = true)
    private Long roleId;

    @Column(name = "role", nullable = false, updatable = false, unique = true)
    private String role;

//    @JsonBackReference(value = "customer-role")
//    @ManyToMany(mappedBy = "roles")
//    private Set<Customer> customers = new HashSet<>();

    @JsonManagedReference(value = "role-customerRoles")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "role")
    private Set<CustomerRoles> customerRoles = new HashSet<>();

    public Role() {

    }

    public Set<CustomerRoles> getCustomerRoles() {
        return customerRoles;
    }

    public void setCustomerRoles(Set<CustomerRoles> customerRoles) {
        this.customerRoles = customerRoles;
    }

    public Long getRole_id() {
        return roleId;
    }

    public void setRole_id(Long role_id) {
        this.roleId = role_id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

//    @Override
//    public String getAuthority() {
//        return getRole();
//    }
}
