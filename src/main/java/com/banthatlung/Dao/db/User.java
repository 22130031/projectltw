package com.banthatlung.Dao.db;

public class User {
    private String username;
    private String pass;
    private String name;
    private int role;

    public User(String username, String pass, String name, int role) {
        this.username = username;
        this.pass = pass;
        this.name = name;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
