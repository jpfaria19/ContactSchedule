package com.java.desenvolvimento.infnet.contactschedule.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.java.desenvolvimento.infnet.contactschedule.R;
import com.java.desenvolvimento.infnet.contactschedule.adapter.ContactAdapter;
import com.java.desenvolvimento.infnet.contactschedule.domain.Contact;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ContactAdapter contactAdapter;
    String fileName = "listContacts.txt";

    List<Contact> contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        contactAdapter = new ContactAdapter(contacts);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(contactAdapter);

        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        loadItens();

    }

    public void loadItens() {
        FileInputStream fis = null;
        try {
            fis = openFileInput(fileName);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String line;
            //changeLine = line.toString();

            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            Toast.makeText(this, getFilesDir()+ "/" + sb, Toast.LENGTH_LONG).show();

            //contactAdapter = sb;

            //TODO: SB VAI PARA O ARRAY ADAPTER ->

            fis.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

    }
}

