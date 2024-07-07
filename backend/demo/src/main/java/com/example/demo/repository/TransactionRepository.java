package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Transaction;

public interface TransactionRepository extends MongoRepository<Transaction, String> {
        Optional<Transaction> findByTransactionId(String transactionId);
}
