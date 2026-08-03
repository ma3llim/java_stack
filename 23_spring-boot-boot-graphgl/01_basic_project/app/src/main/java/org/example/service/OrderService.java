package org.example.service;

import org.example.entities.Order;
import org.example.entities.User;
import org.example.repository.OrderRepository;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public OrderService(OrderRepository orderRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    public Order createOrder(String orderDetails, String address, Double price, UUID userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User Not Found with ID: " + userId));

        Order order = Order.builder()
                .orderDetails(orderDetails)
                .address(address)
                .price(price != null ? price : 0.0)
                .user(user)
                .build();

        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrder(UUID orderId) {
        return orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order Not Found"));
    }

    public Order updateOrder(UUID orderId, String orderDetails, String address, Double price) {
        Order orderExisting = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order Not Found with ID: " + orderId));

        if (orderDetails != null && !orderDetails.isBlank()) orderExisting.setOrderDetails(orderDetails);
        if (address != null && !address.isBlank()) orderExisting.setAddress(address);
        if (price != null && price > 0) orderExisting.setPrice(price);
        
        return orderExisting;
    }

    public boolean deleteOrder(UUID orderId) {
        if (orderRepository.existsById(orderId)) {
            orderRepository.deleteById(orderId);
            return true;
        }
        return false;
    }
}
