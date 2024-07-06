package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "vendors")
public class Vendor {
    @Id
    private String id;
    private String name;
    private String type;
    private String contractPeriod;
    private String contractEnding;
    private String logo;

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContractPeriod() {
        return contractPeriod;
    }

    public void setContractPeriod(String contractPeriod) {
        this.contractPeriod = contractPeriod;
    }

    public String getContractEnding() {
        return contractEnding;
    }

    public void setContractEnding(String contractEnding) {
        this.contractEnding = contractEnding;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
