package com.java.desenvolvimento.infnet.contactschedule.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.java.desenvolvimento.infnet.contactschedule.R;
import com.java.desenvolvimento.infnet.contactschedule.adapter.ContactAdapter;
import com.java.desenvolvimento.infnet.contactschedule.domain.Contact;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ContactAdapter contactAdapter;
    List<Contact> contacts = new ArrayList<>();

    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        database = FirebaseDatabase.getInstance();

        contactAdapter = new ContactAdapter(contacts);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(contactAdapter);

        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    @Override
    protected void onStart() {
        super.onStart();

        new Thread(
                new Runnable() {
                    public static final String TAG = "";

                    @Override
                    public void run() {

                        try {
                            reference = database.getReference("contatos");
                            reference.addChildEventListener(new ChildEventListener() {
                                @Override
                                public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                                    Contact contact = dataSnapshot.getValue(Contact.class);

                                    //Add no ArrayList
                                    contacts.add(contact);

                                    //Add List no Adapter/Recyclerview
                                    recyclerView.setAdapter(contactAdapter);
                                }

                                @Override
                                public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                                }

                                @Override
                                public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                                }

                                @Override
                                public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                }
                            });

                        } catch (DatabaseException e) {
                            Log.d(TAG, "Erro: " + e);
                        }

                        recyclerView.post(
                            new Runnable() {
                                @Override
                                public void run() {
                                    ContactAdapter adapter = new ContactAdapter(contacts);
                                    recyclerView.setAdapter(adapter);
                                    adapter.notifyDataSetChanged();
                                }
                            }
                        );
                    }
                }
        ).start();
    }

    public void registerNewContact(View view) {
        Intent newContact = new Intent(ListActivity.this, RegisterActivity.class);
        startActivity(newContact);
        finish();
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("JÁ ESTÁ SAINDO ?? :/ ")
                .setMessage("Você tem certeza que quer sair do app? Se quiser criar um novo contato é só clicar no + que fica aqui em baixo.")
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .setNegativeButton("Não", null)
                .show();
    }

}

