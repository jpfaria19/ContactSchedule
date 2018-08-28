package com.java.desenvolvimento.infnet.contactschedule.adapter;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.java.desenvolvimento.infnet.contactschedule.R;
import com.java.desenvolvimento.infnet.contactschedule.activity.DetailsContactActivity;
import com.java.desenvolvimento.infnet.contactschedule.domain.Contact;

import java.text.DateFormat;
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
        cvh.date.setText(DateFormat.getTimeInstance().format(contact.getMoment()));
        cvh.cidade.setText(contact.getCity());

    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        TextView cidade;
        TextView date;

        private ContactViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textName);
            cidade = itemView.findViewById(R.id.textCity);
            date = itemView.findViewById(R.id.textDate);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    Intent detailContact = new Intent(v.getContext(), DetailsContactActivity.class);
                    Contact contact = contacts.get(position);

                    String getName = contact.getName();
                    detailContact.putExtra("name",getName);
                    String getPassword = contact.getPassword();
                    detailContact.putExtra("password", getPassword);
                    String getEmail = contact.getEmail();
                    detailContact.putExtra("email", getEmail);
                    int getPhone = contact.getPhone();
                    detailContact.putExtra("phone", getPhone);
                    int getCellPhone = contact.getCellPhone();
                    detailContact.putExtra("cellphone", getCellPhone);
                    int getCPF = contact.getCPF();
                    detailContact.putExtra("cpf", getCPF);
                    String getCity = contact.getCity();
                    detailContact.putExtra("city", getCity);

                    v.getContext().startActivity(detailContact);
                }
            });
        }
    }
}
