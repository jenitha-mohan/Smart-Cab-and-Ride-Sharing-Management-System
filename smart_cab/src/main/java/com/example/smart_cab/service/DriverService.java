package com.example.smart_cab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.smart_cab.entity.Driver;
import com.example.smart_cab.repository.DriverRepository;
import java.util.List;
import java.util.Optional;

@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    public List<Driver>getAllDrivers(){
        return driverRepository.findAll();
    }
    
    public Optional<Driver> getDriverById(Long id){
        return driverRepository.findById(id);
    }

    public Driver createDriver(Driver driver){
        return driverRepository.save(driver);
    }
    
    public Driver updateDriver(Long id,Driver driverDetails){
        Driver driver=driverRepository.findById(id).orElseThrow(()-> new RuntimeException("Driver not found"));

         if (driverDetails.getName() != null) driver.setName(driverDetails.getName());
        if (driverDetails.getEmail() != null) driver.setEmail(driverDetails.getEmail());
        if (driverDetails.getPhone() != null) driver.setPhone(driverDetails.getPhone());
        if (driverDetails.getLicenseNumber() != null) driver.setLicenseNumber(driverDetails.getLicenseNumber());
        if (driverDetails.getVehicleNumber() != null) driver.setVehicleNumber(driverDetails.getVehicleNumber());
        driver.setAvailable(driverDetails.isAvailable());

        return driverRepository.save(driver);
    }

    public void deleteDriver(Long id){
        driverRepository.deleteById(id);
    }

}
