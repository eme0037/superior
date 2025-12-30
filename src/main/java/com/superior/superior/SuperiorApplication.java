package com.superior.superior;

import com.superior.superior.employees.Employee;
import com.superior.superior.employees.Owner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.superior.superior.users.LoginSystem;
import com.superior.superior.users.User;
import com.superior.superior.users.Role;

import com.superior.superior.clients.Client;
import com.superior.superior.employees.Employee;
import com.superior.superior.employees.Owner;


import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class SuperiorApplication {

    public static void main(String[] args) {

        // Spring Boot startup always keep this
        SpringApplication.run(SuperiorApplication.class, args);

        // blank testing section
        Client client = new Client(
                1L,
                "client@example.com",
                "1234",
                "Smith Family",
                "123 Main St"
        );

        Employee employee = new Employee(
                2L,
                "alice@gmail.com",
                "abcd",
                "Alice"
        );

        Owner owner = new Owner(
                3L,
                "boss@gmail.com",
                "admin",
                "Boss"
        );

        List<User> users = new ArrayList<>();
        users.add(client);
        users.add(employee);
        users.add(owner);

        LoginSystem loginSystem = new LoginSystem(users);

        loginSystem.login("client@example.com", "1234");
        loginSystem.login("alice@gmail.com", "abcd");
        loginSystem.login("boss@gmail.com", "admin");
    }

}

