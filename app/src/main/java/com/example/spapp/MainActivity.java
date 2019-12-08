package com.example.spapp;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Notas notas;
    EditText notaEd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notas =new Notas(getApplicationContext());
        notaEd = findViewById(R.id.notaEd);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notas.salvarNota(notaEd.getText().toString());
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        notaEd.setText(notas.recuperaNota());
    }

    @Override
    protected void onPause() {
        super.onPause();
        notas.salvarNota(notaEd.getText().toString());
    }

}
