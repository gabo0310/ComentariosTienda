package com.example.gabrielnorena.firebase;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.gabrielnorena.firebase.Objetos.FirebaseReferences;
import com.example.gabrielnorena.firebase.Objetos.Usuario;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RegistroUsuario extends AppCompatActivity implements View.OnClickListener{

    Button btnRegistroUsuario;
    EditText edtCedula, edtNombre, edtApellido, edtCelular;
    String emailUsuario;
    DatabaseReference referenciaUsuario;

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


        edtCedula = (EditText) findViewById(R.id.edtCedula);
        edtNombre = (EditText) findViewById(R.id.edtNombre);
        edtApellido = (EditText) findViewById(R.id.edtApellido);
        edtCelular = (EditText) findViewById(R.id.edtCelular);

        btnRegistroUsuario = (Button) findViewById(R.id.boton_registrarUsuario);


        btnRegistroUsuario.setOnClickListener(this);

        referenciaUsuario = baseDatos.getReference(FirebaseReferences.TUTORIAL_REFERENCE);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.boton_registrarUsuario:

                Usuario usuario = new Usuario();
                usuario.setEmail(emailUsuario);
                usuario.setCedula(Integer.parseInt(edtCedula.getText().toString()));
                usuario.setNombre(edtNombre.getText().toString());
                usuario.setApellido(edtApellido.getText().toString());
                usuario.setCelular(edtCelular.getText().toString());

                referenciaUsuario.child(FirebaseReferences.USUARIO_REFERENCE).push().setValue(usuario);

                Intent ingresar = new Intent(RegistroUsuario.this,InicioUsuario.class);
                startActivity(ingresar);
                break;
        }

    }
}
