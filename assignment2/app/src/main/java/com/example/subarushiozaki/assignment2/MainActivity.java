package com.example.subarushiozaki.assignment2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    private Spinner mSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSpinner = findViewById(R.id.movieSpinner);
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //TODO your code goes here
                //Call function:showMovieInfo(int id)
                //  -> call pic and raw(text) file from res folder by ID
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //
            }
        });
        //Setting images -> ImageView
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.drawable.GodFather);

        // To read row file
        // "GodFather" -> R.raw.GodFather
        int id = getResources().getIdentifier("GodFather", "raw", getPackageName());
        String result = "";

        Scanner in = new Scanner(getResources().openRawResource(R.raw.GodFather));

        while(in.hasNext()) {
            result += in.nextLine();
        }
        in.close();
    }
}
