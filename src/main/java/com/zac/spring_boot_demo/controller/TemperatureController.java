package com.zac.spring_boot_demo.controller;

import com.zac.spring_boot_demo.Entity.Pill;
import com.zac.spring_boot_demo.service.TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class TemperatureController {

    @Autowired
    TemperatureService temperatureService;

    @GetMapping("/tempServlet")
    public double getTemp(){
        return temperatureService.getTemperature();
    }

    @GetMapping("/queryMaxtemp")
    public double getMaxTemp(){return temperatureService.getMaxTemperature();}

    // 定义一个 POST 路由用于接收前端传输的 JSON 数据
    @PostMapping("/updateMaxTemperature")
    public ResponseEntity<String> updateMaxTemperature(@RequestBody Map<String, Object> payload) {
        try {
            double maxTemperature = Double.parseDouble(payload.get("maxTemperature").toString());
            // 调用服务更新 maxTemperature，直接操作 id = 1 的记录
            temperatureService.updateMaxTemperature(maxTemperature);
            return ResponseEntity.ok("Max temperature updated successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to update max temperature.");
        }
    }
}
