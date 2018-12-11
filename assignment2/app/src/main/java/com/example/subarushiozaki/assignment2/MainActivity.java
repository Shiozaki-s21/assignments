package com.example.subarushiozaki.assignment2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    private Spinner mSpinner;
    private ImageView mPoster;
    private TextView mExplain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSpinner = findViewById(R.id.movieSpinner);
        mPoster = findViewById(R.id.posterView);
        mExplain = findViewById(R.id.explain);

        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String title = (String)mSpinner.getSelectedItem();
                title = title.toLowerCase().replace(" ", "_");
                setText(title);
                setPicture(title);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // nothing to do
            }
        });
    }

    private void setText(String title){
        String result = "";

        int id = getResources().getIdentifier(title, "raw", getPackageName());
        Scanner in = new Scanner(getResources().openRawResource(id));

        while (in.hasNext()) {
            result += in.nextLine();
        }
        in.close();

        mExplain.setText(result);
    }

    private void setPicture(String title){
        int id = getResources().getIdentifier(title, "drawable", getPackageName());
        mPoster.setImageResource(id);
    }
}
