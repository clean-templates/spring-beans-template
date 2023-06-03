package com.rolandsall.spring.beans.template.core.resolver;

import com.rolandsall.spring.beans.template.core.Payment;

public interface IPaymentResolver {

    void checkout(String provider, Payment payment);
}
