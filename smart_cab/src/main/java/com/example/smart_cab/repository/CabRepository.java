package com.example.smart_cab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.smart_cab.entity.Cab;
public interface CabRepository extends JpaRepository<Cab,Long> {
    

}
