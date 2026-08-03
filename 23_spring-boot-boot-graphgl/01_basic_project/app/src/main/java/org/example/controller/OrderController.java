package org.example.controller;

import org.example.entities.Order;
import org.example.entities.User;
import org.example.service.OrderService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

@Controller
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @MutationMapping
    public Order createOrder(
            @Argument String orderDetails,
            @Argument String address,
            @Argument Double price,
            @Argument UUID userId) {
        return orderService.createOrder(orderDetails, address, price, userId);
    }

    @QueryMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @QueryMapping
    public Order getOrder(@Argument UUID orderId) {
        return orderService.getOrder(orderId);
    }

    @MutationMapping
    public Order updateOrder(
            @Argument UUID orderId,
            @Argument String orderDetails,
            @Argument String address,
            @Argument Double price) {
        return orderService.updateOrder(orderId, orderDetails, address, price);
    }

    @MutationMapping
    public boolean deleteOrder(@Argument UUID orderId) {
        return orderService.deleteOrder(orderId);
    }
}
