package com.rolandsall.payment.service.api.core.payment;


import com.rolandsall.payment.service.api.core.Payment;

public interface IPayService {

    void checkout(Payment payment);
}
