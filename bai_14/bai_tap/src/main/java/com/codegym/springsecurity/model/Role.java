package com.codegym.springsecurity.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roleName;
    @ManyToMany(mappedBy = "roleList")
    private Set<User> userSet;

    public Role() {
    }

    public Role(Long id, String roleName, Set<User> userSet) {
        this.id = id;
        this.roleName = roleName;
        this.userSet = userSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }
}
