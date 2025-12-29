package com.superior.superior.chat;

import java.time.LocalDateTime;

public class PersonalMessage {

    private String text;
    private String sender;
    private String receiver;
    private LocalDateTime sentAt;

    public PersonalMessage(String text, String sender, String receiver) {
        this.text = text;
        this.sender = sender;
        this.receiver = receiver;
        this.sentAt = LocalDateTime.now();
    }

    public String getText() {
        return text;
    }

    public String getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }
}
