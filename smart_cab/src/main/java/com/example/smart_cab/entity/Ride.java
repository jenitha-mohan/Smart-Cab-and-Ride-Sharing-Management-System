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
     private String pickupLocation;
     private String dropoffLocation;
     private Double fare;
     private String status;
     private LocalDateTime requestedAt=LocalDateTime.now();
     private LocalDateTime completedAt;
      @ManyToOne
      @JoinColumn(name="user_id")
      private User user;

      @ManyToOne
      @JoinColumn(name="driver_id")
      private Driver driver;

      @ManyToOne
      @JoinColumn(name="cab_id")
      private Cab cab;

}
