package com.moshCourse.moshCode;

import java.util.logging.Logger;

public class OrderService {
    Logger logger = Logger.getLogger(OrderService.class.getName());
    private PaymentService PaymentService;

    public OrderService(PaymentService PaymentService) {
        this.PaymentService = PaymentService;
    }

    public void placeOrder(){
        logger.info("Order placed");
        PaymentService.processPayment(100); 
    }
}
