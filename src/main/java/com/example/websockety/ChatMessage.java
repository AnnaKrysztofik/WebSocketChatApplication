package com.example.websockety;

import javafx.scene.input.DataFormat;

import java.time.LocalTime;

public class ChatMessage {
    private String value;
    private String user;
    private String userColor;
    private  String time;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


    public ChatMessage(String value) {
        this.value = value;
    }

    public ChatMessage() {
    }
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }



    public String getUserColor() {
        return userColor;
    }

    public void setUserColor(String userColor) {
        this.userColor = userColor;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }




}
