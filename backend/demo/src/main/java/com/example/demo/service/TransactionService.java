package com.example.demo.service;

import com.example.demo.model.Transaction;
import com.example.demo.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Optional<Transaction> getTransactionById(String id) {
        return transactionRepository.findById(id);
    }

    public Optional<Transaction> getTransactionByTransactionId(String transactionId) {
        return transactionRepository.findByTransactionId(transactionId);
    }

    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public Transaction updateTransaction(String id, Transaction transactionDetails) {
        Optional<Transaction> optionalTransaction = transactionRepository.findById(id);

        if (optionalTransaction.isPresent()) {
            Transaction transaction = optionalTransaction.get();
            transaction.setTransactionId(transactionDetails.getTransactionId());
            transaction.setAmount(transactionDetails.getAmount());
            transaction.setVendor(transactionDetails.getVendor());
            transaction.setStatus(transactionDetails.getStatus());
            transaction.setTime(transactionDetails.getTime());
            transaction.setType(transactionDetails.getType());
            transaction.setPaymentMethod(transactionDetails.getPaymentMethod());
            transaction.setContactEmail(transactionDetails.getContactEmail());
            transaction.setBillingAddress(transactionDetails.getBillingAddress());
            transaction.setNotes(transactionDetails.getNotes());
            transaction.setAttachments(transactionDetails.getAttachments());
            return transactionRepository.save(transaction);
        } else {
            return null; // Or throw an exception
        }
    }
 
    public void deleteTransaction(int id) {
       // transactionRepository.deleteById(id);
    }

    public Transaction addAttachment(String id, String attachmentName, String url) {
        Optional<Transaction> optionalTransaction = transactionRepository.findByTransactionId(id);

        if (optionalTransaction.isPresent()) {
            Transaction transaction = optionalTransaction.get();
            transaction.setAttachment(attachmentName, url);
            return transactionRepository.save(transaction);
        } else {
            return null; // Or throw an exception
        }
    }
}
