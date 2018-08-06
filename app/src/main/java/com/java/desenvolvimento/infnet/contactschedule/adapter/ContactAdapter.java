package com.java.desenvolvimento.infnet.contactschedule.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.java.desenvolvimento.infnet.contactschedule.R;
import com.java.desenvolvimento.infnet.contactschedule.domain.Contact;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter {

    List<Contact> contacts;

    public ContactAdapter(List<Contact> contacts){
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View card = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_card, parent,false);
        return new ContactViewHolder(card);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Contact contact = contacts.get(position);

        ContactViewHolder cvh = (ContactViewHolder) holder;
        cvh.name.setText(contact.getName());
        cvh.cidade.setText(contact.getCity());
        cvh.date.setText(DateFormat.getTimeInstance().format(contact.getMoment()));

    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        TextView cidade;
        TextView date;

        public ContactViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textName);
            cidade = itemView.findViewById(R.id.textCity);
            date = itemView.findViewById(R.id.textDate);
        }
    }
}
