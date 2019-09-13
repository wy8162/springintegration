package com.wy;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface PaymentTransactionRepository extends ElasticsearchRepository<PaymentTransaction, String> {
    public PaymentTransaction findByTransNumber(String transactionNumber);
}
