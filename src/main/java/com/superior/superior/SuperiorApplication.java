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

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class SuperiorApplication {

    public static void main(String[] args) {

        // Spring Boot startup always keep this
        SpringApplication.run(SuperiorApplication.class, args);

        // blank testing section

        List<User> users = new ArrayList<>();
        users.add(new Client(1L, "client@example.com", "1234", "Smith Family", "123 Main St"));
        users.add(new Employee(2L, "alice@gmail.com", "abcd", "Alice"));
        users.add(new Owner(3L, "boss@gmail.com", "admin", "Boss"));

        LoginSystem loginSystem = new LoginSystem(users); // 🔑 MUST create first

        User loggedInUser;

        loggedInUser = loginSystem.login("client@example.com", "1234");
        MenuController.showMenu(loggedInUser);

        loggedInUser = loginSystem.login("alice@gmail.com", "abcd");
        MenuController.showMenu(loggedInUser);

        loggedInUser = loginSystem.login("boss@gmail.com", "admin");
        MenuController.showMenu(loggedInUser);
    }

}

