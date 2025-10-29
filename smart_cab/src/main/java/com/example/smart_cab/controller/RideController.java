package com.example.smart_cab.controller;

import com.example.smart_cab.entity.Ride;
import com.example.smart_cab.service.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/rides")
public class RideController {
    @Autowired
    private RideService rideService;

    @GetMapping
    public List<Ride> getAllRides(){
        return rideService.getAllRides();
    }

    @GetMapping("/{id}")
    public Ride getRideByIde(@PathVariable Long id){
        return rideService.getRideById(id).orElseThrow(()->new RuntimeException("Ride not found"));

    }

    @PostMapping
    public Ride createRide(@RequestBody Ride ride){
        return rideService.createRide(ride);
    }

    @PutMapping("/{id}")
    public Ride updateRide(@PathVariable Long id,@RequestBody Ride rideDetails){
        return rideService.updateRide(id,rideDetails);
    }

    @DeleteMapping("/{id}")
    public String deleteRide(@PathVariable Long id){
         boolean deleted=rideService.deleteRide(id);
        return deleted? "Ride deleted successfully!":"Ride not found";

    }



}
