package com.food.ordering.system.order.event;

import com.food.ordering.system.domain.event.DomaintEvent;
import com.food.ordering.system.order.entity.Order;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public abstract class OrderEvent implements DomaintEvent<Order> {

    private final Order order;
    private final ZonedDateTime createdAt;

    public OrderEvent(Order order, ZonedDateTime createdAt) {
        this.order = order;
        this.createdAt = createdAt;
    }

    public Order getOrder() {
        return order;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }
}
