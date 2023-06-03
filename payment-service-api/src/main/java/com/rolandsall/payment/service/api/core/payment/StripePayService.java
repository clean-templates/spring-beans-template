package com.rolandsall.payment.service.api.core.payment;

import com.rolandsall.payment.library.IPayService;
import com.rolandsall.payment.library.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StripePayService implements IPayService {

    @Override
    public void checkout(Payment payment) {
        log.info("init stripe payment sdk");
        log.info("payment success");
    }
}
