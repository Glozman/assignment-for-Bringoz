package com.example.task.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

@Service
public class DriverService {

    private final DriverRepository driverRepository;

    @Autowired
    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public void addNewDriver(Driver driver) {
        driverRepository.save(driver);
    }

    public List<Driver> getDrivers() {
        return driverRepository.findAll();
    }

    public void deleteDriver(Long id) {
        boolean exists = driverRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException(
                    "driver with id " + id + " does not exist");
        }
        driverRepository.deleteById(id);
    }

    @Transactional
    public void updateDriver(Long id, boolean isRoute, LocalTime startTime, LocalTime finishTime) {
        Driver driver = driverRepository.findById(id).orElseThrow(() ->
                new IllegalStateException(
                        "driver with id " + id + " does not exist"));
        if (!Objects.equals(driver.getIsRoute(), isRoute)) {
            driver.setRoute(isRoute);
        }
        if (startTime !=null &&
                !Objects.equals(driver.getStartTime(), startTime)) {
            driver.setStartTime(startTime);
        }
        if (finishTime !=null &&
                !Objects.equals(driver.getFinishTime(), finishTime)) {
            driver.setFinishTime(finishTime);
        }
    }

    public List<Driver> getDriverOnRoute() {
        return driverRepository.findDriversOnRoute();
    }

    public List<Driver> getDriverOnTime() {
        return driverRepository.findDriversOnTime();
    }
}
