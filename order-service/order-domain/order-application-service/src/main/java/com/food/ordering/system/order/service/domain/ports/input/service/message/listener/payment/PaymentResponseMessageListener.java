package com.food.ordering.system.order.service.domain.ports.input.service.message.listener.payment;

import com.food.ordering.system.order.service.domain.dto.message.PaymentResponse;

public interface PaymentResponseMessageListener {
    void PaymentCompleted(PaymentResponse paymentResponse);
    void PaymentCancelled(PaymentResponse paymentResponse);

}
