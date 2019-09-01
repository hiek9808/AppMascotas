package com.developer.kervin.appmascotas.entidades;

import android.os.Parcel;

public class Mascota{
    private int codigo;
    private String nombre;
    private String raza;
    private int edad;
    private String size;
    private int estado;
    private String imagen;
    private int codigoUsuario;

    public Mascota() {
    }

    public Mascota(int codigo, String nombre, String raza, int edad, String size, int estado, String imagen, int codigoUsuario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.size = size;
        this.estado = estado;
        this.imagen = imagen;
        this.codigoUsuario = codigoUsuario;
    }

    protected Mascota(Parcel in) {
        codigo = in.readInt();
        nombre = in.readString();
        raza = in.readString();
        edad = in.readInt();
        size = in.readString();
        estado = in.readInt();
        imagen = in.readString();
        codigoUsuario = in.readInt();
    }


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(int codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }


}
