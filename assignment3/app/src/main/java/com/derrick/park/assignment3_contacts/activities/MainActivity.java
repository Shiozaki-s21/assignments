package com.derrick.park.assignment3_contacts.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.derrick.park.assignment3_contacts.R;
import com.derrick.park.assignment3_contacts.adapter.ContactListAdapter;
import com.derrick.park.assignment3_contacts.models.Contact;
import com.derrick.park.assignment3_contacts.models.ContactList;
import com.derrick.park.assignment3_contacts.models.NameBoard;
import com.derrick.park.assignment3_contacts.network.ContactClient;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Contact> mContactList;
    private RecyclerView mRecyclerView;
    private ContactListAdapter mAdapter;
    public static final int REQUEST_CODE = 1;


    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Call<ContactList> call = ContactClient.getContacts(10);

        // prepare for organize contact data
        call.enqueue(new Callback<ContactList>() {
            @Override
            public void onResponse(Call<ContactList> call, Response<ContactList> response) {
                if (response.isSuccessful()) {
                    mContactList = response.body().getContactList();
                    Collections.sort(mContactList, new Comparator<Contact>() {
                        @Override
                        public int compare(Contact o1, Contact o2) {
                            return o1.getName().toString().compareToIgnoreCase(o2.getName().toString());
                        }
                    });

                    // insert NameBoard
                    insertNameBoard();
                    mRecyclerView = findViewById(R.id.recyclerView);
                    mAdapter = new ContactListAdapter(mContactList);
                    mRecyclerView.setAdapter(mAdapter);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                }
            }

            @Override
            public void onFailure(Call<ContactList> call, Throwable t) {
                // Error Handling
                Log.d(TAG, t.getMessage());
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    private void insertNameBoard() {
        ArrayList<Contact> tmpList = new ArrayList<>();
        String firstString = "";

        for (Contact con: mContactList) {
            if(firstString.compareToIgnoreCase(con.getName().toString().substring(0,1)) < 0) {
                firstString = con.getName().toString().substring(0,1).toUpperCase();
                tmpList.add(new NameBoard(firstString));
                firstString = firstString.toLowerCase();
            }
            tmpList.add(con);
        }
        mContactList = tmpList;
    }

    public void addContact(MenuItem item) {
        Intent intent = new Intent(this, AddContactActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE) {

            if (resultCode == RESULT_OK) {
                // get name and phone number from AddContentActivity
                String addUserName = data.getStringExtra(AddContactActivity.ADD_USER_NAME);
                String addUserPhone = data.getStringExtra(AddContactActivity.ADD_USER_PHONE);

                Contact con = new Contact();
                con.setName(addUserName);
                con.setCell(addUserPhone);

                addNewUserToCurrentContactList(con);
            }
        }
    }

    private void addNewUserToCurrentContactList(Contact contact) {
        mContactList.add(contact);
        ArrayList<Contact> tmp = new ArrayList<>();
        for (Contact con: mContactList) {
            if(!con.getClass().equals(NameBoard.class)) {
                tmp.add(con);
            }
        }

        mContactList = tmp;

        Collections.sort(mContactList, new Comparator<Contact>() {
            @Override
            public int compare(Contact o1, Contact o2) {
            return o1.getName().toString().compareToIgnoreCase(o2.getName().toString());
            }
        });

        // insert NameBoard
        insertNameBoard();
        mRecyclerView = findViewById(R.id.recyclerView);
        mAdapter = new ContactListAdapter(mContactList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }
}
