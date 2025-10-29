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

    public Driver addDriver(Driver driver){
        return driverRepository.save(driver);
    }
 
    public List<Driver>getAllDrivers(){
        return driverRepository.findAll();
    }
    
    public Optional<Driver> getDriverById(Long id){
        return driverRepository.findById(id);
    }

    public Driver createDriver(Driver driver){
        return driverRepository.save(driver);
    }
    
    public Driver updateDriver(Long id, Driver updatedDriver) {
        return driverRepository.findById(id).map(driver -> {
            driver.setName(updatedDriver.getName());
            driver.setPhone(updatedDriver.getPhone());
            driver.setLicense_number(updatedDriver.getLicense_number());
            driver.setRating(updatedDriver.getRating());
            driver.setStatus(updatedDriver.getStatus());
            return driverRepository.save(driver);
        }).orElse(null);
    }


    public boolean deleteDriver(Long id) {
        if (driverRepository.existsById(id)) {
            driverRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
