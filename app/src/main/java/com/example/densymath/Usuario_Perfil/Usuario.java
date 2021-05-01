package com.example.densymath.Usuario_Perfil;

public class Usuario {
    private String nombre;
    private String username;
    private String email;

    public Usuario() {
    }

    public Usuario(String nombre, String username, String email) {
        this.nombre = nombre;
        this.username = username;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}



