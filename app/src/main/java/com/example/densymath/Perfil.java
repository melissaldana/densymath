package com.example.densymath;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.densymath.Usuario_Perfil.Usuario;
import com.fxn.pix.Options;
import com.fxn.pix.Pix;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Perfil extends AppCompatActivity {
    private FirebaseAuth autenticacion;
    private FirebaseUser user;
    private FirebaseFirestore base;
    private TextView txtNombre, txtCorreo, txtUsuario;
    private Usuario usuario;
    private ImageView imgProfile;
    private final int REQUEST_CODE_IMAGE_PICKER = 5050;
    private FirebaseStorage storage = FirebaseStorage.getInstance();
    private StorageReference storageRef = storage.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        autenticacion = FirebaseAuth.getInstance();
        imgProfile = findViewById(R.id.imgProfile);
        base = FirebaseFirestore.getInstance();
        txtNombre = findViewById(R.id.txtNombre);
        txtCorreo = findViewById(R.id.txtCorreo);
        txtUsuario = findViewById(R.id.txtUsuario);
        usuario = new Usuario();
        getSupportActionBar().hide();


        imgProfile.setOnClickListener(view -> {
            Options options = Options.init()
                    .setRequestCode(REQUEST_CODE_IMAGE_PICKER)
                    .setCount(1)
                    .setFrontfacing(false)
                    .setScreenOrientation(Options.SCREEN_ORIENTATION_PORTRAIT)
                    .setPath("/densy/images/profile-pictures");

            Pix.start(this, options);
                });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE_IMAGE_PICKER){
            ArrayList<String> pictures = data.getStringArrayListExtra(Pix.IMAGE_RESULTS);
            File imgFile = new File(pictures.get(0));


            Uri uri = Uri.fromFile(imgFile);
            StorageReference profileReference = storageRef.child("profile-pictures/").child(uri.getLastPathSegment());
            UploadTask uploadTask = profileReference.putFile(uri);

            uploadTask.addOnFailureListener(failure ->
                    Toast.makeText(this, "Error al subir la imagen", Toast.LENGTH_SHORT).show()
            ).addOnSuccessListener(onSucces ->{
                Toast.makeText(this, "Cargada....", Toast.LENGTH_SHORT).show();
                Map<String, Object> dataF = new HashMap<>();
                dataF.put("profile-image", "profile-pictures/" + uri.getLastPathSegment());

                base.collection("Usuario")
                        .document(user.getUid())
                        .update(dataF)
                        .addOnSuccessListener(aVoid ->  {
                            loadImage(uri.getLastPathSegment());
                        })
                        .addOnFailureListener(onFailed -> {
                            Toast.makeText(this, "Error al guardar la imagen", Toast.LENGTH_SHORT).show();
                        });

            });
        }
    }


    private void loadImage(String uri){
        storageRef.child("profile-pictures/"+uri).getDownloadUrl()
                .addOnSuccessListener(url -> {
                    Glide.with(this).load(url).into(imgProfile);
                }).addOnFailureListener(failure -> {
            Toast.makeText(this, "Error al descargar la imagen", Toast.LENGTH_SHORT).show();
        });

    }


    @Override
    protected void onStart() {
        super.onStart();
        user = autenticacion.getCurrentUser();
        DocumentReference reference = base.collection("Usuarios").document(user.getUid());
        reference.get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                DocumentSnapshot documentSnapshot = task.getResult();
                if (documentSnapshot.exists()) {
                    usuario.setNombre(documentSnapshot.getString("nombre"));
                    usuario.setEmail(documentSnapshot.getString("correo"));
                    usuario.setUsername(documentSnapshot.getString("nombre_usuario"));

                    txtUsuario.setText(usuario.getUsername());
                    txtCorreo.setText(usuario.getEmail());
                    txtNombre.setText(usuario.getNombre());

                }
            } else {
                Toast.makeText(this, "No se han podido cargar los datos de su perfil", Toast.LENGTH_SHORT).show();
            }
        });


    }
}