package com.zac.spring_boot_demo.Entity;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zac.spring_boot_demo.converter.ListToJsonConverter;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pill")
public class Pill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    private Integer initialQuantity;
    private Integer doseAmount;
    //@Convert(converter = ListToJsonConverter.class)  // 使用自定义转换器
    private String doseTimes;
    private Double weight;
    private Double singleWeight;
    private String lastTimeTaken;

    public Pill() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getInitialQuantity() {
        return initialQuantity;
    }

    public void setInitialQuantity(Integer initialQuantity) {
        this.initialQuantity = initialQuantity;
    }

    public Integer getDoseAmount() {
        return doseAmount;
    }

    public void setDoseAmount(Integer doseAmount) {
        this.doseAmount = doseAmount;
    }

    public String getDoseTimes() {
        return doseTimes;
    }

    public void setDoseTimes(String doseTimes) {
        this.doseTimes = doseTimes;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getSingleWeight() {
        return singleWeight;
    }

    public void setSingleWeight(Double singleWeight) {
        this.singleWeight = singleWeight;
    }

    public String getLastTimeTaken() {
        return lastTimeTaken;
    }

    public void setLastTimeTaken(String lastTimeTaken) {
        this.lastTimeTaken = lastTimeTaken;
    }

}

