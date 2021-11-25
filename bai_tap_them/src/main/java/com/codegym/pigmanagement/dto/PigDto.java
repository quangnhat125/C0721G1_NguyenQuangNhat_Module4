package com.codegym.pigmanagement.dto;

import com.codegym.pigmanagement.model.OriginCountry;
import com.codegym.pigmanagement.model.Pig;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.util.List;

public class PigDto implements Validator {

    private Long id;
    @Pattern(regexp = "MH-\\d{3}" , message = "ABC")
    private String pigCode;
    private String importTime;
    @Min(value = 10, message ="ABB")
    private Double importKg;

    private String exportTime;
    @Min(value = 10, message ="ABBB")
    private Double exportKg;
    private int status;

    private OriginCountry country;
    private List<Pig> pigList;

    public PigDto() {
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

    public List<Pig> getPigList() {
        return pigList;
    }

    public void setPigList(List<Pig> pigList) {
        this.pigList = pigList;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        PigDto pigDto = (PigDto) target;
        for (Pig p : pigDto.getPigList()) {
            if (p.getPigCode().equals(pigDto.getPigCode())) {
                errors.rejectValue("pigCode", "Code", "Code is already exists!");
            }
        }
    }
}
