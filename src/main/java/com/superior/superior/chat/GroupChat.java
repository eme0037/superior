package com.superior.superior.chat;

import com.superior.superior.chat.Message;

import java.util.ArrayList;
import java.util.List;

public class GroupChat {

    private List<Message> messages = new ArrayList<>();

    public void sendMessage(Message message) {
        messages.add(message);
    }

    public void showMessages() {
        System.out.println("=== Company Group Chat ===");
        for (Message msg : messages) {
            System.out.println(msg.getSender() + " [" + msg.getSentAt() + "]: " + msg.getText());
        }
    }
}
