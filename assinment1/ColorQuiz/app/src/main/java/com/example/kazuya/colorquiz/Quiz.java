package com.example.kazuya.colorquiz;

import android.graphics.Color;

/**
 * To contain Color classes for showing color
 * and color name as a Correct choose;
 */
public class Quiz {

    private ColorContainer rightColor;
    private ColorContainer leftColor;
    private int correctColorId;
    private String correctColorName;

    public Quiz(ColorContainer rightColor, ColorContainer leftColor, int correctColorId, String correctColorName) {
        this.rightColor = rightColor;
        this.leftColor = leftColor;
        this.correctColorId = correctColorId;
        this.correctColorName = correctColorName;
    }

    public ColorContainer getRightColor() {
        return rightColor;
    }

    public void setRightColor(ColorContainer rightColor) {
        this.rightColor = rightColor;
    }

    public ColorContainer getLeftColor() {
        return leftColor;
    }

    public void setLeftColor(ColorContainer leftColor) {
        this.leftColor = leftColor;
    }

    public int getCorrectColorId() {
        return correctColorId;
    }

    public void setCorrectColorId(int correctColorId) {
        this.correctColorId = correctColorId;
    }

    public String getCorrectColorName() {
        return correctColorName;
    }

    public void setCorrectColorName(String correctColorName) {
        this.correctColorName = correctColorName;
    }
}
