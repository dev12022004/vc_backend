package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "transactions")
public class Transaction {

    @Id
    private int id;
    private String transactionId;
    private int amount;
    private String vendor;
    private String status;
    private LocalDateTime time;
    private String type;
    private String paymentMethod;
    private String contactEmail;
    private String billingAddress;
    private String notes;
    private List<Map<String, String>> attachments;

    public Transaction(String transactionId, int amount, String vendor, String status, String type,
            String paymentMethod, String contactEmail, String billingAddress, String notes) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.vendor = vendor;
        this.status = status;
        this.time = LocalDateTime.now();
        this.type = type;
        this.paymentMethod = paymentMethod;
        this.contactEmail = contactEmail;
        this.billingAddress = billingAddress;
        this.notes = notes;
        this.attachments = new ArrayList<Map<String,String>>();
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTransactionId() {
        return transactionId;
    }
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public String getVendor() {
        return vendor;
    }
    public void setVendor(String vendor) {
        this.vendor = vendor;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public LocalDateTime getTime() {
        return time;
    }
    public void setTime(LocalDateTime time) {
        this.time = time;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getPaymentMethod() {
        return paymentMethod;
    }
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    public String getContactEmail() {
        return contactEmail;
    }
    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }
    public String getBillingAddress() {
        return billingAddress;
    }
    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }
    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    public List<Map<String, String>> getAttachments() {
        return attachments;
    }
    public void setAttachments(List<Map<String, String>> attachments) {
        this.attachments = attachments;
    }

    public void setAttachment(String attachment, String url) {
        Map<String, String> mapAttachment = new HashMap<>();
        mapAttachment.put("attachment", attachment);
        mapAttachment.put("url", url);
        this.attachments.add(mapAttachment);
    }
}

/*
 * { 
    id: 1, 
    transactionId: 'TXN001', 
    amount: 500, 
    vendor: 'Amazon', 
    status: 'Completed', 
    time: '2023-12-01 14:30:00',
    type: 'Buyer',
    paymentMethod: 'Credit Card',
    contactEmail: 'vendor1@example.com', 
    billingAddress: '123 Main Street, City, Country',
    notes: 'Payment for services rendered.', 
    attachments: [
      { name: 'Invoice.pdf', url: '/invoices/invoice1.pdf' },
      { name: 'Receipt.jpg', url: '/receipts/receipt1.jpg' }
    ]
  },

 */