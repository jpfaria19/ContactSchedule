package com.java.desenvolvimento.infnet.contactschedule.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.java.desenvolvimento.infnet.contactschedule.R;
import com.java.desenvolvimento.infnet.contactschedule.domain.Contact;

import java.io.FileOutputStream;

public class RegisterActivity extends AppCompatActivity {

    EditText edtName;

    EditText edtPhone;

    EditText edtEmail;

    EditText edtCity;

    boolean flag = false;

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
    }


    public void clearForm(View view) {
        edtName.getText().clear();
        edtPhone.getText().clear();
        edtCity.getText().clear();
        edtEmail.getText().clear();
    }

    private void validateForm() {

        flag = false;

        if (edtName.getText().toString().equals("")) {
            Toast.makeText(this, "Significa que entrou aqui", Toast.LENGTH_LONG).show();
            flag = true;
        }
        if (edtCity.getText().toString().equals("")) {
            Toast.makeText(this, "Por favor, preencha o campo cidade.", Toast.LENGTH_LONG).show();
            flag = true;
        }
        if (edtEmail.getText().toString().equals("")) {
            Toast.makeText(this, "Por favor, preencha o campo email.", Toast.LENGTH_LONG).show();
            flag = true;
        }
        if (edtPhone.getText().toString().equals("")) {
            Toast.makeText(this, "Por favor, preencha o campo telefone.", Toast.LENGTH_LONG).show();
            flag = true;
        }
    }

    public void saveContact(View view) {
        validateForm();
        if (!flag) {
            try {
                outputStream = openFileOutput(String.valueOf(fileName), Context.MODE_APPEND | Context.MODE_PRIVATE);

                Contact contatin = new Contact(edtName.getText().toString(), edtPhone.getText().toString(), edtEmail.getText().toString(), edtCity.getText().toString());
                contatin.setName(edtName.getText().toString());
                contatin.setPhone(edtPhone.getText().toString());
                contatin.setEmail(edtEmail.getText().toString());
                contatin.setCity(edtCity.getText().toString());


                String separetor = "#";

                outputStream.write(separetor.getBytes());
                outputStream.write("\n".getBytes());
                outputStream.write(contatin.getName().getBytes());
                outputStream.write("\n".getBytes());
                outputStream.write(contatin.getPhone().getBytes());
                outputStream.write("\n".getBytes());
                outputStream.write(contatin.getEmail().getBytes());
                outputStream.write("\n".getBytes());
                outputStream.write(contatin.getCity().getBytes());
                outputStream.write("\n".getBytes());
                outputStream.close();

                Toast.makeText(this, "Registro salvo com sucesso", Toast.LENGTH_LONG).show();


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

   public void viewAllContacts(View view) {
        Intent listIntent = new Intent(this, ListActivity.class);
        startActivity(listIntent);
    }
}