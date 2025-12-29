package com.superior.superior;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.superior.superior.billing.BillingSystem;
import com.superior.superior.billing.Invoice;


@SpringBootApplication
public class SuperiorApplication {

    public static void main(String[] args) {

        // Spring Boot startup always keep this
        SpringApplication.run(SuperiorApplication.class, args);

        // blank testing section
        BillingSystem billingSystem = new BillingSystem();

        Invoice inv1 = new Invoice(1L, "smith fam", 150.00);
        Invoice inv2 = new Invoice(2L, "smith fam", 3453.00);
        billingSystem.createInvoice(inv1);
        billingSystem.createInvoice(inv2);

        billingSystem.payInvoice(1L);

        billingSystem.showInvoicesForClient("smith fam");





    }

}

