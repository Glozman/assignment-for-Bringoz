package com.example.task.driver;

import javax.persistence.*;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.Timer;

@Entity
@Table
public class Driver {
    @Id
    @SequenceGenerator(
            name = "driver_sequence",
            sequenceName = "driver_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "driver_sequence"
    )
    private Long id;
    private String name;
    private String address;
    private int age;
    private boolean isRoute;
    private LocalTime startTime;
    private LocalTime finishTime;
    private String crnLocation;

    public Driver(){
    }

    public Driver(String name, String address, int age, boolean isRoute, LocalTime startTime, LocalTime finishTime, String crnLocation) {
        this.name = name;
        this.address = address;
        this.age = age;
        this.isRoute = isRoute;
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.crnLocation = crnLocation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean getIsRoute() {
        return isRoute;
    }

    public void setRoute(boolean route) {
        isRoute = route;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(LocalTime finishTime) {
        this.finishTime = finishTime;
    }



    public String getCrnLocation() {
        return crnLocation;
    }

    public void setCrnLocation(String crnLocation) {
        this.crnLocation = crnLocation;
    }
}
