package com.example.smart_cab.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name="rides")
public class Ride {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
     private Long rideId;
     @ManyToOne
      @JoinColumn(name = "user_id", referencedColumnName = "userId")
     private User user;

     @ManyToOne
     @JoinColumn(name="driver_id",referencedColumnName="driverId")
     private Driver driver;

     @ManyToOne
     @JoinColumn(name="cab_id",referencedColumnName="cabId")
     private Cab  cab;

     @Column(nullable=false)
     private String pickupLocation;

     @Column(nullable=false)
     private String dropoffLocation;

     private Double fare;

     @Column(length=30)
     private String status="REQUESTED";
     private LocalDateTime requestedAt=LocalDateTime.now();
     private LocalDateTime completedAt;
      

}
