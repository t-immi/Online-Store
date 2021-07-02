package ru.kandakov.onlinestore.dto;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id", nullable = false, updatable = false, unique = true)
    private Long roleId;

    @Column(name = "role", nullable = false, updatable = true, unique = true)
    private String role;

    @OneToMany(mappedBy = "role", fetch=FetchType.EAGER) //role_id
    private Collection<Customer> users;

    public Role() {
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
}
