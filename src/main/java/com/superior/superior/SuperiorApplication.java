package com.superior.superior;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// put imports under this
import com.superior.superior.clients.Client;
import com.superior.superior.employees.Employee;
import com.superior.superior.employees.Owner;
import com.superior.superior.users.LoginSystem;
import com.superior.superior.users.User;
import com.superior.superior.users.Role;
import com.superior.superior.menu.MenuController;
import com.superior.superior.notes.Note;
import com.superior.superior.billing.Invoice;


import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class SuperiorApplication {

    public static void main(String[] args) {

        // Spring Boot startup always keep this
        SpringApplication.run(SuperiorApplication.class, args);

        // blank testing section
        Client client1 = new Client(
                1L,
                "client@example.com",
                "1234",
                "Smith Family",
                "123 Main St"
        );

        client1.addInvoice(new Invoice(1L, client1.getName(), 150.00));

        Employee employee1 = new Employee(
                2L,
                "alice@gmail.com",
                "abcd",
                "Alice"
        );

        Owner owner1 = new Owner(
                3L,
                "boss@gmail.com",
                "admin",
                "Boss"
        );

        List<User> users = new ArrayList<>();
        users.add(client1);
        users.add(employee1);
        users.add(owner1);

        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);

        List<Client> clients = new ArrayList<>();
        clients.add(client1);

        LoginSystem loginSystem = new LoginSystem(users);

        User loggedInUser = loginSystem.login("client@example.com", "1234");
        MenuController.showMenu(loggedInUser, clients, employees);

        loggedInUser = loginSystem.login("alice@gmail.com", "abcd");
        MenuController.showMenu(loggedInUser, clients, employees);

        loggedInUser = loginSystem.login("boss@gmail.com", "admin");
        MenuController.showMenu(loggedInUser, clients, employees);

        System.out.println("\n Program finished successfully");

    }

}

