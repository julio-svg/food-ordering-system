package com.food.ordering.system.order.event;

import com.food.ordering.system.domain.event.DomaintEvent;
import com.food.ordering.system.order.entity.Order;

import java.time.LocalDateTime;

public abstract class OrderEvent implements DomaintEvent<Order> {

    private final Order order;
    private final LocalDateTime createdAt;

    public OrderEvent(Order order, LocalDateTime createdAt) {
        this.order = order;
        this.createdAt = createdAt;
    }

    public Order getOrder() {
        return order;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
