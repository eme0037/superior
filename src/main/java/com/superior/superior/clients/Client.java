package com.superior.superior.clients;

import com.superior.superior.notes.Note;
import com.superior.superior.users.Role;
import com.superior.superior.users.User;

import java.util.ArrayList;
import java.util.List;

public class Client extends User {

    private String name;
    private String address;
    private List<Note> notes = new ArrayList<>();

    // Constructor
    public Client(Long id, String email, String password, String name, String address) {
        super(id, email, password, Role.CLIENT); // call User constructor
        this.name = name;
        this.address = address;
    }

    // Add a note to client
    public void addNote(Note note) {
        notes.add(note);
    }

    // Get all notes
    public List<Note> getNotes() {
        return notes;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}

