package com.developer.kervin.appmascotas.services;

import com.developer.kervin.appmascotas.entidades.Mascota;

import java.util.ArrayList;
import java.util.List;

public interface MascotaService {

    public void grabar(Mascota mascota);
    public void actualizar(Mascota mascota);
    public void elminar(String id);
    public Mascota buscar(String id);
    public ArrayList<Mascota> listar();

}
