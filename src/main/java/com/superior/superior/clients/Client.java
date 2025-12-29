package com.superior.superior.clients;

import com.superior.superior.notes.Note;
import java.util.ArrayList;
import java.util.List;


public class Client {

    private Long id;
    private String name;
    private String address;
    private List<Note> notes = new ArrayList<>();

    public Client(Long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public void addNote(Note note) {
        notes.add(note);
    }

    public List<Note> getNotes() {
        return notes;
    }

    public String getName() {
        return name;    
    }

}
