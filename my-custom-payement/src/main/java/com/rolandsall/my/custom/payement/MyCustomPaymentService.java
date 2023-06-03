package com.rolandsall.my.custom.payement;


import com.rolandsall.payment.library.IPayService;
import com.rolandsall.payment.library.Payment;

public class MyCustomPaymentService implements IPayService {

    @Override
    public void checkout(Payment payment) {
        System.out.println("init custom payment sdk");
        System.out.println("payment success");
    }
}
