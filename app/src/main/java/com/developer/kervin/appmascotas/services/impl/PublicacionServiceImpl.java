package com.developer.kervin.appmascotas.services.impl;

import com.developer.kervin.appmascotas.daos.PublicacionDao;
import com.developer.kervin.appmascotas.daos.impl.PublicacionDaoImpl;
import com.developer.kervin.appmascotas.entidades.Publicacion;
import com.developer.kervin.appmascotas.services.PublicacionService;

import java.util.ArrayList;

public class PublicacionServiceImpl implements PublicacionService {

    PublicacionDao dao = new PublicacionDaoImpl();

    @Override
    public void grabar(Publicacion publicacion) {
        dao.create(publicacion);
    }

    @Override
    public void actualizar(Publicacion publicacion) {
        dao.update(publicacion);
    }

    @Override
    public void elminar(String id) {
        dao.delete(id);
    }

    @Override
    public Publicacion buscar(String id) {
        return dao.find(id);
    }

    @Override
    public ArrayList<Publicacion> listar() {
        return dao.findAll();
    }
}
