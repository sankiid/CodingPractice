package com.design.elevator;

/**
 * Created by sandeep on 15/2/17.
 */
public class ElevatorEntity {

    private int id;
    private Status status;
    private Button button;
    private int currentFloor;

    public ElevatorEntity(int id, Status status, Button button, int currentFloor) {
        this.id = id;
        this.status = status;
        this.button = button;
        this.currentFloor = currentFloor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }
}
