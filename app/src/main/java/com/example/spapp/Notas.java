package com.example.spapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

public class Notas {
    SharedPreferences notas;
    SharedPreferences.Editor editor;
    Context context;
    private static final String PREFERENCIAS_FILE = "Notas";

    public Notas(Context context) {
        this.context = context;
        notas = this.context.getSharedPreferences(PREFERENCIAS_FILE, Context.MODE_PRIVATE);
        editor = notas.edit();
    }

    public String recuperaNota() {
        if (this.notas.contains("nota")) {
            String nota = notas.getString("nota", "");
            Toast.makeText(context, nota, Toast.LENGTH_LONG).show();
            return nota;
        } else {
            return "";
        }
    }

    public void salvarNota(String nota) {
        SharedPreferences.Editor editor = notas.edit();
        editor.putString("nota", nota);
        editor.apply();
    }
}
