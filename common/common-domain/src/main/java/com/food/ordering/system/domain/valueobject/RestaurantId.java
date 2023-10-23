package com.food.ordering.system.domain.valueobject;

import com.food.ordering.system.domain.entity.BaseEntity;

import java.util.UUID;

public class RestaurantId extends BaseId<UUID> {
    public RestaurantId(UUID value) {
        super(value);
    }
}
