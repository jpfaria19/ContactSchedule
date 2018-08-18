package com.java.desenvolvimento.infnet.contactschedule.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.java.desenvolvimento.infnet.contactschedule.R;

public class DetailsContactActivity extends AppCompatActivity {

    TextView detailName, detailPassword, detailEmail, detailPhone, detailCellPhone, detailCpf, detailCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_contact);

        detailName = findViewById(R.id.detailName);
        detailPassword = findViewById(R.id.detailPassword);
        detailEmail = findViewById(R.id.detailEmail);
        detailPhone = findViewById(R.id.detailPhone);
        detailCellPhone = findViewById(R.id.detailCellPhone);
        detailCpf = findViewById(R.id.detailCpf);
        detailCity = findViewById(R.id.detailCity);

        Bundle extra = getIntent().getExtras();

        //NOME
        String Name = extra.getString("name");
        detailName.setText(Name);
        getSupportActionBar().setTitle("");

        //SENHA
        String Senha = extra.getString("password");
        detailPassword.setText(Senha);


        //EMAIL
        String Email = extra.getString("email");
        detailEmail.setText(Email);

        //TELEFONE
        int TelefoneInt = extra.getInt("phone");
        String Telefone = String.valueOf(TelefoneInt);
        detailPhone.setText(Telefone);

        //CELULAR
        int CelularInt = extra.getInt("cellphone");
        String Celular = String.valueOf(CelularInt);
        detailCellPhone.setText(Celular);

        //CPF
        int CPFInt = extra.getInt("cpf");
        String CPF = String.valueOf(CPFInt);
        detailCpf.setText(CPF);

        //CIDADE
        String Cidade = extra.getString("city");
        detailCity.setText(Cidade);

    }

    public void registerNewContact(View view){
        Intent newContact = new Intent(this, RegisterActivity.class);
        startActivity(newContact);
        finish();
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("JÁ ESTÁ SAINDO ?? :/ ")
                .setMessage("Você tem certeza que quer sair do app? Se quiser criar um novo contato é só clicar no + que fica aqui em baixo.")
                .setPositiveButton("Sim", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .setNegativeButton("Não", null)
                .show();
    }

}
