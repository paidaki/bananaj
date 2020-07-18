package com.github.bananaj.model.automation;

public enum DelayDirection {

    AFTER("after"),
    BEFORE("before");

    private String stringRepresentation;

    DelayDirection(String stringRepresentation) {

        setStringRepresentation(stringRepresentation);
    }

    @Override
    public String toString() {

        return stringRepresentation;
    }

    /**
     * @param stringRepresentation Set the stringRepresentation for the enum constant.
     */
    private void setStringRepresentation(String stringRepresentation) {

        this.stringRepresentation = stringRepresentation;
    }
}
