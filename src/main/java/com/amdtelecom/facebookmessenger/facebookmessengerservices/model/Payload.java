package com.amdtelecom.facebookmessenger.facebookmessengerservices.model;

import java.util.List;

public class Payload {
    private String template_type; // Must be "generic"
    private List<Element> elements;//An array containing max of 10 element object that describe the media in the message

    public String getTemplate_type() {
        return template_type;
    }

    public void setTemplate_type(String template_type) {
        this.template_type = template_type;
    }

    public List<Element> getElements() {
        return elements;
    }

    public void setElements(List<Element> elements) {
        this.elements = elements;
    }

    @Override
    public String toString() {
        return "Payload{" +
                "template_type='" + template_type + '\'' +
                ", elements=" + elements +
                '}';
    }

    public Payload() {
    }

    public Payload(String template_type, List<Element> elements) {
        this.template_type = template_type;
        this.elements = elements;
    }
}
