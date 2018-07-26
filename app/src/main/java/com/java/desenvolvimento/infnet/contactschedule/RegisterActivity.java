package com.java.desenvolvimento.infnet.contactschedule;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class RegisterActivity extends AppCompatActivity {

    EditText edtName, edtPhone, edtEmail, edtCity;
    Button btnSave, btnClear, btnViewContacts;
    String fileName = "listContacts.txt";
    FileOutputStream outputStream;
    FileInputStream fis;
    BufferedReader reader;

    TextView txtRecoverItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtName = findViewById(R.id.edtName);
        edtPhone = findViewById(R.id.edtPhone);
        edtEmail = findViewById(R.id.edtEmail);
        edtCity = findViewById(R.id.edtCity);

        btnSave = findViewById(R.id.btnSave);
        btnClear = findViewById(R.id.btnClear);
        btnViewContacts = findViewById(R.id.btnViewContacts);

        /*ListView lvItens = findViewById(R.id.lvItens);
        ArrayList<String> line = loadItens();
        ArrayAdapter<String> lines = new ArrayAdapter<String>(this, R.layout.activity_list, line);
        lvItens.setAdapter(lines);*/

        btnViewContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadItens();
            }
        });

        txtRecoverItem = findViewById(R.id.testRecoverItem);
    }

    public void loadItens() {

        try {
            fis = openFileInput(fileName);
             reader = new BufferedReader(new InputStreamReader(new DataInputStream(fis)));

            String line;

            while ((line = reader.readLine()) != null){
                txtRecoverItem.setText(line);
                txtRecoverItem.append("\n");
            }

            fis.close();

        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

    }

    public void clearForm(View view){

        edtName.getText().clear();
        edtPhone.getText().clear();
        edtCity.getText().clear();
        edtEmail.getText().clear();

    }

    public void saveContact(View view){

        try{
            outputStream = openFileOutput(fileName, Context.MODE_APPEND);

            EditText[] ets = {edtName, edtPhone, edtEmail, edtCity};

            for (EditText et : ets) {
                outputStream.write(et.getText().toString().getBytes());
                outputStream.write("\n".getBytes());
            }


            outputStream.close();
            Toast.makeText(RegisterActivity.this, "Contato salvo com sucesso!", Toast.LENGTH_LONG).show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


/*    public void viewAllContacts(View view){
        Intent listIntent = new Intent(RegisterActivity.this, ListActivity.class);
        startActivity(listIntent);
    }*/

}