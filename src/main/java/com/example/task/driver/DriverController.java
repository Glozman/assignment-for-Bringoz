package com.example.task.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/drivers")
public class DriverController {

    private final DriverService driverService;

    @Autowired
	public DriverController(DriverService driverService) {
		this.driverService = driverService;
	}

	@GetMapping
	public List<Driver> getDrivers() {
		return driverService.getDrivers();
	}

	@PostMapping(path = "/add")
	public void registerNewDriver(@RequestBody Driver driver) {
    	driverService.addNewDriver(driver);
	}

	@DeleteMapping(path = "/delete/{driverId}")
	public void deleteDriver(@PathVariable("driverId") Long id) {
		driverService.deleteDriver(id);
	}

	@PutMapping(path = "/change/{driverId}")
	public void updateDriver(
			@PathVariable("driverId") Long id,
			@RequestParam(required = false) boolean isRoute,
			@RequestParam(required = false) LocalTime startTime,
			@RequestParam(required = false) LocalTime finishTime) {
    	driverService.updateDriver(id, isRoute, startTime, finishTime);

	}

	@GetMapping("/onRoute")
	public List<Driver> getDriverOnRoute() {
    	return driverService.getDriverOnRoute();
	}

	@GetMapping("/onTime")
	public List<Driver> getDriverOnTime() {
		return driverService.getDriverOnTime();
	}


}
