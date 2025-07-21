package com.mvc.mvcmusica.DTO;

public class AuthResponse {
    private String token;
    private String name;
    private String email;
    private String rol;

    public AuthResponse(String token, String name, String email, String rol) {
        this.token = token;
        this.name = name;
        this.email = email;
        this.rol = rol;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
