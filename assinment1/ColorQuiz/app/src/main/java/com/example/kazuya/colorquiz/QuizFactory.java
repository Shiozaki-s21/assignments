package com.example.kazuya.colorquiz;


public class QuizFactory {



    /**
     * To create Quiz Class
     *
     * @return Quiz Class
     */
    public static Quiz createQuiz(){

        final int enumLength = ColorEnum.length() - 1;
        int rightColorNumber = (int)(Math.random() * enumLength);
        int leftColorNumber;
        String correctColorName = "";
        int correctColorId;

        do {

            leftColorNumber = (int)(Math.random() * enumLength);
        } while(rightColorNumber == leftColorNumber);

        ColorEnum rightColorEnum = ColorEnum.valueOf(rightColorNumber);
        ColorContainer rightColor = new ColorContainer(rightColorEnum.getColorNumber(), rightColorEnum.getColorName());

        ColorEnum leftColorEnum = ColorEnum.valueOf(leftColorNumber);
        ColorContainer leftColor = new ColorContainer(leftColorEnum.getColorNumber(), leftColorEnum.getColorName());

        int decider = (int)(Math.random() * enumLength);

        if(Math.random() < 0.5) {
            correctColorName = rightColorEnum.getColorName();
            correctColorId = rightColorEnum.getColorNumber();
        } else {
            correctColorName = leftColorEnum.getColorName();
            correctColorId = leftColorEnum.getColorNumber();
        }

        return new Quiz(rightColor, leftColor, correctColorId, correctColorName);
    }
}
