package com.codegym.furamaresortcasestudy.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class AttachService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String attachName;
    private Double attachCost;
    private int attachUnit;
    private String attachStatus;
    @OneToMany(mappedBy = "attachService")
    private List<ContractDetail> contractDetailList;

    public AttachService() {
    }

    public AttachService(String attachName, Double attachCost, int attachUnit, String attachStatus, List<ContractDetail> contractDetailList) {
        this.attachName = attachName;
        this.attachCost = attachCost;
        this.attachUnit = attachUnit;
        this.attachStatus = attachStatus;
        this.contractDetailList = contractDetailList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAttachName() {
        return attachName;
    }

    public void setAttachName(String attachName) {
        this.attachName = attachName;
    }

    public Double getAttachCost() {
        return attachCost;
    }

    public void setAttachCost(Double attachCost) {
        this.attachCost = attachCost;
    }

    public int getAttachUnit() {
        return attachUnit;
    }

    public void setAttachUnit(int attachUnit) {
        this.attachUnit = attachUnit;
    }

    public String getAttachStatus() {
        return attachStatus;
    }

    public void setAttachStatus(String attachStatus) {
        this.attachStatus = attachStatus;
    }

    public List<ContractDetail> getContractDetailList() {
        return contractDetailList;
    }

    public void setContractDetailList(List<ContractDetail> contractDetailList) {
        this.contractDetailList = contractDetailList;
    }
}
