package com.superior.superior.users;

import java.util.List;

public class LoginSystem {

    private List<User> users;

    public LoginSystem(List<User> users) {
        this.users = users;
    }

    public User login(String email, String password) {
        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                System.out.println("Login Successful! Welcome " + user.getRole());
                return user;
            }
        }

        System.out.println("Login Failed");
        return null;
    }
}
