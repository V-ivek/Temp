package com.amdtelecom.facebookmessenger.facebookmessengerservices.model;

public class Button {
    private String buttonType;
    private String buttonValue;
    private String buttonAction;
    public String getButtonType() {
        return buttonType;
    }
    public void setButtonType(String buttonType) {
        this.buttonType = buttonType;
    }
    public String getButtonValue() {
        return buttonValue;
    }
    public void setButtonValue(String buttonValue) {
        this.buttonValue = buttonValue;
    }
    public String getButtonAction() {
        return buttonAction;
    }
    public void setButtonAction(String buttonAction) {
        this.buttonAction = buttonAction;
    }
    public Button(String buttonType, String buttonValue, String buttonAction) {
        super();
        this.buttonType = buttonType;
        this.buttonValue = buttonValue;
        this.buttonAction = buttonAction;
    }
    public Button() {
        super();
    }
    @Override
    public String toString() {
        return "Button [buttonType=" + buttonType + ", buttonValue=" + buttonValue + ", buttonAction=" + buttonAction
                + "]";
    }
}
