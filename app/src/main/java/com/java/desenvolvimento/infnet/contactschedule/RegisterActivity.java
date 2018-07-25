package com.java.desenvolvimento.infnet.contactschedule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    EditText edtName, edtPhone, edtEmail, edtCity;
    Button btnSave, btnClear, btnViewContacts;

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
    }

    public void clearForm(ViewGroup viewGroup){


    }

}