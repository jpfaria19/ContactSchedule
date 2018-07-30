package com.java.desenvolvimento.infnet.contactschedule;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class RegisterActivity extends AppCompatActivity {

    EditText edtName, edtPhone, edtEmail, edtCity;
    Button btnSave, btnClear, btnViewContacts;
    String fileName = "listContacts.txt";
    FileOutputStream outputStream;

/*    ListView lvItens = findViewById(R.id.lvItens);
    ArrayList<String> line;
    String changeLine;
    ArrayAdapter<String> lines = new ArrayAdapter<String>(this, R.layout.activity_list, line);*/

    TextView shitTest;

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

        //lvItens.setAdapter(lines);

         shitTest = findViewById(R.id.test);
    }


    public void clearForm(View view) {
        edtName.getText().clear();
        edtPhone.getText().clear();
        edtCity.getText().clear();
        edtEmail.getText().clear();
    }

    public void saveContact(View view) {

        try {
            outputStream = openFileOutput(fileName, Context.MODE_APPEND);

            EditText[] ets = {edtName, edtPhone, edtEmail};

            String separetor = edtCity.getText().toString();
            separetor = separetor + " >";

            for (EditText et : ets) {
                outputStream.write(et.getText().toString().getBytes());
            }
            outputStream.write(separetor.getBytes());
            outputStream.write("\n".getBytes());
            outputStream.close();
            Toast.makeText(RegisterActivity.this, "Contato salvo com sucesso!", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void loadItens() {
        FileInputStream fis = null;
        try {
            fis = openFileInput(fileName);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            //changeLine = line.toString();
            String line;

            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }

            shitTest.setText(sb.toString());

        } catch (java.io.IOException e) {
            e.printStackTrace();
        }finally {
            try {
                assert fis != null;
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void viewAllContacts(View view) {
        Intent listIntent = new Intent(RegisterActivity.this, ListActivity.class);
        loadItens();
        startActivity(listIntent);
    }

}