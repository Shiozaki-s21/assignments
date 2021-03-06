package com.derrick.park.assignment3_contacts.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.derrick.park.assignment3_contacts.R;
import com.derrick.park.assignment3_contacts.models.Contact;
import com.derrick.park.assignment3_contacts.models.NameBoard;

import java.util.ArrayList;

public class ContactListAdapter
        extends RecyclerView.Adapter<ContactListAdapter.ContactViewHolder> {

    private ArrayList<Contact> mContactList;
    private String mCurrentHeadCharacter = "a";

    public ContactListAdapter (ArrayList<Contact> contactArrayList) {
        this.mContactList = contactArrayList;
    }

    @NonNull
    @Override
    public ContactListAdapter.ContactViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mItemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.contactlist_item, viewGroup, false);
        return new ContactViewHolder(mItemView, this);
    }

    class ContactViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener{

        // ViewHolder
        public final TextView mContactName;
        public final TextView mContactPhoneNumber;
        public final TextView mContactHeader;

        public ContactViewHolder(@NonNull View itemView, ContactListAdapter adapter) {
            super(itemView);
            this.mContactName = itemView.findViewById(R.id.contact_name);
            this.mContactPhoneNumber = itemView.findViewById(R.id.contact_phone_number);
            this.mContactHeader = itemView.findViewById(R.id.head_character);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            // Editing Contact
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder contactViewHolder, int i) {
        Contact mCurrent = mContactList.get(i);

        if (mCurrent.getClass().equals(NameBoard.class)) {
            NameBoard nameBoard = (NameBoard) mCurrent;
            contactViewHolder.mContactHeader.setText(nameBoard.getFirstChar());

            contactViewHolder.mContactPhoneNumber.setVisibility(View.GONE);
            contactViewHolder.mContactName.setVisibility(View.GONE);
        } else {
            contactViewHolder.mContactName.setText(mCurrent.getName().toString());
            contactViewHolder.mContactPhoneNumber.setText(mCurrent.getCell());

            contactViewHolder.mContactHeader.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return mContactList.size();
    }
}
