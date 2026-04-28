package com.sameer.ecommerce.controllers;

import com.sameer.ecommerce.model.Order;
import com.sameer.ecommerce.model.dto.orders.OrderRequest;
import com.sameer.ecommerce.model.dto.orders.OrderResponse;
import com.sameer.ecommerce.service.OrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    @Autowired
    private OrderServices orderServices;

    @GetMapping
    public ResponseEntity<List<OrderResponse>> getAllOrders(){
        List<OrderResponse> responses = orderServices.getAllOrders();
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @PostMapping("/place")
    public ResponseEntity<OrderResponse> placeOrder(@RequestBody OrderRequest orderRequest){
        OrderResponse orderResponse = orderServices.placeOrder(orderRequest);
        return new ResponseEntity<>(orderResponse, HttpStatus.CREATED);
    }
}
