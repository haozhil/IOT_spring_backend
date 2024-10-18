package com.zac.spring_boot_demo.repository;

import com.zac.spring_boot_demo.Entity.Pill;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PillRepository extends JpaRepository<Pill, Long> {
    @Query("SELECT p.weight FROM Pill p")
    List<Double> findAllWeights();

    @Query("SELECT p.lastTimeTaken FROM Pill p")
    List<String> findAlllastTimeTakens();
}
