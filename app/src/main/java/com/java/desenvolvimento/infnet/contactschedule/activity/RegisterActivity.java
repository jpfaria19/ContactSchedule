package com.java.desenvolvimento.infnet.contactschedule.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.java.desenvolvimento.infnet.contactschedule.R;
import com.java.desenvolvimento.infnet.contactschedule.domain.Contact;

import java.io.File;
import java.io.FileOutputStream;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

    EditText edtName, edtPassword, edtEmail, edtPhone, edtCellPhone, edtCPF, edtCity;

    boolean flag = false;

    int passwordLength = 6;

    //String fileName = "listContacts.txt";
    //FileOutputStream outputStream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtName = findViewById(R.id.edtName);
        edtPassword = findViewById(R.id.edtPassword);
        edtEmail = findViewById(R.id.edtEmail);
        edtPhone = findViewById(R.id.edtPhone);
        edtCellPhone = findViewById(R.id.edtCellPhone);
        edtCPF = findViewById(R.id.edtCPF);
        edtCity = findViewById(R.id.edtCity);
    }


    public void clearForm(View view) {
        edtName.getText().clear();
        edtPassword.getText().clear();
        edtEmail.getText().clear();
        edtPhone.getText().clear();
        edtCellPhone.getText().clear();
        edtCPF.getText().clear();
        edtCity.getText().clear();
    }

    private boolean isEmail(EditText text){
        CharSequence chrEmail = text.getText().toString();
        return (!TextUtils.isEmpty(chrEmail) && Patterns.EMAIL_ADDRESS.matcher(chrEmail).matches());
    }

    private void validateForm() {

        flag = false;

        if (edtName.getText().toString().isEmpty()) {
            edtName.setError("O campo nome não pode ficar em branco.");
            flag = true;
        }
        if (edtPassword.getText().toString().isEmpty()){
            edtPassword.setError("O campo senha não pode ficar em branco.");
            flag = true;
        }
        if (isEmail(edtEmail) == false) {
            edtEmail.setError("Insira um e-mail válido. (XXX@XXXX.com");
            flag = true;
        }
        if (edtPhone.getText().toString().isEmpty()) {
            edtPhone.setError("O campo telefone não pode ficar em branco.");
            flag = true;
        }
        if (edtCellPhone.getText().toString().isEmpty()) {
            edtCellPhone.setError("O campo celular não pode ficar em branco.");
            flag = true;
        }
        if (edtCPF.getText().toString().isEmpty()) {
            edtCPF.setError("O campo CPF não pode ficar em branco.");
            flag = true;
        }
        if (edtCity.getText().toString().isEmpty()) {
            edtCity.setError("O campo cidade não pode ficar em branco");
            flag = true;
        }
    }

    public void saveContact(View view) {
        validateForm();
        if (!flag) {
            Toast.makeText(this, "SALVEI", Toast.LENGTH_LONG).show();
        }
    /*        try {
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
        }*/
    }

    public void viewAllContacts(View view) {

        Toast.makeText(this, "Sua lista de contatos está vazia", Toast.LENGTH_LONG).show();
        Intent listIntent = new Intent(this, ListActivity.class);
        startActivity(listIntent);

       /*flag = false;
       File f = getFileStreamPath(fileName);
       if (f.length() == 0) {
       }else{
           flag = true;
       }*/
    }
}