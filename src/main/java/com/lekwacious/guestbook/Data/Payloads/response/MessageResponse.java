package com.lekwacious.guestbook.Data.Payloads.response;

public class MessageResponse {
    private String message;

    public MessageResponse(String message){
        this.message = message;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
