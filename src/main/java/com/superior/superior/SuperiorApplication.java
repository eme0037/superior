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


import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class SuperiorApplication {

    public static void main(String[] args) {

        // Spring Boot startup always keep this
        SpringApplication.run(SuperiorApplication.class, args);

        // blank testing section

        // ---- testing section ----

        // ---- TESTING EMPLOYEE NOTES FLOW ----

// 1. Create client
        Client client = new Client(1L, "client@example.com", "1234", "Smith Family", "123 Main St");
        client.addNote(new Note("House cleaned", "Alice"));

// 2. Create employee
        Employee employee = new Employee(2L, "alice@gmail.com", "abcd", "Alice");

// 3. Create owner
        Owner owner = new Owner(3L, "boss@gmail.com", "admin", "Boss");

// 4. Users list for login system
        List<User> users = new ArrayList<>();
        users.add(client);
        users.add(employee);
        users.add(owner);

// 5. Employees list for owner menu
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);

// 6. Create login system
        LoginSystem loginSystem = new LoginSystem(users);

// ---- LOGIN AS EMPLOYEE ----
        User loggedInUser = loginSystem.login("alice@gmail.com", "abcd");

// Employee adds private notes
        MenuController.showMenu(loggedInUser, employees);

// ---- LOGIN AS OWNER ----
        loggedInUser = loginSystem.login("boss@gmail.com", "admin");

// Owner views employee notes
        MenuController.showMenu(loggedInUser, employees);


    }

}

