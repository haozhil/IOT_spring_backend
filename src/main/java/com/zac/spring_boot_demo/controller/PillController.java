package com.zac.spring_boot_demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zac.spring_boot_demo.Entity.Pill;
import com.zac.spring_boot_demo.service.PillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PillController {

    @Autowired
    private PillService pillService; // Spring 自动注入 PillService

    // 使用 @GetMapping 来处理 GET 请求
    @GetMapping("/getPills")
    public String getPills() throws Exception {
        // 调用服务层获取数据
        List<Pill> pills = pillService.getAllPills();

        // 使用 Jackson 将对象转换为 JSON
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(pills);  // 返回 JSON 响应
    }

    @GetMapping("/getCurrentWeight")
    public List<Double> getWeight(){
        return pillService.getAllWeights();
    }

    @GetMapping("/getLastTimeTaken")
    public List<String> getLastTimeTaken() {return pillService.getAllLastTimeTakens();}

    @PostMapping("/updatePill")
    public Pill updatePill(@RequestBody Pill pill) {
        System.out.println("Received pill data: " + pill);
        return pillService.savePill(pill);
    }
}