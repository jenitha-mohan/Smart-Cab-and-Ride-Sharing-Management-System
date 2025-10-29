package com.example.smart_cab.controller;

import com.example.smart_cab.entity.Cab;
import com.example.smart_cab.service.CabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/cabs")

public class CabController{
    @Autowired
    private CabService cabService;

    @GetMapping
    public List<Cab>getAllCabs(){
        return cabService.getAllCabs();

    }

    @GetMapping("/{id}")
    public Cab getCabById(@PathVariable Long id){
        return cabService.getCabById(id).orElseThrow(()->new RuntimeException("Cab not found"));
    }

    @PostMapping
    public Cab createCab(@RequestBody Cab cab){
        return cabService.createCab(cab);
    }

    @PutMapping("/{id}")
    public Cab updateCab(@PathVariable Long id,@RequestBody Cab cabDetails){
        return cabService.updateCab(id,cabDetails);
    }

     @DeleteMapping("/{id}")
    public String deleteCab(@PathVariable Long id) {
        cabService.deleteCab(id);
        return "Cab deleted successfully!";
    }
}