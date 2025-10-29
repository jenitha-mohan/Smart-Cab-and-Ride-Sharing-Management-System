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
    private String name;
     @Column(unique=true,nullable=false)
     private String email;
     private String phone;
     private String licenseNumber;
     private String vehicleNumber;
     private boolean available=true;

    
}
