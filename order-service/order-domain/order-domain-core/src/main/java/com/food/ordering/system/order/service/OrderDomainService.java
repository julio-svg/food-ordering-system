package com.food.ordering.system.order.service;

import com.food.ordering.system.order.entity.Order;
import com.food.ordering.system.order.entity.Restaurant;
import com.food.ordering.system.order.event.OrderCancelationEvent;
import com.food.ordering.system.order.event.OrderCreatedEvent;
import com.food.ordering.system.order.event.OrderPaidEvent;

import java.util.List;

public interface OrderDomainService {

    OrderCreatedEvent validateAndInitiateOrder(Order order, Restaurant restaurant);

    OrderPaidEvent payOrder(Order order);

    void approveOrder(Order order);

    OrderCancelationEvent cancelOrderPayment(Order order, List<String> failureMessages);

    void cancelOrder(Order order, List<String> failureMessages);
}
