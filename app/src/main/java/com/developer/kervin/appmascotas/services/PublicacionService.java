package com.developer.kervin.appmascotas.services;

import com.developer.kervin.appmascotas.entidades.Publicacion;

import java.util.ArrayList;

public interface PublicacionService {

    public void grabar(Publicacion publicacion);
    public void actualizar(Publicacion publicacion);
    public void elminar(String id);
    public Publicacion buscar(String id);
    public ArrayList<Publicacion> listar();
}
