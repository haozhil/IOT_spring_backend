package com.zac.spring_boot_demo.service;

import com.zac.spring_boot_demo.Entity.Pill;
import com.zac.spring_boot_demo.repository.PillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PillService {

    @Autowired
    private PillRepository pillRepository;

    // 获取所有药物
    public List<Pill> getAllPills() {
        return pillRepository.findAll();
    }

    // 添加或更新药物
    public Pill savePill(Pill pill) {
        // 1. 如果 pill 有 ID，说明是更新操作，需要保留 weight
            // 2. 从数据库中获取现有的 pill 对象
            Pill existingPill = pillRepository.findById((long) pill.getId()).orElseThrow(() -> new RuntimeException("Pill not found"));

            // 3. 如果前端传递的 weight 为 null，则保留现有的 weight 值
            if (pill.getWeight() == null) {
                pill.setWeight(existingPill.getWeight());
            }

        // 4. 保存 pill 对象（带有保留的 weight 值）
        return pillRepository.save(pill);
    }

    // 删除药物
    public void deletePill(Long id) {
        pillRepository.deleteById(id);
    }

    // 根据ID获取药物
    public Pill getPillById(Long id) {
        return pillRepository.findById(id).orElse(null);
    }

    // 获取所有药物的 weight
    public List<Double> getAllWeights() {
        return pillRepository.findAllWeights();
    }

    public List<String> getAllLastTimeTakens() {return  pillRepository.findAlllastTimeTakens();}
}