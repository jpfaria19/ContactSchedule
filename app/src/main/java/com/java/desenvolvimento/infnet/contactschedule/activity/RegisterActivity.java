package com.java.desenvolvimento.infnet.contactschedule.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.java.desenvolvimento.infnet.contactschedule.DAO.ConfigureFirebase;
import com.java.desenvolvimento.infnet.contactschedule.R;
import com.java.desenvolvimento.infnet.contactschedule.domain.Contact;

public class RegisterActivity extends AppCompatActivity {

    private EditText edtName;
    private EditText edtPassword;
    private EditText edtEmail;
    private EditText edtPhone;
    private EditText edtCellPhone;
    private EditText edtCPF;
    private EditText edtCity;
    private Contact contact = new Contact();
    //private FirebaseDatabase database;
    private DatabaseReference reference;
    boolean flag = false;

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

        //Persistindo dados offline
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);

        reference = FirebaseDatabase.getInstance().getReference(".info/connected");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                boolean connected = snapshot.getValue(Boolean.class);
                if (connected) {
                    Toast.makeText(RegisterActivity.this, "CONNECTED", Toast.LENGTH_LONG).show();
                    System.out.println("connected");
                } else {
                    Toast.makeText(RegisterActivity.this, "NOT CONNECTED", Toast.LENGTH_LONG).show();
                    System.out.println("not connected");
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(RegisterActivity.this, "Listener was cancelled", Toast.LENGTH_LONG).show();
                System.err.println("Listener was cancelled");
            }
        });

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

    //Validação exclusiva para e-mail
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
            contact.setName(edtName.getText().toString());
            contact.setPassword(edtPassword.getText().toString());
            contact.setEmail(edtEmail.getText().toString());
            contact.setPhone(Double.parseDouble(edtPhone.getText().toString()));
            contact.setCellPhone(Double.parseDouble(edtCellPhone.getText().toString()));
            contact.setCPF(Double.parseDouble(edtCPF.getText().toString()));
            contact.setCity(edtCity.getText().toString());

            insertingContact(contact);

            //Manter os dados armazenados sincronizados com o Firebase Realtime.
            reference = FirebaseDatabase.getInstance().getReference("scores");
            reference.keepSynced(true);

            clearForm(view);
        }
    }

    private boolean insertingContact(Contact contact) {
        try {
            reference = ConfigureFirebase.getFirebase().child("contatos");
            reference.push().setValue(contact);
            Toast.makeText(this, "Usuário cadastrado com sucesso.", Toast.LENGTH_LONG).show();
            return true;
        } catch (Exception e) {
            Toast.makeText(this, "Erro ao cadastrar usuário.", Toast.LENGTH_LONG).show();
            e.printStackTrace();
            return false;
        }
    }

    public void viewAllContacts(View view) {
        Toast.makeText(this, "Sua lista de contatos está vazia", Toast.LENGTH_LONG).show();
        Intent listIntent = new Intent(this, ListActivity.class);
        startActivity(listIntent);
    }
}