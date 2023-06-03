package com.rolandsall.spring.beans.template.core.payment;

import com.rolandsall.spring.beans.template.core.Payment;

public interface IPayService {

    void checkout(Payment payment);
}
