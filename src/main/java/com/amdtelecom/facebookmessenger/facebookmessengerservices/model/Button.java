package com.amdtelecom.facebookmessenger.facebookmessengerservices.model;

import com.fasterxml.jackson.annotation.JsonInclude;

public class Button {
    private String type;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String title;
    private String url;

    public Button() {
    }

    @Override
    public String toString() {
        return "Button{" +
                "type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }



    public Button(String type, String title, String url, String fallback_url) {
        this.type = type;
        this.title = title;
        this.url = url;
    }
}
