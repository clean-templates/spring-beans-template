package com.rolandsall.payment.service.api.core.resolver;


import com.rolandsall.payment.library.Payment;

public interface IPaymentResolver {

    void checkout(String provider, Payment payment);
}
