package com.amdtelecom.facebookmessenger.facebookmessengerservices.model;

public class GraphRecipient {
    private String id;

    @Override
    public String toString() {
        return "\"id\"=\""+this.getId()+"\"";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public GraphRecipient() {
    }

    public GraphRecipient(String id) {
        this.id = id;
    }
}
