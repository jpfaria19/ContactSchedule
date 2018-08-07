package com.java.desenvolvimento.infnet.contactschedule.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.java.desenvolvimento.infnet.contactschedule.R;
import com.java.desenvolvimento.infnet.contactschedule.adapter.ContactAdapter;
import com.java.desenvolvimento.infnet.contactschedule.domain.Contact;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ContactAdapter contactAdapter;
    String fileName = "listContacts.txt";

    List<Contact> contacts = new ArrayList<>();

    TextView eptTxt;
    boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        eptTxt = findViewById(R.id.emptyList);

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
                    @Override
                    public void run() {
                        FileInputStream fis = null;
                        flag = false;
                        try {
                            fis = openFileInput(fileName);
                            InputStreamReader isr = new InputStreamReader(fis);
                            BufferedReader br = new BufferedReader(isr);
                            String line = br.readLine();

                            if (fileName.isEmpty()) {
                                eptTxt.setText("A lista está vazia");
                                eptTxt.getVisibility();
                            } else {
                                flag = true;
                                while (line != null) {
                                    if (line.equals("#")) {
                                        String name = br.readLine();
                                        String phone = br.readLine();
                                        String email = br.readLine();
                                        String cidade = br.readLine();
                                        //String date = br.readLine();
                                        Contact contact = new Contact(name, phone, email, cidade);
                                        contacts.add(contact);
                                    }
                                    line = br.readLine();
                                }
                            }

                        } catch (final FileNotFoundException fileNotFound) {
                            fileNotFound.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
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
}

