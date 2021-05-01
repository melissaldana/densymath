package com.example.densymath;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private EditText edtCorreo;
    private EditText edtContraseña;
    private FloatingActionButton btnIngresar;
    private FirebaseAuth autenticacion;
    private ConstraintLayout Contenedor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtCorreo = findViewById(R.id.edtCorreo);
        edtContraseña = findViewById(R.id.edtContraseña);
        btnIngresar = findViewById(R.id.btnIngresar);
        autenticacion = FirebaseAuth.getInstance();
        Contenedor = findViewById(R.id.Contenedor3);
        btnIngresar.setOnClickListener(View -> Ingresar());
        getSupportActionBar().hide();
    }

    private void Ingresar(){
        if (validacion()) {
        String correo = edtCorreo.getText().toString();
        String contraseña = edtContraseña.getText().toString();
        IngresoCorreoyContraseña(correo,contraseña);
        }
    }

    private void IngresoCorreoyContraseña(String correo, String contraseña){
        autenticacion.signInWithEmailAndPassword(correo,contraseña)
                .addOnCompleteListener(this, task -> {
                    if(task.isSuccessful()){
                        Intent intent = new Intent(this, MenuPrincipal.class);
                        startActivity(intent);
                        finish();
                    }else {
                        Snackbar.make(Contenedor, "La cuenta no existe", Snackbar.LENGTH_LONG)
                                .setAction("Debe crear una cuenta", view -> {
                                    Intent intent = new Intent(this, Registro.class);
                                    startActivity(intent);
                                    finish();
                                }).show();
                    }

                });

    }



    //Funcion para validar campos
    public boolean validacion() {
        if (edtCorreo.getText().toString().isEmpty()) {
            Snackbar.make(Contenedor, "Campo correo electronico vacio", Snackbar.LENGTH_LONG).show();
            return false;
        } else if (edtContraseña.getText().toString().isEmpty()) {
            Snackbar.make(Contenedor, "Campo contraseña vacio", Snackbar.LENGTH_LONG).show();
            return false;
        }
        return true;
    }



    //Funciones para ir cambiando de pestaña

    public void gotoRegistro(View view) {
        startActivity(new Intent(this, Registro.class));
    }



}