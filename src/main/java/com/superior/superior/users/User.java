package com.superior.superior.users;

// login page
public class User {
    private Long id;
    private String email;
    private String password;
    private Role role;

    public User(Long id, String email, String password, Role role) { // constructor

        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;

    }

    // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }





}
