package com.developer.kervin.appmascotas.services.impl;

import com.developer.kervin.appmascotas.daos.MascotaDao;
import com.developer.kervin.appmascotas.daos.impl.MascotaDaoImpl;
import com.developer.kervin.appmascotas.entidades.Mascota;
import com.developer.kervin.appmascotas.services.MascotaService;

import java.util.ArrayList;
import java.util.List;

public class MascotaServiceImpl implements MascotaService {

    MascotaDao dao = new MascotaDaoImpl();

    @Override
    public void grabar(Mascota mascota) {
        dao.create(mascota);
    }

    @Override
    public void actualizar(Mascota mascota) {
        dao.update(mascota);
    }

    @Override
    public void elminar(String id) {
        dao.delete(id);
    }

    @Override
    public Mascota buscar(String id) {
        return dao.find(id);
    }

    @Override
    public ArrayList<Mascota> listar() {
        return dao.findAll();
    }
}
