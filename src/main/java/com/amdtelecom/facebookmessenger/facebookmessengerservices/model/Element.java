package com.amdtelecom.facebookmessenger.facebookmessengerservices.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

public class Element {
    private String title;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String subtitle;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String image_url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public Button getDefault_action() {
        return default_action;
    }

    public void setDefault_action(Button default_action) {
        this.default_action = default_action;
    }

    public List<Button> getButtons() {
        return buttons;
    }

    public void setButtons(List<Button> buttons) {
        this.buttons = buttons;
    }

    @Override
    public String toString() {
        return "Element{" +
                "title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", image_url='" + image_url + '\'' +
                ", default_action=" + default_action +
                ", buttons=" + buttons +
                '}';
    }

    public Element() {
    }

    public Element(String title, String subtitle, String image_url, Button default_action, List<Button> buttons) {
        this.title = title;
        this.subtitle = subtitle;
        this.image_url = image_url;
        this.default_action = default_action;
        this.buttons = buttons;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Button default_action;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Button> buttons;//An array of button objects to be appended to the template. A maximum of 1 button is supported.


}
