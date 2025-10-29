package com.example.smart_cab.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data 
@Table(name="drivers")
public class Driver {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long driverId;
    @Column(nullable=false)
    private String name;
    @Column(unique=true)
    private String phone;
    @Column(unique=true,nullable=false)

    private String license_number;
    private Double rating=0.0;
    private String status="AVAILABLE";
    //private boolean available=true;

    
}
