package com.food.ordering.system.order.event;

import com.food.ordering.system.order.entity.Order;

import java.time.LocalDateTime;

public class OrderCancelationEvent extends OrderEvent {

    public OrderCancelationEvent(Order order, LocalDateTime createdAt) {
        super(order, createdAt);
    }
}
