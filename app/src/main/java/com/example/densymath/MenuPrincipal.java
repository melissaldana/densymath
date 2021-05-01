package com.example.densymath;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;

import java.text.DecimalFormat;

public class MenuPrincipal extends AppCompatActivity {
    private Button btnCalcular;
    private EditText txtapi;
    CircleMenu circleMenu;
    ConstraintLayout constraintLayout;
    private final long SCREEN_DELAY = 300;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        txtapi = findViewById(R.id.txtapi);
        btnCalcular = findViewById(R.id.btnCalcular);
        circleMenu = findViewById(R.id.cicle_menu);
        constraintLayout = findViewById(R.id.Contenedor3);
        getSupportActionBar().hide();


        btnCalcular.setOnClickListener(view -> calculoDensidad());



        circleMenu.setMainMenu(Color.parseColor("#F1CA04"), R.drawable.ic_baseline_add_24, R.drawable.ic_baseline_add_24);
        circleMenu.addSubMenu(Color.parseColor("#F1CA04"), R.drawable.ic_baseline_close_24);
        circleMenu.addSubMenu(Color.parseColor("#F1CA04"), R.drawable.ic_baseline_person);
        circleMenu.addSubMenu(Color.parseColor("#F1CA04"), R.drawable.ic_lista);
        circleMenu.setOnMenuSelectedListener(new OnMenuSelectedListener() {
            @Override
            public void onMenuSelected(int index) {
                switch (index) {
                    case 0:
                        Toast.makeText(MenuPrincipal.this, "Cerrando sesión", Toast.LENGTH_SHORT).show();
                        constraintLayout.setBackgroundColor(Color.parseColor("#ecfffb"));
                        CerrarSesion();
                        break;
                    case 1:
                        Toast.makeText(MenuPrincipal.this, "Perfil", Toast.LENGTH_SHORT).show();
                        constraintLayout.setBackgroundColor(Color.parseColor("#96f7d2"));
                        perfil();
                        break;
                    case 2:
                        Toast.makeText(MenuPrincipal.this, "Listado API", Toast.LENGTH_SHORT).show();
                        constraintLayout.setBackgroundColor(Color.parseColor("#96f7d2"));
                        listado();
                        break;

                }
            }
        });


    }



 //Funcion para el listado
 public void listado(){
     Intent intent = new Intent(this, Listado_API.class);
     startActivity(intent);
 }




    //Funcion para ir al perfil
    public void perfil(){
        Intent intent = new Intent(this, Perfil.class);
        startActivity(intent);
    }



    //Funcion para cerrar la sesion en la aplicacion
    public void CerrarSesion(){
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }



    //Funcion para validar el campo vacio
    private boolean campoVacio(EditText editText) {
        if (editText.getText().toString().trim().length() > 0)
            return false;
        return true;
    }


    //Funcion para realizar calculos
     public void calculoDensidad(){

         String gravedad= "141.5";
         double barrilesxTonelada = 0;
         double librasxGalon = 0;
         double kilograxM = 0;
         double inicioAPI = 0;
         String gravedadE= "131.5";
         String barriles = "6.28981077";
         String galon = "2204.6226";
         if (!campoVacio(txtapi)) {
             String n = txtapi.getText().toString();
             double gravedadES=Double.parseDouble(gravedad);
             double gravedadES2=Double.parseDouble(gravedadE);
             double gravedadES3=Double.parseDouble(barriles);
             double gravedadES4=Double.parseDouble(galon);
             double API=Double.parseDouble(n);

             //Obtenemos la gravedad especifica
             inicioAPI = (gravedadES/(API+gravedadES2));


             //Obtenemos los barriles x tonelada metrica
             barrilesxTonelada = (gravedadES3/inicioAPI);

             //Obtenemos las libras x galon
             librasxGalon = ((gravedadES4/barrilesxTonelada)/42);

             //Obtenemos los Kilogramosxm3
             kilograxM = ((1000*gravedadES3)/librasxGalon);





         } else{
             Toast.makeText(this, "Esta vacio, ingrese un API", Toast.LENGTH_SHORT).show();

         }

         Intent intent = new Intent(this, Resultados.class);
         intent.putExtra("Gravedad", inicioAPI);
         intent.putExtra("BarrilesTonelada", barrilesxTonelada);
         intent.putExtra("Librasgalon", librasxGalon);
         intent.putExtra("Kilogramo", kilograxM);
         startActivity(intent);

     }



}