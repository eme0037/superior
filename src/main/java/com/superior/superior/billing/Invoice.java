package com.superior.superior.billing;

import java.time.LocalDateTime;

public class Invoice {

    private Long id;
    private String clientName;
    private double amount;
    private LocalDateTime createdAt;
    private boolean paid;

    public Invoice(Long id, String clientName, double amount) {
        this.id = id;
        this.clientName = clientName;
        this.amount = amount;
        this.createdAt = LocalDateTime.now();
        this.paid = false;
    }

    public Long getId() {
        return id;
    }

    public void markAsPaid() {
        this.paid = true;
    }

    public boolean isPaid() {
        return paid;
    }

    public String getClientName() {
        return clientName;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "Invoice # " + id + " for " + clientName + ": $" + amount + " | Created at: " + createdAt + " | Paid: " + paid;
    }
}
