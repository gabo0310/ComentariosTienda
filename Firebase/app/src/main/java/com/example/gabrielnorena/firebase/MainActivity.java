package com.example.gabrielnorena.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.gabrielnorena.firebase.Objetos.Coche;
import com.example.gabrielnorena.firebase.Objetos.FirebaseReferences;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class  MainActivity extends AppCompatActivity {

    Button boton_coche;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton_coche = (Button) findViewById(R.id.boton_coche);

        FirebaseDatabase base_datos = FirebaseDatabase.getInstance();
        final DatabaseReference tutorialRef = base_datos.getReference(FirebaseReferences.TUTORIAL_REFERENCE);

        boton_coche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Coche coche = new Coche("Ford", "Gabriel", 5, 4);
                tutorialRef.child(FirebaseReferences.COCHE_REFERENCE).push().setValue(coche);
            }
        });



    }
}
