package com.codegym.pigmanagement.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class OriginCountry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String countryName;
    @JsonBackReference(value = "backClass")
    @OneToMany(mappedBy = "country")
    private List<Pig> pigList;

    public OriginCountry() {
    }

    public OriginCountry(String countryName, List<Pig> pigList) {
        this.countryName = countryName;
        this.pigList = pigList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public List<Pig> getPigList() {
        return pigList;
    }

    public void setPigList(List<Pig> pigList) {
        this.pigList = pigList;
    }
}
