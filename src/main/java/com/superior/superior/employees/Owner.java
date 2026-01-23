package com.superior.superior.employees;

import com.superior.superior.clients.Client;
import com.superior.superior.notes.Note;
import com.superior.superior.users.User;
import com.superior.superior.users.Role;

public class Owner extends User {

    private String name;

    public Owner(Long id, String email, String password, String name) {
        super(id, email, password, Role.OWNER); // login role
        this.name = name;
    }

    public void viewClientNotes(Client client) {
        System.out.println("Notes for client: " + client.getName());
        for (Note note : client.getNotes()) {
            System.out.println(note.getCreatedBy() + " - " + note.getText() + " at " + note.getCreatedAt());
        }
    }

    public void viewEmployeeNotes(com.superior.superior.employees.Employee employee) {
        System.out.println("Private notes for employee: " + employee.getName());
        for (Note note : employee.getPrivateNotes()) {
            System.out.println(note.getCreatedBy() + " - " + note.getText() + " at " + note.getCreatedAt());
        }
    }

    public String getName() {
        return name;
    }
}