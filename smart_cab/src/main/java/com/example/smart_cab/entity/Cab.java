package com.example.smart_cab.entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="cabs")
public class Cab {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long cabId;

    @OneToOne
    @JoinColumn(name="driver_id",referencedColumnName="driverId")
    private Driver driver;

    @Column(nullable=false,unique=true)
    private String cabNumber;

    private String cabType;
    private Integer capacity;
    private String status="ACTIVE";

}
