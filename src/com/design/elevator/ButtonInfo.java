package com.design.elevator;

/**
 * Created by sandeep on 16/2/17.
 */
public class ButtonInfo {
    enum Type {
        INSIDE, OUTSIDE;
    }

    enum Status {
        PRESSED,
        NOT_PRESSED;
    }

    private Type type;
    private Status status = Status.NOT_PRESSED;
    private OutsideButton outsideButton;
    private InsideButton insideButton;
}
