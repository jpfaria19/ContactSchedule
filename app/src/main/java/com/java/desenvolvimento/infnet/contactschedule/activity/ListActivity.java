package com.java.desenvolvimento.infnet.contactschedule.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.java.desenvolvimento.infnet.contactschedule.R;
import com.java.desenvolvimento.infnet.contactschedule.adapter.ContactAdapter;
import com.java.desenvolvimento.infnet.contactschedule.domain.Contact;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ContactAdapter contactAdapter;
    String fileName = "listContacts.txt";

    List<Contact> contacts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        contactAdapter = new ContactAdapter(contacts);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(contactAdapter);

        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

   /* @Override
    protected void onStart() {
        super.onStart();

        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        FileInputStream fis = null;
                        try {
                            fis = openFileInput(fileName);
                            InputStreamReader isr = new InputStreamReader(fis);
                            BufferedReader br = new BufferedReader(isr);
                            String line = br.readLine();
                            while (line != null) {
                                if (line.equals("#")) {
                                    String name = br.readLine();
                                    String phone = br.readLine();
                                    String email = br.readLine();
                                    String cidade = br.readLine();
                                    Contact contact = new Contact(name, phone, email, cidade);
                                    contacts.add(contact);
                                }
                                line = br.readLine();
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
    }*/


    public void registerNewContact(View view) {
        Intent newContact = new Intent(this, RegisterActivity.class);
        startActivity(newContact);
        finish();
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("JÁ ESTÁ SAINDO ?? :/ ")
                .setMessage("Você tem certeza que quer sair do app? Se quiser criar um novo contato é só clicar no + que fica aqui em baixo.")
                .setPositiveButton("Sim", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .setNegativeButton("Não", null)
                .show();
    }

}

