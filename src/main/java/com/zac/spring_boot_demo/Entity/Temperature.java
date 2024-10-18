package com.zac.spring_boot_demo.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "temperature")
public class Temperature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Double value;

    private Double maxTemperature;

    public Temperature() {
    }

    public Double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(Double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
