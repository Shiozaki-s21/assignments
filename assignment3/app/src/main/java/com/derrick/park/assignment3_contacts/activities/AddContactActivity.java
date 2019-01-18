package com.derrick.park.assignment3_contacts.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.derrick.park.assignment3_contacts.R;

public class AddContactActivity extends AppCompatActivity {

    private TextView mAddNameText;
    private TextView mAddPhoneText;

    final static public String ADD_USER_NAME = "userName";
    final static public String ADD_USER_PHONE = "userPhone";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        // set TextView
        mAddNameText = findViewById(R.id.addName);
        mAddPhoneText = findViewById(R.id.addPhone);
    }


    public void submitContact(View view) {
        // create Intent
        Intent intent = new Intent();

        // put name and phone number as a extra message
        intent.putExtra(ADD_USER_NAME,mAddNameText.getText().toString());
        intent.putExtra(ADD_USER_PHONE,mAddPhoneText.getText().toString());

        // set intent as a result
        setResult(RESULT_OK,intent);

        // finish this activity
        finish();
    }
}
