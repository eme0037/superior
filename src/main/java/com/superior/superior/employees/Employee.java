package com.superior.superior.employees;

import com.superior.superior.users.Role;
import com.superior.superior.users.User;
import com.superior.superior.notes.Note;

import java.util.ArrayList;
import java.util.List;

public class Employee extends User {

    private String name;
    private List<Note> privateNotes = new ArrayList<>();

    public Employee(Long id, String email, String password, String name) {
        super(id, email, password, Role.EMPLOYEE);
        this.name = name;
    }

    public void addPrivateNote(Note note) {
        privateNotes.add(note);
    }

    public List<Note> getPrivateNotes() {
        return privateNotes;
    }

    public String getName() {
        return name;
    }
}
