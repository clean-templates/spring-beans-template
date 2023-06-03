package com.rolandsall.payment.service.api.config;

import com.rolandsall.my.custom.payement.MyCustomPaymentService;
import com.rolandsall.payment.library.IPayService;
import com.rolandsall.payment.service.api.core.resolver.IPaymentResolver;
import com.rolandsall.payment.service.api.core.resolver.PaymentResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ResolverBean {

    @Bean()
    public IPaymentResolver paymentResolver(List<IPayService> payServiceProviders){
        return new PaymentResolver(payServiceProviders, new MyCustomPaymentService());
    }
}
