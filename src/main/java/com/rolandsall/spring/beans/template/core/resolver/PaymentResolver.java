package com.rolandsall.spring.beans.template.core.resolver;

import com.rolandsall.spring.beans.template.core.Payment;
import com.rolandsall.spring.beans.template.core.payment.IPayService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PaymentResolver implements IPaymentResolver{


    private List<IPayService> providers;

    @Override
    public void checkout(String provider, Payment payment) {
        IPayService providerService = resolveProvider(provider);
        providerService.checkout(payment);

    }

    private IPayService resolveProvider(String provider) {
        return providers.stream()
                .filter(iPayService -> iPayService.getClass().toString().contains(provider))
                .findFirst()
                .orElseThrow(() -> new ProviderNotFoundException(provider));
    }
}
