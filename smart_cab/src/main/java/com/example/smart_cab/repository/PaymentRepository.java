package com.example.smart_cab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.smart_cab.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}

