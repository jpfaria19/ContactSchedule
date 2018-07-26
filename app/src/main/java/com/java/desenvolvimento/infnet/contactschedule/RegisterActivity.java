package com.java.desenvolvimento.infnet.contactschedule;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;

public class RegisterActivity extends AppCompatActivity {

    EditText edtName, edtPhone, edtEmail, edtCity;
    Button btnSave, btnClear, btnViewContacts;
    String fileName = "listContacts.txt";
    FileOutputStream outputStream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtName = findViewById(R.id.edtName);
        edtPhone = findViewById(R.id.edtPhone);
        edtEmail = findViewById(R.id.edtEmail);
        edtCity = findViewById(R.id.edtCity);

        btnSave = findViewById(R.id.btnSave);t status
        btnClear = findViewById(R.id.btnClear);
        btnViewContacts = findViewById(R.id.btnViewContacts);
    }

    public void clearForm(View view){

        edtName.getText().clear();
        edtPhone.getText().clear();
        edtCity.getText().clear();
        edtEmail.getText().clear();

    }

    public void saveContact(View view){

        try{
            outputStream = openFileOutput(fileName, Context.MODE_PRIVATE);
            outputStream.write(edtName.getText().toString().getBytes());
            outputStream.write(edtPhone.getText().toString().getBytes());
            outputStream.write(edtEmail.getText().toString().getBytes());
            outputStream.write(edtCity.getText().toString().getBytes());
            outputStream.close();
            Toast.makeText(RegisterActivity.this, "Contato salvo com sucesso!", Toast.LENGTH_LONG).show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void viewAllContacts(View view){
        Intent listIntent = new Intent(RegisterActivity.this, ListActivity.class);
        startActivity(listIntent);
    }

}