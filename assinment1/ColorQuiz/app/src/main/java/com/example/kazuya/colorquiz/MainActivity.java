package com.example.kazuya.colorquiz;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mButtonLeft;
    private Button mButtonRight;
    private int mCorrectColorId;
    private TextView mCorrectColorName;
    private TextView mScore;
    private int mCorrentScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateColor();
    }

    public void leftButtonClick(View view) {
        int colorId = ((ColorDrawable)mButtonLeft.getBackground()).getColor();
        showResult(colorId);
    }

    public void rightButtonClick(View view) {
        int colorId = ((ColorDrawable)mButtonRight.getBackground()).getColor();
        showResult(colorId);
    }

    private boolean isCorrect(int colorId){
        if(colorId == mCorrectColorId){
            return true;
        } else {
            return false;
        }
    }

    private void showResult(int colorId) {
        if(isCorrect(colorId)) {
            Toast toast = Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT);
            toast.show();
            incrementScore();
        } else {
            Toast toast = Toast.makeText(this, "fail!", Toast.LENGTH_SHORT);
            toast.show();
            decrementScore();
        }

        generateColor();
    }

    private void incrementScore() {
        mCorrentScore++;
        mScore.setText(String.valueOf(mCorrentScore));
    }

    private void decrementScore() {
        mCorrentScore--;
        mScore.setText(String.valueOf(mCorrentScore));
    }

    private void generateColor() {
        Quiz quiz = QuizFactory.createQuiz();

        mButtonLeft = findViewById(R.id.left_button);
        mButtonLeft.setBackgroundColor(quiz.getLeftColor().getColorId());

        mButtonRight = findViewById(R.id.right_button);
        mButtonRight.setBackgroundColor(quiz.getRightColor().getColorId());

        mCorrectColorId = quiz.getCorrectColorId();

        mCorrectColorName = findViewById(R.id.correct_color_name);
        mCorrectColorName.setText(quiz.getCorrectColorName());

        mScore = findViewById(R.id.score);
        mCorrentScore = Integer.valueOf(mScore.getText().toString());


    }
}
