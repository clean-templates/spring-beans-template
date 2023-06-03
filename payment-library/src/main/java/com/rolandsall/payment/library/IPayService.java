package com.rolandsall.payment.library;

/***
 * Eventually this should a library that provides abstraction
 * that can be published on maven/gradle where you can download the dependency
 * and implement your custom pay service
 */
public interface IPayService {

    void checkout(Payment payment);
}
