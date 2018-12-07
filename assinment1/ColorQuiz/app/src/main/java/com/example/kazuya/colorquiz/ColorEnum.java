package com.example.kazuya.colorquiz;

public enum ColorEnum {

    /**
     * To show color
     */
    BLACK(0, "BLACK", 0xFF000000),
    DKGRAY(1, "DARKGRAY", 0xFF444444),
    GRAY(2, "GRAY", 0xFF888888),
    LTGRAY(3, "LIGHTGRAY", 0xFFCCCCCC),
    ORANGE(4, "ORANGE", 0xFFFF8C00),
    RED(5, "RED", 0xFFFF0000),
    GREEN(6, "GREEN", 0xFF00FF00),
    BLUE(7, "BLUE", 0xFF0000FF),
    Yellow(8, "YELLOW", 0xFFFFFF00),
    CYAN(9, "CYAN", 0xFF00FFFF),
    MAGENTA(10, "MAGENTA", 0xFFFF00FF);

    private final int id;
    private final String colorName;
    private final int colorNumber;


    ColorEnum(int id, String colorName, int colorNumber) {
        this.id = id;
        this.colorName = colorName;
        this.colorNumber = colorNumber;
    }

    public int getId() {
        return id;
    }

    public String getColorName() {
        return colorName;
    }

    public int getColorNumber() {
        return colorNumber;
    }

    /**
     * get Enum Object from id as a argument
     */
    public static ColorEnum valueOf(int id) {

        for (ColorEnum num : values()) {
            if (num.getId() == id) { // id が一致するものを探す
                return num;
            }
        }

        throw new IllegalArgumentException("no such enum object for the id: " + id);
    }

    public static int length(){
        return ColorEnum.values().length;
    }
}
