package com.example.smart_cab.service;

import com.example.smart_cab.entity.Cab;
import com.example.smart_cab.repository.CabRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CabService {
    @Autowired
    private CabRepository cabRepository;
    public List<Cab> getAllCabs(){
        return cabRepository.findAll();
    }
     public Optional<Cab> getCabById(Long id){
        return cabRepository.findById(id);
     }
     public Cab createCab(Cab cab){
        return cabRepository.save(cab);
     }

     public Cab updateCab(Long id,Cab cabDetails){
        Cab cab = cabRepository.findById(id).orElseThrow(()->new RuntimeException("cab not found"));

        if (cabDetails.getCabNumber() != null)
            cab.setCabNumber(cabDetails.getCabNumber());
        if (cabDetails.getCabType() != null)
            cab.setCabType(cabDetails.getCabType());
        if (cabDetails.getCapacity() != null)
            cab.setCapacity(cabDetails.getCapacity());
        if (cabDetails.getStatus() != null)
            cab.setStatus(cabDetails.getStatus());
        if (cabDetails.getDriver() != null)
            cab.setDriver(cabDetails.getDriver());

        return cabRepository.save(cab);

     }
    public void deleteCab(Long id) {
        cabRepository.deleteById(id);
    }
}
