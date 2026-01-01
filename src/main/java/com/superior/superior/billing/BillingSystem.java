package com.superior.superior.billing;

import java.util.ArrayList;
import java.util.List;

public class BillingSystem {

    private List<Invoice> invoices = new ArrayList<>();

    public void createInvoice(Invoice invoice) {
        invoices.add(invoice);
    }

    public void payInvoice(Long id) {
        for (Invoice invoice : invoices) {
            if (invoice.getId().equals(id)) {
                invoice.isPaid();
            }
        }
    }

    public void showInvoicesForClient(String clientName) {
        System.out.println("=== Invoices for " + clientName + " ===");
        for (Invoice invoice : invoices) {
            if (invoice.getClientName().equals(clientName)) {
                System.out.println(invoice);
            }
        }
    }
}
