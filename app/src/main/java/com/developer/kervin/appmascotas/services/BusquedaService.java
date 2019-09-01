package com.developer.kervin.appmascotas.services;

import com.developer.kervin.appmascotas.entidades.Busqueda;

import java.util.ArrayList;

public interface BusquedaService {

    public void grabar(Busqueda busqueda);
    public void actualizar(Busqueda busqueda);
    public void elminar(String id);
    public Busqueda buscar(String id);
    public ArrayList<Busqueda> listar();
}
