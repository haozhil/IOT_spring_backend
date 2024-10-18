package com.zac.spring_boot_demo.repository;

import com.zac.spring_boot_demo.Entity.Temperature;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TemeratureRepository extends JpaRepository<Temperature,Integer> {

    @Query("SELECT t.value FROM Temperature t WHERE t.id = :id")
    Double findValueById(@Param("id") int id);

    @Query("SELECT t.maxTemperature FROM Temperature t WHERE t.id = :id")
    Double findValueByIdMax(@Param("id") int id);

    @Modifying
    @Query("UPDATE Temperature t SET t.maxTemperature = :maxTemperature WHERE t.id = 1")
    void updateMaxTemperature(@Param("maxTemperature") double maxTemperature);
}
