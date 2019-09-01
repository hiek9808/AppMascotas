package com.developer.kervin.appmascotas.entidades;

import java.util.Date;

public class Busqueda {

    private int codigo;
    private int codMascota;
    private String titulo;
    private Date fecha;
    private boolean recompensa;
    private int cantRecompensa;
    private String lugar;
    private Double longitud;
    private Double latitud;
    private String descripcion;

    public Busqueda() {
    }

    public Busqueda(int codigo, int codMascota, String titulo, Date fecha, boolean recompensa, int cantRecompensa, String lugar, Double longitud, Double latitud, String descripcion) {
        this.codigo = codigo;
        this.codMascota = codMascota;
        this.titulo = titulo;
        this.fecha = fecha;
        this.recompensa = recompensa;
        this.cantRecompensa = cantRecompensa;
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

    public boolean isRecompensa() {
        return recompensa;
    }

    public void setRecompensa(boolean recompensa) {
        this.recompensa = recompensa;
    }

    public int getCantRecompensa() {
        return cantRecompensa;
    }

    public void setCantRecompensa(int cantRecompensa) {
        this.cantRecompensa = cantRecompensa;
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
