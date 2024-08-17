package com.example.ordersservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ordersservice.entity.Order;
public interface OrderRepository extends JpaRepository<Order, Long> {
}