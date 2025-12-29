package com.superior.superior.chat;

import java.time.LocalDateTime;

public class Message {

    private String text;
    private String sender;
    private LocalDateTime sentAt;

    public Message(String text, String sender) {
        this.text = text;
        this.sender = sender;
        this.sentAt = LocalDateTime.now();
    }

    public String getText() {
        return text;
    }

    public String getSender() {
        return sender;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }
}
