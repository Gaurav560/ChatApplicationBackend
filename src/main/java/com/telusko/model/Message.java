package com.telusko.model;



public class Message {
    public Message(String senderName, String receiverName, String message, Status status) {
        this.senderName = senderName;
        this.receiverName = receiverName;
        this.message = message;

        this.status = status;
    }

    public Message() {
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    private String senderName;
    private String receiverName;
    private String message;
    private Status status;
}
