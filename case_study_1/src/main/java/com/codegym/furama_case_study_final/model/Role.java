package com.codegym.furama_case_study_final.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
public class Role {
    @Id
    private Long id;
    private String roleName;
    @ManyToMany(mappedBy = "roleSet")
    private Set<User> userSet;
}
