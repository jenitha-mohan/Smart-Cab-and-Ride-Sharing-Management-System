package com.example.smart_cab.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    @ManyToOne
    @JoinColumn(name = "ride_id", referencedColumnName = "rideId", nullable = false)
    private Ride ride;

    @Column(nullable = false)
    private String paymentMode;  // UPI, CARD, CASH, etc.

    @Column(nullable = false)
    private Double amount;

    @Column(length = 30)
    private String status = "PENDING";  // PENDING / SUCCESS / FAILED

    private LocalDateTime transactionTime = LocalDateTime.now();
}
