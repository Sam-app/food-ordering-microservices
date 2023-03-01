package com.food.ordering.system.order.service.domain.entity;

import com.food.ordering.system.domain.entity.AggregateRoot;
import com.food.ordering.system.domain.valueObject.CustomerId;

public class Customer extends AggregateRoot<CustomerId> {

    public Customer(Builder builder) {
        super.setId(builder.customerId);
    }

    public Customer () {

    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private CustomerId customerId;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder customerId(CustomerId val) {
            customerId = val;
            return this;
        }

        public Builder firstName(String val) {
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }
}
