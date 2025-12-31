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
        // ---- testing section ----

// 1️⃣ Create client
        Client client = new Client(
                1L,
                "client@example.com",
                "1234",
                "Smith Family",
                "123 Main St"
        );

// 2️⃣ Add notes to client
        client.addNote(new Note("House cleaned", "Alice"));
        client.addNote(new Note("Dog was friendly", "Alice"));

// 3️⃣ Create employee
        Employee employee = new Employee(
                2L,
                "alice@gmail.com",
                "abcd",
                "Alice"
        );

// 4️⃣ Create owner
        Owner owner = new Owner(
                3L,
                "boss@gmail.com",
                "admin",
                "Boss"
        );

// 5️⃣ Store users for login system
        List<User> users = new ArrayList<>();
        users.add(client);
        users.add(employee);
        users.add(owner);

// 6️⃣ Store employees for owner menu
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);

// 7️⃣ Create login system
        LoginSystem loginSystem = new LoginSystem(users);

// 8️⃣ Login and show menus
        User loggedInUser;

        loggedInUser = loginSystem.login("client@example.com", "1234");
        MenuController.showMenu(loggedInUser, employees);

        loggedInUser = loginSystem.login("alice@gmail.com", "abcd");
        MenuController.showMenu(loggedInUser, employees);

        loggedInUser = loginSystem.login("boss@gmail.com", "admin");
        MenuController.showMenu(loggedInUser, employees);



    }

}

