package com.wy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class FileServiceActivator {
    @Autowired
    PaymentTransactionRepository repo;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public void indexTransaction(Message<PaymentTransaction> message) {
        System.out.println(message.getPayload());
        repo.save(message.getPayload());
    }
}
