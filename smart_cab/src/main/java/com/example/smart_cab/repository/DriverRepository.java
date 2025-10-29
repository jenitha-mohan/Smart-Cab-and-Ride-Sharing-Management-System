package com.example.smart_cab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.smart_cab.entity.Driver;

public interface DriverRepository extends JpaRepository<Driver,Long> {
    
}
