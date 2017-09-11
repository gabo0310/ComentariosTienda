package com.example.gabrielnorena.firebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.gabrielnorena.firebase.Objetos.Coche;
import com.example.gabrielnorena.firebase.Objetos.FirebaseReferences;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class  MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnRegistrarse, btnIngresar;
    EditText txtEmail, txtClave;

    FirebaseAuth.AuthStateListener mAuthListener;

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

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(FirebaseAuth firebaseAuth) {
                FirebaseUser usuario = firebaseAuth.getCurrentUser();
                if(usuario != null){
                     Log.i("SESION", "Sesion iniciada con email: "+ usuario.getEmail());
                }else {
                    Log.i("SESION", "Sesion Cerrada");
                }
            }
        };



    }

    //Metodo encargado de crear el usuario en Firebase
    private void registrar(String email, String clave){
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,clave).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Log.i("SESION", "usuario creado correctamente");
                }else {
                    Log.e("SESION", task.getException().getMessage());
                }
            }
        });
    }

    //Metodo encargado de validar los datos de usuario e iniciar sesión
    private void iniciarSesion(String email, String clave){
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email,clave).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Log.i("SESION", "Sesion iniciada");
                } else {
                    Log.e("SESION", task.getException().getMessage());
                }
            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //Caso del boton ingresar que lo lleva al menu
            case R.id.boton_ingresar:
                String emailInicio = txtEmail.getText().toString();
                String claveInicio = txtClave.getText().toString();
                iniciarSesion(emailInicio, claveInicio);
                break;
            //Caso del boton registrarse que lleva a formulario de registro
            case R.id.boton_registrarse:
                String emailRegistro = txtEmail.getText().toString();
                String claveRegistro = txtClave.getText().toString();
                registrar(emailRegistro, claveRegistro);
                Intent usuario = new Intent(MainActivity.this,RegistroUsuario.class);
                startActivity(usuario);
                break;
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        FirebaseAuth.getInstance().addAuthStateListener(mAuthListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mAuthListener != null){
            FirebaseAuth.getInstance().removeAuthStateListener(mAuthListener);
        }
    }
}
