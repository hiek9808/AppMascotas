package com.developer.kervin.appmascotas.entidades;


import java.util.Date;

public class Publicacion {
    private int codigo;
    private int codMascota;
    private String titulo;
    private Date fecha;
    private String lugar;
    private Double longitud;
    private Double latitud;
    private String descripcion;

    public Publicacion() {
    }

    public Publicacion(int codigo, int codMascota, String titulo, Date fecha, String lugar, Double longitud, Double latitud, String descripcion) {
        this.codigo = codigo;
        this.codMascota = codMascota;
        this.titulo = titulo;
        this.fecha = fecha;
        this.lugar = lugar;
        this.longitud = longitud;
        this.latitud = latitud;
        this.descripcion = descripcion;
    }


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodMascota() {
        return codMascota;
    }

    public void setCodMascota(int codMascota) {
        this.codMascota = codMascota;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
