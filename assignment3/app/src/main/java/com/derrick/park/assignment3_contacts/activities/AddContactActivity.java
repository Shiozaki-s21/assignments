package com.derrick.park.assignment3_contacts.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.derrick.park.assignment3_contacts.R;

public class AddContactActivity extends AppCompatActivity {

    private TextView mAddNameText;
    private TextView mAddPhoneText;
    private Button mSubmitButton;

    final static public String ADD_USER_NAME = "userName";
    final static public String ADD_USER_PHONE = "userPhone";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        // set TextView
        mAddNameText = findViewById(R.id.addName);
        mAddPhoneText = findViewById(R.id.addPhone);
        mSubmitButton = findViewById(R.id.addButton);

        mAddNameText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // nothing to do
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // nothing to do
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (isValid()) {
                    mSubmitButton.setEnabled(true);
                } else {
                    mSubmitButton.setEnabled(false);
                }
            }
        });

        mAddPhoneText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //nothing to do
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //nothing to do
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (isValid()) {
                    mSubmitButton.setEnabled(true);
                } else {
                    mSubmitButton.setEnabled(false);
                }
            }
        });
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


    private boolean isValid() {
        boolean isValid = true;

        if(!mAddNameText.getText().toString().isEmpty() && mAddNameText.getText().toString().matches(".+ .+")) {
            //name is valid
        } else {
            //name is invalid
            isValid = false;
        }

        if(mAddPhoneText.getText().toString().length() == 10) {
            // phone is valid
        } else {
            // phone is invalid
            isValid =false;
        }

        return isValid;
    }

}
