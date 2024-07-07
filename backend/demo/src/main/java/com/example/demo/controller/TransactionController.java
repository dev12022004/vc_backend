package com.example.demo.controller;

import com.example.demo.model.Transaction;
import com.example.demo.service.TransactionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/transactions")
@Tag(name = "Transactions", description = "Endpoints for managing transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping
        @Operation(summary = "Get all transactions", description = "Retrieve a list of all transactions")
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a transaction by ID", description = "Retrieve a transaction by its ID")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable String id) {
        Optional<Transaction> transaction = transactionService.getTransactionById(id);

        if (transaction.isPresent()) {
            return ResponseEntity.ok(transaction.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/transactionId/{transactionId}")
    @Operation(summary = "Get a transaction by transaction ID", description = "Retrieve a transaction by its transaction ID")
    public ResponseEntity<Transaction> getTransactionByTransactionId(@PathVariable String transactionId) {
        Optional<Transaction> transaction = transactionService.getTransactionByTransactionId(transactionId);

        if (transaction.isPresent()) {
            return ResponseEntity.ok(transaction.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @Operation(summary = "Create a new transaction", description = "Create a new transaction")
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        return transactionService.createTransaction(transaction);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a transaction", description = "Update an existing transaction by its ID")
    public ResponseEntity<Transaction> updateTransaction(@PathVariable String id, @RequestBody Transaction transactionDetails) {
        Transaction updatedTransaction = transactionService.updateTransaction(id, transactionDetails);

        if (updatedTransaction != null) {
            return ResponseEntity.ok(updatedTransaction);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a transaction", description = "Delete an existing transaction by its ID")
    public ResponseEntity<Void> deleteTransaction(@PathVariable int id) {
        transactionService.deleteTransaction(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/attachments")
    @Operation(summary = "Add an attachment to a transaction", description = "Add an attachment to an existing transaction by its ID")
    public ResponseEntity<Transaction> addAttachment(@PathVariable String id, @RequestParam String attachmentName, @RequestParam String url) {
        Transaction updatedTransaction = transactionService.addAttachment(id, attachmentName, url);

        if (updatedTransaction != null) {
            return ResponseEntity.ok(updatedTransaction);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
