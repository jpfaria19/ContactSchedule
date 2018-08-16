package com.java.desenvolvimento.infnet.contactschedule.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.flags.IFlagProvider;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.java.desenvolvimento.infnet.contactschedule.DAO.ConfigureFirebase;
import com.java.desenvolvimento.infnet.contactschedule.R;
import com.java.desenvolvimento.infnet.contactschedule.domain.Contact;

public class RegisterActivity extends AppCompatActivity {

    private EditText edtName, edtPassword, edtEmail, edtPhone, edtCellPhone, edtCPF, edtCity;

    boolean flag = false;

    private Contact contato;

    private FirebaseDatabase database;
    private DatabaseReference reference;

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

    private boolean isEmail(EditText text) {
        CharSequence chrEmail = text.getText().toString();
        return (!TextUtils.isEmpty(chrEmail) && Patterns.EMAIL_ADDRESS.matcher(chrEmail).matches());
    }

    private void validateForm() {

        flag = false;

        if (edtName.getText().toString().isEmpty()) {
            edtName.setError("O campo nome não pode ficar em branco.");
            flag = true;
        }
        if (edtPassword.getText().toString().isEmpty()) {
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

        //TODO: IMPLEMENT DATABASE FIREBASE FOR SAVE CONTACT
    }

    public void viewAllContacts(View view) {
        Toast.makeText(this, "Sua lista de contatos está vazia", Toast.LENGTH_LONG).show();
        Intent listIntent = new Intent(this, ListActivity.class);
        startActivity(listIntent);
    }
}