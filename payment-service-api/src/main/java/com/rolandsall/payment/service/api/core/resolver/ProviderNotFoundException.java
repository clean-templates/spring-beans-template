package com.rolandsall.payment.service.api.core.resolver;

public class ProviderNotFoundException extends RuntimeException{
    public ProviderNotFoundException(String provider) {
        super("Provider of type: " + provider +" is not found");

    }
}
