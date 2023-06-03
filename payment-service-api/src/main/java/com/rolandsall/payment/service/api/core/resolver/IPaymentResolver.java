package com.rolandsall.payment.service.api.core.resolver;


import com.rolandsall.payment.service.api.core.Payment;

public interface IPaymentResolver {

    void checkout(String provider, Payment payment);
}
