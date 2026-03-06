package com.moshCourse.moshCode;

import java.util.logging.Logger;


public class StripePaymentService implements PaymentService{
    Logger logger = Logger.getLogger(StripePaymentService.class.getName());
    @Override
    public void processPayment(double amount){
        logger.info("Stripe");
        logger.info("Amount "+amount);
    }
}
