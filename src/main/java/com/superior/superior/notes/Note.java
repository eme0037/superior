package com.superior.superior.notes;
import java.time.LocalDateTime;

public class Note {

    private String text;
    private LocalDateTime createdAt;
    private String createdBy;

    public Note(String text, String createdBy) {
        this.text = text;
        this.createdBy = createdBy;
        this.createdAt = LocalDateTime.now();
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }
}
