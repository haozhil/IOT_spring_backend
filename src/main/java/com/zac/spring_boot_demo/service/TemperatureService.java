package com.zac.spring_boot_demo.service;

import com.zac.spring_boot_demo.repository.TemeratureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TemperatureService {

    @Autowired
    private TemeratureRepository temeratureRepository;

    public double getTemperature(){
        return temeratureRepository.findValueById(1);
    }

    public double getMaxTemperature(){return temeratureRepository.findValueByIdMax(1); }

    @Transactional
    public void updateMaxTemperature(double maxTemperature) {
        temeratureRepository.updateMaxTemperature(maxTemperature);
    }
}
