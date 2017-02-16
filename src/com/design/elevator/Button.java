package com.design.elevator;

/**
 * Created by sandeep on 15/2/17.
 */
public class Button {

    private int floor;
    private ButtonStatus buttonStatus;
    private ButtonType buttonType;

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public ButtonStatus getButtonStatus() {
        return buttonStatus;
    }

    public void setButtonStatus(ButtonStatus buttonStatus) {
        this.buttonStatus = buttonStatus;
    }

    public ButtonType getButtonType() {
        return buttonType;
    }

    public void setButtonType(ButtonType buttonType) {
        this.buttonType = buttonType;
    }
}
