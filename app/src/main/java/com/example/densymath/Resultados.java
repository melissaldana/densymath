package com.example.densymath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Resultados extends AppCompatActivity {
    private TextView txtgravedad,txtbarril, txtgalon,txtkilo;

     Intent datos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);
        txtgravedad = findViewById(R.id.txtgravedad);
        txtbarril = findViewById(R.id.txtbarril);
        txtgalon = findViewById(R.id.txtgalon);
        txtkilo = findViewById(R.id.txtkilo);
        getSupportActionBar().hide();


        datos = getIntent();
        double gravedadObtenida = datos.getDoubleExtra("Gravedad",1);
        double barrilesObtenidos = datos.getDoubleExtra("BarrilesTonelada",1);
        double galonesObtenidos = datos.getDoubleExtra("Librasgalon", 1);
        double kilogramosObtenidos = datos.getDoubleExtra("Kilogramo",1);


        DecimalFormat format = new DecimalFormat();
        format.setMaximumFractionDigits(5); //Define 5 decimales.


        txtgravedad.setText(format.format(gravedadObtenida));
        txtbarril.setText(format.format(barrilesObtenidos));
        txtgalon.setText(format.format(galonesObtenidos));
        txtkilo.setText(format.format(kilogramosObtenidos));




    }



}

