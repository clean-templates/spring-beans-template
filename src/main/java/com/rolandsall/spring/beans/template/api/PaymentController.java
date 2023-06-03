package com.rolandsall.spring.beans.template.api;

import com.rolandsall.spring.beans.template.core.Payment;
import com.rolandsall.spring.beans.template.core.payment.IPayService;
import com.rolandsall.spring.beans.template.core.resolver.IPaymentResolver;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pay")
@AllArgsConstructor
public class PaymentController {

    private final IPaymentResolver paymentResolver;

    @PostMapping("/{provider}")
    public ResponseEntity<Void> pay(@RequestBody PaymentRequest request, @PathVariable String provider){
        paymentResolver.checkout(provider, getPayment(request));
        return ResponseEntity.noContent().build();
    }

    private  Payment getPayment(PaymentRequest request) {
        return Payment.builder().owner(request.getOwner()).price(request.getPrice()).build();
    }
}
