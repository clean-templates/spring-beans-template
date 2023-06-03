package com.rolandsall.spring.beans.template.config;

import com.rolandsall.spring.beans.template.core.payment.IPayService;
import com.rolandsall.spring.beans.template.core.resolver.IPaymentResolver;
import com.rolandsall.spring.beans.template.core.resolver.PaymentResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ResolverBean {

    @Bean()
    public IPaymentResolver paymentResolver(List<IPayService> payServiceProviders){
        return new PaymentResolver(payServiceProviders);
    }
}
