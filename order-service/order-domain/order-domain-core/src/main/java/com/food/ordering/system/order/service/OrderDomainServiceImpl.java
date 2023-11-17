package com.food.ordering.system.order.service;

import com.food.ordering.system.order.entity.Order;
import com.food.ordering.system.order.entity.Product;
import com.food.ordering.system.order.entity.Restaurant;
import com.food.ordering.system.order.event.OrderCancelationEvent;
import com.food.ordering.system.order.event.OrderCreatedEvent;
import com.food.ordering.system.order.event.OrderPaidEvent;
import com.food.ordering.system.order.excetion.OrderDomainException;
import lombok.extern.slf4j.Slf4j;


import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@Slf4j
public class OrderDomainServiceImpl implements OrderDomainService {

    private static final String UTC = "UTC";
    @Override
    public OrderCreatedEvent validateAndInitiateOrder(Order order, Restaurant restaurant) {
        validatRestaurant(restaurant);
        // se pasa el objeto restauran, porque tiene la lista de productos que ofrece y con estos,
        // constrastamos que los productos de orden tiene el precio correcto
        setOrderProductInformation(order, restaurant);
        order.validateOrder();
        order.initializate();
        log.info("Order with id: {} is initiated", order.getId().getValue());
        return new OrderCreatedEvent(order, ZonedDateTime.now(ZoneId.of(UTC)));
    }

    private void setOrderProductInformation(Order order, Restaurant restaurant) {
        order.getItems().forEach(orderItem -> restaurant.getProducts().forEach(restaurantProduct -> {
            Product currentProduct = orderItem.getProduct();
            if (currentProduct.equals(restaurantProduct)) {
                currentProduct.updateWithConfirmedNameAndPrice(restaurantProduct.getName(),
                        restaurantProduct.getPrice());
            }
        }));
    }

    private void validatRestaurant(Restaurant restaurant) {
        if (!restaurant.isActive()) {
            throw new OrderDomainException("Restaurant with id " + restaurant.getId().getValue() + " is currently not active!");
        }
    }

    @Override
    public OrderPaidEvent payOrder(Order order) {
        order.pay();
        log.info("Order with id {} is paid ", order.getId().getValue());
        return new OrderPaidEvent(order, ZonedDateTime.now(ZoneId.of(UTC)));
    }

    @Override
    public void approveOrder(Order order) {
        order.approve();
        log.info("Order with id {} is approved ",  order.getId().getValue());

    }

    @Override
    public OrderCancelationEvent cancelOrderPayment(Order order, List<String> failureMessages) {
        order.initCancel(failureMessages);
        log.info("Order payment is cancelling for order id: {}", order.getId().getValue());
        return new OrderCancelationEvent(order, ZonedDateTime.now(ZoneId.of(UTC)));
    }

    @Override
    public void cancelOrder(Order order, List<String> failureMessages) {
        order.cancel(failureMessages);
        log.info("Order with id: {} is cancelled", order.getId().getValue());

    }
}
