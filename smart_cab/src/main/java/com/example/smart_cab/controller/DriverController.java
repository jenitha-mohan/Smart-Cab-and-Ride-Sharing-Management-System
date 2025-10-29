package com.example.smart_cab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.smart_cab.entity.Driver;
import com.example.smart_cab.service.DriverService;
import java.util.List;
@RestController
@RequestMapping("/drivers")
public class DriverController{
    @Autowired
    private DriverService driverService;

    @GetMapping
    public List<Driver> getAllDrivers(){
        return driverService.getAllDrivers();
    }

    @GetMapping("/{id}")
    public Driver getDriverById(@PathVariable Long id){
        return driverService.getDriverById(id).orElseThrow(()->new RuntimeException("Driver not found"));
    }

    @PostMapping
    public Driver createDriver(@RequestBody Driver driver){
        return driverService.addDriver(driver);
    }

    @PutMapping("/{id}")
    public Driver updateDriver(@PathVariable Long id,@RequestBody Driver driverDetails){
        return driverService.updateDriver(id,driverDetails);
    }
    
    @DeleteMapping("/{id}")
    public String deleteDriver(@PathVariable Long id) {
        boolean deleted =driverService.deleteDriver(id);
        return deleted? "Driver deleted successfully!":"Driver not found!";
    }
}