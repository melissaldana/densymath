package com.example.densymath;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;


import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Registro extends AppCompatActivity {
    private EditText edtEmail;
    private EditText edtContra;
    private EditText edtFecha;
    private EditText edtNombre;
    private EditText edtUsuario;
    private FloatingActionButton btnIngreso;
    private FirebaseAuth autenticacion;
    private FirebaseFirestore base = FirebaseFirestore.getInstance();
    private ConstraintLayout Contenedor2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        edtEmail = findViewById(R.id.edtEmail);
        edtContra = findViewById(R.id.edtContra);
        edtFecha = findViewById(R.id.edtFecha);
        edtNombre = findViewById(R.id.edtNombre);
        edtUsuario = findViewById(R.id.edtUsuario);
        Contenedor2 = findViewById(R.id.Contenedor2);
        autenticacion = FirebaseAuth.getInstance();
        getSupportActionBar().hide();


    }


    //Funcion para validar el ingreso
    public void procesoIngreso(View view) {
        if (validacion()) {
            String email = edtEmail.getText().toString();
            String password = edtContra.getText().toString();
            IngresoContraseñayCorreo(email, password);
        }
    }

    //Funcion para Crear la cuenta y contraseña exitosamente o no
    private void IngresoContraseñayCorreo(String email, String password) {
        autenticacion.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        FirebaseUser user = autenticacion.getCurrentUser();
                        guardarUsuario(user.getUid());
                    } else {
                        Toast.makeText(this, "Error al crear la cuenta", Toast.LENGTH_SHORT).show();

                    }
                });

    }

    //Funcion guardar datos del usuario
    private void guardarUsuario(String uid) {
        Map<String, Object> data = new HashMap<>();
        data.put("correo", edtEmail.getText().toString());
        data.put("fecha_nacimiento", edtFecha.getText().toString());
        data.put("nombre", edtNombre.getText().toString());
        data.put("nombre_usuario", edtUsuario.getText().toString());

        base.collection("Usuarios")
                .document(uid)
                .set(data)
                .addOnSuccessListener(success -> {
                    Toast.makeText(this, "Cuenta creada exitosamente", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this, MenuPrincipal.class);
                    startActivity(intent);
                    finish();
                })
                .addOnFailureListener(failure -> {
                    Toast.makeText(this, "Error al guardar datos", Toast.LENGTH_SHORT).show();
                    FirebaseAuth.getInstance().signOut();
                });


    }


    //Funcion para la fecha
    public void ClikFecha(View view) {
        showDatePickerDialog();
    }

    private void showDatePickerDialog() {
        DatePickerFragment datePickerFragment = DatePickerFragment.newInstance((datePicker, year, month, day) -> {
            final String dateSelected = day + "/" + (month + 1) + "/" + year;
            edtFecha.setText(dateSelected);
        });
        datePickerFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public static class DatePickerFragment extends DialogFragment {

        private DatePickerDialog.OnDateSetListener listener;

        public static DatePickerFragment newInstance(DatePickerDialog.OnDateSetListener listener) {
            DatePickerFragment fragment = new DatePickerFragment();
            fragment.setListener(listener);
            return fragment;
        }

        public void setListener(DatePickerDialog.OnDateSetListener listener) {
            this.listener = listener;
        }


        @NonNull
        @Override
        public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
            final Calendar calendar = Calendar.getInstance();
            int año = calendar.get(Calendar.YEAR);
            int mes = calendar.get(Calendar.MONTH);
            int dia = calendar.get(Calendar.DAY_OF_MONTH);


            return new DatePickerDialog(getActivity(), listener, año, mes, dia);

        }

    }


    //Funcion para validar campos
    public boolean validacion() {
        if (edtEmail.getText().toString().isEmpty()) {
            Snackbar.make(Contenedor2, "Campo correo electronico vacio", Snackbar.LENGTH_LONG).show();
            return false;
        } else if (edtContra.getText().toString().isEmpty()) {
            Snackbar.make(Contenedor2, "Campo contraseña vacio", Snackbar.LENGTH_LONG).show();
            return false;
        } else if (edtFecha.getText().toString().isEmpty()) {
            Snackbar.make(Contenedor2, "Campo de fecha vacio", Snackbar.LENGTH_LONG).show();
            return false;
        } else if (edtNombre.getText().toString().isEmpty()) {
            Snackbar.make(Contenedor2, "Campo nombre completo vacio", Snackbar.LENGTH_LONG).show();
            return false;
        } else if (edtUsuario.getText().toString().isEmpty()) {
            Snackbar.make(Contenedor2, "Campo nombre usuario vacio", Snackbar.LENGTH_LONG).show();
            return false;
        }
        return true;
    }


}
