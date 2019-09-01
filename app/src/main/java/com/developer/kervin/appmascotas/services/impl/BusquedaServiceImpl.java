package com.developer.kervin.appmascotas.services.impl;

import com.developer.kervin.appmascotas.daos.BusquedaDao;
import com.developer.kervin.appmascotas.daos.impl.BusquedaDaoImpl;
import com.developer.kervin.appmascotas.entidades.Busqueda;
import com.developer.kervin.appmascotas.services.BusquedaService;

import java.util.ArrayList;

public class BusquedaServiceImpl implements BusquedaService {

    BusquedaDao dao = new BusquedaDaoImpl();

    @Override
    public void grabar(Busqueda busqueda) {
        dao.create(busqueda);
    }

    @Override
    public void actualizar(Busqueda busqueda) {
        dao.update(busqueda);
    }

    @Override
    public void elminar(String id) {
        dao.delete(id);
    }

    @Override
    public Busqueda buscar(String id) {
        return dao.find(id);
    }

    @Override
    public ArrayList<Busqueda> listar() {
        return dao.findAll();
    }
}
