package com.example.gabrielnorena.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.gabrielnorena.firebase.Objetos.FirebaseReferences;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class  MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseDatabase base_datos = FirebaseDatabase.getInstance();
        DatabaseReference referencia = base_datos.getReference(FirebaseReferences.TUTORIAL_REFERENCE);

        referencia.push().setValue(7);

        ValueEventListener escuchadorEventos = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int valor = dataSnapshot.getValue(Integer.class);
                Log.i("DATOS", valor + "");

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("ERROR", databaseError.getMessage());

            }
        };

        //Con esto se va a firebase a obtener el valor de la base de datos
        referencia.addValueEventListener(escuchadorEventos);
    }
}
