package com.rolandsall.spring.beans.template.core.resolver;

public class ProviderNotFoundException extends RuntimeException{
    public ProviderNotFoundException(String provider) {
        super("Provider of type: " + provider +" is not found");

    }
}
