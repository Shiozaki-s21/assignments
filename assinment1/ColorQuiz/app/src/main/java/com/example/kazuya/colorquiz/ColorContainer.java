package com.example.kazuya.colorquiz;

/**
 * To contain color id and Color name for showing on View as a Quiz;
 *
 */
public class ColorContainer {
    private int colorId;
    private String colorName;

    public ColorContainer(int colorId, String colorName) {
        this.colorId = colorId;
        this.colorName = colorName;
    }

    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }
}
