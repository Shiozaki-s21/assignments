package com.derrick.park.assignment3_contacts.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;

import com.derrick.park.assignment3_contacts.R;
import com.derrick.park.assignment3_contacts.adapter.ContactListAdapter;
import com.derrick.park.assignment3_contacts.models.Contact;
import com.derrick.park.assignment3_contacts.models.ContactList;
import com.derrick.park.assignment3_contacts.network.ContactClient;
import com.derrick.park.assignment3_contacts.network.RandomUserService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Contact> mContactList;
    private RecyclerView mRecyclerView;
    private ContactListAdapter mAdapter;

    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Call<ContactList> call = ContactClient.getContacts(10);

        call.enqueue(new Callback<ContactList>() {
            @Override
            public void onResponse(Call<ContactList> call, Response<ContactList> response) {
                if (response.isSuccessful()) {
                     mContactList.addAll(response.body().getContactList());
                     for(Contact contact: mContactList) {
                         Log.d(TAG, "onResponse: " + mContactList.size());
                         Log.d(TAG, "onResponse: " + contact);
                     }
                }
            }

            @Override
            public void onFailure(Call<ContactList> call, Throwable t) {
                // Error Handling
                Log.d(TAG, t.getMessage());
            }
        });

        mRecyclerView = findViewById(R.id.recyclerView);
        mAdapter = new ContactListAdapter(this, mContactList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
}
