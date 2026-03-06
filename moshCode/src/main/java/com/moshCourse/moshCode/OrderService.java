package com.moshCourse.moshCode;

import java.util.logging.Logger;

public class OrderService {
    Logger logger = Logger.getLogger(OrderService.class.getName());
    private PaymentService paymentService;

    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void placeOrder(){
        logger.info("Order placed");
        var paymentService = new StripePaymentService();
        paymentService.processPayment(100); 
    }
}
