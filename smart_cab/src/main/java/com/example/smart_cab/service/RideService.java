package com.example.smart_cab.service;

import com.example.smart_cab.entity.Ride;
import com.example.smart_cab.repository.RideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RideService {
    @Autowired
    private RideRepository rideRepository;

    public List<Ride> getAllRides(){
        return rideRepository.findAll();
    }
    
    public Optional<Ride> getRideById(Long id){
        return rideRepository.findById(id);
    }

    public Ride createRide(Ride ride){
        return rideRepository.save(ride);
    }

    
    public Ride updateRide(Long id, Ride rideDetails) {
        Ride ride = rideRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ride not found"));

        ride.setPickupLocation(rideDetails.getPickupLocation());
        ride.setDropoffLocation(rideDetails.getDropoffLocation());
        ride.setFare(rideDetails.getFare());
        ride.setStatus(rideDetails.getStatus());
        ride.setCompletedAt(rideDetails.getCompletedAt());
        return rideRepository.save(ride);
    }

    public boolean deleteRide(Long id){
        if(rideRepository.existsById(id)){
            rideRepository.deleteById(id);
            return true;
        }
        return false;
    }

    
}
