package com.moshCourse.moshCode;

import java.util.logging.Logger;

public class PayPalPaymentService implements PaymentService {
    Logger logger = Logger.getLogger(PayPalPaymentService.class.getName());

    @Override
    public void processPayment(double amount) {
        // Implementation for processing payment via PayPal
        logger.info("Paypal");
        logger.info("Processing payment of $" + amount + " via PayPal.");
        
    }
}