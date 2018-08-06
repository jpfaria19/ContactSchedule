package com.java.desenvolvimento.infnet.contactschedule.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.Validator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.java.desenvolvimento.infnet.contactschedule.R;
import com.java.desenvolvimento.infnet.contactschedule.domain.Contact;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.Length;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.List;

public class RegisterActivity extends AppCompatActivity implements com.mobsandgeeks.saripaar.Validator.ValidationListener {

    @NotEmpty
    @Length(min = 3, max = 100)
    EditText edtName;

    @NotEmpty
    @Length(min = 9, max = 11)
    EditText edtPhone;

    @NotEmpty
    @Email
    EditText edtEmail;

    @NotEmpty
    EditText edtCity;

    String fileName = "listContacts.txt";
    FileOutputStream outputStream;

    //Contact contact = new Contact();

    private com.mobsandgeeks.saripaar.Validator validator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtName = findViewById(R.id.edtName);
        edtPhone = findViewById(R.id.edtPhone);
        edtEmail = findViewById(R.id.edtEmail);
        edtCity = findViewById(R.id.edtCity);

        validator = new com.mobsandgeeks.saripaar.Validator(this);
        validator.setValidationListener(this);
    }


    public void clearForm(View view) {
        edtName.getText().clear();
        edtPhone.getText().clear();
        edtCity.getText().clear();
        edtEmail.getText().clear();
    }

    public void saveContact(View view) {

        if (validator.isValidating()) {
            try {
                outputStream = openFileOutput(String.valueOf(fileName), Context.MODE_APPEND | Context.MODE_PRIVATE);

                EditText[] ets = {edtName, edtPhone, edtEmail, edtCity};

                String separetor = "#" + "\n";

                outputStream.write(separetor.getBytes());

                for (EditText et : ets) {
                    outputStream.write(et.getText().toString().getBytes());
                    outputStream.write("\n".getBytes());
                }
                outputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            validator.validate();
        }

    }

    public void viewAllContacts(View view) {
        Intent listIntent = new Intent(this, ListActivity.class);
        startActivity(listIntent);
        //finish();
    }

    @Override
    public void onValidationSucceeded() {
        Toast.makeText(RegisterActivity.this, "Contato salvo com sucesso!", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        for (ValidationError validationError : errors) {
            View view = validationError.getView();
            String message = validationError.getCollatedErrorMessage(this);
            if (view instanceof EditText) {
                ((EditText) view).setError(message);
            } else {
                Toast.makeText(this, message, Toast.LENGTH_LONG).show();
            }
        }
    }
}