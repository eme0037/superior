package com.superior.superior.billing;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Invoice {

    private Long id;
    private String clientName;
    private double amount;
    private boolean paid;
    private LocalDateTime createdAt;

    public Invoice (Long id, String clientName, double amount) {
        this.amount = amount;
        this.paid = false;
        this.createdAt = LocalDateTime.now();
        this.id = id;
        this.clientName = clientName;
    }

    public void pay() {
        this.paid = true;
    }

    public boolean isPaid() {
        return paid;
    }

   public double getAmount() {
        return amount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Long getId() {
        return id;
    }

    public String getClientName() {
        return clientName;
    }

    @Override
    public String toString() {
        return "Invoice # " + id + " for " + clientName + ": $" + amount + " | Created at: " + createdAt + " | Paid: " + paid;
    }
}
