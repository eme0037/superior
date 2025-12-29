package com.superior.superior;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.superior.superior.chat.PersonalChat;
import com.superior.superior.chat.PersonalMessage;

@SpringBootApplication
public class SuperiorApplication {

    public static void main(String[] args) {

        // Spring Boot startup always keep this
        SpringApplication.run(SuperiorApplication.class, args);

        // blank testing section
        PersonalChat personalChat = new PersonalChat();

        personalChat.sendMessage(new PersonalMessage("Hey", "alice", "smith fam"));
        personalChat.sendMessage(new PersonalMessage("thanks", "smith fam", "alice"));

        personalChat.showMessageBetween("alice", "smith fam");




    }

}

