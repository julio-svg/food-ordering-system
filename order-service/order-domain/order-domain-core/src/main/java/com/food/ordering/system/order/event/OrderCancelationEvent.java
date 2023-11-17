package com.food.ordering.system.order.event;

import com.food.ordering.system.order.entity.Order;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class OrderCancelationEvent extends OrderEvent {

    public OrderCancelationEvent(Order order, ZonedDateTime createdAt) {
        super(order, createdAt);
    }
}
