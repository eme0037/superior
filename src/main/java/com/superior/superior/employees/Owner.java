package com.superior.superior.employees;

import com.superior.superior.clients.Client;
import com.superior.superior.notes.Note;
import java.util.List;

public class Owner {

    private Long id;
    private String name;

    public Owner(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // view of all client notes
    public void viewClientNotes(Client client) {
        System.out.println("Notes for client: " + client.getName());
        for (Note note : client.getNotes()) {
            System.out.println(note.getCreatedBy() + " - " + note.getText() + " at " + note.getCreatedAt());
        }
    }

    // view of all employee private notes
    public void viewEmployeeNotes(Employee employee) {
        System.out.println("Private notes for employee: " + employee.getName());
        for (Note note : employee.getPrivateNotes()) {
            System.out.println(note.getCreatedBy() + " - " + note.getText() + " at " + note.getCreatedAt());
        }
    }
}
