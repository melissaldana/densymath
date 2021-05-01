package com.example.densymath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity {
    ImageView splash;
    private FirebaseAuth autenticacion;
    private final long Tiempo = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        autenticacion = FirebaseAuth.getInstance();
        getSupportActionBar().hide();

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                FirebaseUser usuario = autenticacion.getCurrentUser();
                if (usuario != null) {
                    Intent intent = new Intent(getApplicationContext(), MenuPrincipal.class);
                    startActivity(intent);
                    finish();
                } else {
                    Intent changeActivity = new Intent(getApplicationContext(),
                            MainActivity.class);
                    startActivity(changeActivity);
                    finish();
                }
            }
        }, Tiempo);
    }
}