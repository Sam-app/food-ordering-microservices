package com.food.ordering.system.order.service.domain.entity;

import com.food.ordering.system.domain.valueObject.Money;
import com.food.ordering.system.domain.entity.BaseEntity;
import com.food.ordering.system.domain.valueObject.OrderId;
import com.food.ordering.system.order.service.domain.valueObject.OrderItemId;

import java.util.UUID;

public class OrderItem extends BaseEntity<OrderItemId> {
    private OrderId orderId;
    private final Product product;
    private final Integer quantity;
    private final Money price;
    private final Money subTotal;

    private OrderItem(Builder builder) {
        super.setId(builder.orderItemId );
        product = builder.product;
        quantity = builder.quantity;
        price = builder.price;
        subTotal = builder.supTotal;
    }

    public OrderId getOrderId() {
        return orderId;
    }

    public Product getProduct() {
        return product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Money getPrice() {
        return price;
    }

    public Money getSupTotal() {
        return subTotal;
    }

    void initialiseOrderItem(OrderId orderId, OrderItemId orderItemId) {
         this.orderId = orderId;
         super.setId(orderItemId);
    }

    boolean isPriceValid() {
        return price.isGreaterThanZero() &&
                price.equals(product.getPrice()) &&
                price.multiply(quantity).equals(subTotal);
    }

    public static final class Builder {
        private OrderItemId orderItemId;
        private Product product;
        private Integer quantity;
        private Money price;
        private Money supTotal;

        private Builder() {
        }

        public static Builder builder () {
            return new Builder();
        }

        public Builder orderItemId(OrderItemId val) {
            orderItemId = val;
            return this;
        }

        public Builder product(Product val) {
            product = val;
            return this;
        }

        public Builder quantity(Integer val) {
            quantity = val;
            return this;
        }

        public Builder price(Money val) {
            price = val;
            return this;
        }

        public Builder supTotal(Money val) {
            supTotal = val;
            return this;
        }

        public OrderItem build() {
            return new OrderItem(this);
        }
    }
}
