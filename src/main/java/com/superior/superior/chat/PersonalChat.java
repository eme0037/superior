package com.superior.superior.chat;

import java.util.ArrayList;
import java.util.List;

public class PersonalChat {

    private List<PersonalMessage> messages = new ArrayList<>();

    public void sendMessage(PersonalMessage message) {
        messages.add(message);
    }

    public void showMessageBetween(String user1, String user2) {
        System.out.println("=== Personal Messages Between " + user1 + " and " + user2 + " ===");
        for (PersonalMessage msg : messages) {
            if((msg.getSender().equals(user1) && msg.getReceiver().equals(user2)) ||
                    (msg.getSender().equals(user2) && msg.getReceiver().equals(user1))) {
                System.out.println(msg.getSender() + " [" + msg.getSentAt() + "] " + msg.getText());
            }
        }
    }
}
