package com.superior.superior;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.superior.superior.clients.Client;
import com.superior.superior.employees.Employee;
import com.superior.superior.employees.Owner;
import com.superior.superior.notes.Note;



@SpringBootApplication
public class SuperiorApplication {

    public static void main(String[] args) {

        // Spring Boot startup always keep this
        SpringApplication.run(SuperiorApplication.class, args);

        // blank testing section
        Client client = new Client(1L, "Smith Family", "123 main str");
        Note clientNote = new Note("hey so the door code is 0000", "Owner");
        client.addNote(clientNote);

        Employee emp = new Employee(1L, "alice");
        Note empNote = new Note("Bring vaccum", "Alice");
        emp.addPrivateNote(empNote);

        Owner owner = new Owner(1L, "Boss");

        owner.viewClientNotes(client);
        owner.viewEmployeeNotes(emp);

    }

}

