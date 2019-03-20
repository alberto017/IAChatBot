package com.example.sanchez.iachatbot;

public class UserModelo {

    private String user, message;
    private int image;

    public UserModelo() {
    }

    public UserModelo(String user, String message, int image) {
        this.user = user;
        this.message = message;
        this.image = image;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
