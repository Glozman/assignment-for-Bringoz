package com.example.task.driver;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

    @Query("select d from Driver d where d.isRoute=true")
    List<Driver> findDriversOnRoute();

    @Query(value = "select * from Driver where start_time<=CURRENT_TIME and finish_time>CURRENT_TIME",nativeQuery = true)
    List<Driver> findDriversOnTime();
}
