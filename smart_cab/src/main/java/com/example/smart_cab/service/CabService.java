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
    public List<Cab> getAllCabs(Long id){
        return cabRepository.findAll();
    }
     public Optional<Cab> getCabById(Long id){
        return cabRepository.save(cab);
     }
}
