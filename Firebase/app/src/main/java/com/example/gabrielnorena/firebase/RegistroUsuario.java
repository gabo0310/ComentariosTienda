package com.example.gabrielnorena.firebase;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.gabrielnorena.firebase.Objetos.FirebaseReferences;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistroUsuario extends AppCompatActivity implements View.OnClickListener{

    Button btnRegistroUsuario;
    String emailUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Intent intentInicioSesion = getIntent();
        Bundle extras = intentInicioSesion.getExtras();

        if(extras != null){
            emailUsuario = extras.getString("EMAIL");
        }

        FirebaseDatabase baseDatos = FirebaseDatabase.getInstance();
        DatabaseReference referencia = baseDatos.getReference(FirebaseReferences.USUARIO_REFERENCE);



        btnRegistroUsuario = (Button) findViewById(R.id.boton_registrarUsuario);


        btnRegistroUsuario.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.boton_registrarUsuario:
                Intent ingresar = new Intent(RegistroUsuario.this,InicioUsuario.class);
                startActivity(ingresar);
                break;
        }

    }
}
