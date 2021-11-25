package com.codegym.pigmanagement.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Pig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pigCode;
    @Column(columnDefinition = "Date")
    private String importTime;
    private Double importKg;
    @Column(columnDefinition = "Date")
    private String exportTime;
    private Double exportKg;
    private int status;
    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    private OriginCountry country;

    public Pig() {
    }

    public Pig(String pigCode, String importTime, Double importKg, String exportTime, Double exportKg) {
        this.pigCode = pigCode;
        this.importTime = importTime;
        this.importKg = importKg;
        this.exportTime = exportTime;
        this.exportKg = exportKg;

    }

    public Pig(String pigCode, String importTime, Double importKg, String exportTime, Double exportKg, int status, OriginCountry country) {
        this.pigCode = pigCode;
        this.importTime = importTime;
        this.importKg = importKg;
        this.exportTime = exportTime;
        this.exportKg = exportKg;
        this.status = status;
        this.country = country;
    }

    public Pig(String pigCode, String importTime, Double importKg, String exportTime, Double exportKg, OriginCountry country) {
        this.pigCode = pigCode;
        this.importTime = importTime;
        this.importKg = importKg;
        this.exportTime = exportTime;
        this.exportKg = exportKg;

        this.country = country;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public OriginCountry getCountry() {
        return country;
    }

    public void setCountry(OriginCountry country) {
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPigCode() {
        return pigCode;
    }

    public void setPigCode(String pigCode) {
        this.pigCode = pigCode;
    }

    public String getImportTime() {
        return importTime;
    }

    public void setImportTime(String importTime) {
        this.importTime = importTime;
    }

    public Double getImportKg() {
        return importKg;
    }

    public void setImportKg(Double importKg) {
        this.importKg = importKg;
    }

    public String getExportTime() {
        return exportTime;
    }

    public void setExportTime(String exportTime) {
        this.exportTime = exportTime;
    }

    public Double getExportKg() {
        return exportKg;
    }

    public void setExportKg(Double exportKg) {
        this.exportKg = exportKg;
    }

}
