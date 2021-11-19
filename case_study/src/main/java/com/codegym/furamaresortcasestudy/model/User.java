package com.codegym.furamaresortcasestudy.model;

import javax.persistence.*;
import java.util.Set;
@Entity
public class User {
    @Id
    private Long id;
    private String username;
    private String password;
    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roleSet;

}
