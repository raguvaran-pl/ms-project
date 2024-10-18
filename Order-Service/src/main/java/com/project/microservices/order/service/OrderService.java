package com.project.microservices.order.service;

import com.project.microservices.order.dto.OrderRequest;
import com.project.microservices.order.dto.OrderResponse;
import com.project.microservices.order.model.Order;
import com.project.microservices.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderResponse placeOrder(OrderRequest orderRequest){
        Order order = Order.builder().orderNumber(UUID.randomUUID().toString())
                .price(orderRequest.price())
                .quantity(orderRequest.quantity())
                .skuCode(orderRequest.skuCode()).build();

       order = orderRepository.save(order);
        return new OrderResponse(order.getId(), order.getOrderNumber(), order.getPrice());

    }
}
