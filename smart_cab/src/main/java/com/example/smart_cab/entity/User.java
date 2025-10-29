package com.example.smart_cab.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String name;

    @Column(unique=true,nullable=false)
    private String email;
    private String phone;
    private String password;
   
    }


    

