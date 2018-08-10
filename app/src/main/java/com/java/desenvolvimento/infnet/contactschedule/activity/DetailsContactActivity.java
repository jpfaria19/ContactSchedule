package com.java.desenvolvimento.infnet.contactschedule.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.java.desenvolvimento.infnet.contactschedule.R;

public class DetailsContactActivity extends AppCompatActivity {

    TextView detailName, detailEmail, detailCity, detailPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_contact);

        detailName = findViewById(R.id.detailName);
        detailEmail = findViewById(R.id.detailEmail);
        detailCity = findViewById(R.id.detailCity);
        detailPhone = findViewById(R.id.detailPhone);



        //NOME
        Bundle extraName = getIntent().getExtras();
        String Name = extraName.getString("name");
        detailName.setText(Name);
        getSupportActionBar().setTitle("");


        //EMAIL
        Bundle extraEmail = getIntent().getExtras();
        String Email = extraEmail.getString("email");
        detailEmail.setText(Email);

        //CIDADE
        Bundle extraCidade = getIntent().getExtras();
        String Cidade = extraCidade.getString("city");
        detailCity.setText(Cidade);

        //TELEFONE
        Bundle extraTelefone = getIntent().getExtras();
        String Telefone = extraTelefone.getString("phone");
        detailPhone.setText(Telefone);
    }

    public void registerNewContact(View view){
        Intent newContact = new Intent(this, RegisterActivity.class);
        startActivity(newContact);
        finish();
    }
}
