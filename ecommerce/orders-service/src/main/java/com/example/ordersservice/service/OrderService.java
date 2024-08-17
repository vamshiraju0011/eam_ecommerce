package com.example.ordersservice.service;

import com.example.ordersservice.entity.Order;
import com.example.ordersservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private KafkaProducerService kafkaProducerService;

    public Order createOrder(Order order) {
        // Save the order
        Order savedOrder = orderRepository.save(order);

        // Send order creation event to Kafka
        String message = String.format("Order created with ID: %d, Product ID: %d, Quantity: %d, Total Price: %.2f, Status: %s",
                savedOrder.getId(), savedOrder.getProductId(), savedOrder.getQuantity(), savedOrder.getTotalPrice(), savedOrder.getStatus());
        kafkaProducerService.sendOrderEvent(message);

        return savedOrder;
    }

    public Order updateOrder(Long id, Order orderDetails) {
        Order order = orderRepository.findById(id).orElse(null);
        if (order != null) {
            order.setCustomerName(orderDetails.getCustomerName());
            order.setProductId(orderDetails.getProductId());
            order.setQuantity(orderDetails.getQuantity());
            order.setTotalPrice(orderDetails.getTotalPrice());
            order.setStatus(orderDetails.getStatus());
            return orderRepository.save(order);
        }
        return null;
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}