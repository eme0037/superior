package com.superior.superior;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Import your classes
import com.superior.superior.clients.Client;
import com.superior.superior.notes.Note;

@SpringBootApplication
public class SuperiorApplication {

    public static void main(String[] args) {

        // Spring Boot startup always keep this
        SpringApplication.run(SuperiorApplication.class, args);

    }

}

