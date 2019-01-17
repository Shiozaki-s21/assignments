package com.derrick.park.assignment3_contacts.models;

public class NameBoard extends Contact {

    private String firstChar;

    public NameBoard(String firstChar) {
        this.firstChar = firstChar;
    }

    private NameBoard() {

    }

    public String getFirstChar() {
        return firstChar;
    }
}
