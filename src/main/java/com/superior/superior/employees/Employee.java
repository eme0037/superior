package com.superior.superior.employees;

import com.superior.superior.notes.Note;
import java.util.ArrayList;
import java.util.List;

public class Employee {

    private Long id;
    private String name;
    private List<Note> privateNotes = new ArrayList<>();

    public Employee(Long id, String name) {
        this.id = id;
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

// add notes with: employee.addPrivateNote(new Note("key code 0000", "EmployeeName"));
// includes the timestamp, creator, and text from imported notes.Note above
