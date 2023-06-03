package com.rolandsall.payment.service.api.core.resolver;

import com.rolandsall.my.custom.payement.MyCustomPaymentService;
import com.rolandsall.payment.library.IPayService;
import com.rolandsall.payment.library.Payment;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PaymentResolver implements IPaymentResolver{


    private List<IPayService> providers;
    private MyCustomPaymentService myCustomPaymentService;

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
