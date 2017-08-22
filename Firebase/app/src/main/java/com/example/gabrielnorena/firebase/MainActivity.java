package com.example.gabrielnorena.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.gabrielnorena.firebase.Objetos.Coche;
import com.example.gabrielnorena.firebase.Objetos.FirebaseReferences;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class  MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnRegistrarse, btnIngresar;
    EditText txtEmail, txtClave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRegistrarse = (Button) findViewById(R.id.boton_registrarse);
        btnIngresar = (Button) findViewById(R.id.boton_ingresar);
        txtEmail = (EditText) findViewById(R.id.login_email);
        txtClave = (EditText) findViewById(R.id.login_password);

        btnRegistrarse.setOnClickListener(this);
        btnRegistrarse.setOnClickListener(this);



    }


    private void registrar(String email, String clave){
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,clave);
    }

    private void iniciarSesion(String email, String clave){
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email,clave);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.boton_ingresar:
                break;
            case R.id.boton_registrarse:
                break;
        }
    }
}
