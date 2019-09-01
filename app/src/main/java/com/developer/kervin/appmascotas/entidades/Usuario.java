package com.developer.kervin.appmascotas.entidades;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Usuario implements Parcelable {

    private int codigo;
    private String nombre;
    private String apellido;
    private String correo;
    private String password;
    private String fechaNac;

    public Usuario() {
    }

    public Usuario(int codigo, String nombre, String apellido, String correo, String password, String fechaNac) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.password = password;
        this.fechaNac = fechaNac;
    }

    protected Usuario(Parcel in) {
        codigo = in.readInt();
        nombre = in.readString();
        apellido = in.readString();
        correo = in.readString();
        password = in.readString();
        fechaNac = in.readString();
    }

    public static final Creator<Usuario> CREATOR = new Creator<Usuario>() {
        @Override
        public Usuario createFromParcel(Parcel in) {
            return new Usuario(in);
        }

        @Override
        public Usuario[] newArray(int size) {
            return new Usuario[size];
        }
    };

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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(codigo);
        dest.writeString(nombre);
        dest.writeString(apellido);
        dest.writeString(correo);
        dest.writeString(password);
        dest.writeString(fechaNac);
    }
}
