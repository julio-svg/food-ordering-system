package com.food.ordering.system.order.event;

import com.food.ordering.system.order.entity.Order;

import java.time.LocalDateTime;

public class OrderPaidEvent extends OrderEvent {
    public OrderPaidEvent(Order order, LocalDateTime createdAt) {
        super(order, createdAt);
    }
}
