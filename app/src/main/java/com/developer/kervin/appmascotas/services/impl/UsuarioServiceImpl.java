package com.developer.kervin.appmascotas.services.impl;

import com.developer.kervin.appmascotas.daos.UsuarioDao;
import com.developer.kervin.appmascotas.daos.impl.DaoFactory;
import com.developer.kervin.appmascotas.entidades.Usuario;
import com.developer.kervin.appmascotas.services.UsuarioService;
import com.developer.kervin.appmascotas.util.Util;

import java.util.ArrayList;
import java.util.List;

public class UsuarioServiceImpl implements UsuarioService {

    UsuarioDao dao;

    public UsuarioServiceImpl() {
        DaoFactory fabrica = DaoFactory.getInstance();
        dao = fabrica.getUsuarioDao(0);
    }

    @Override
    public Usuario validarLogin(String u, String p) {
        return dao.validar(u,p);
    }

    @Override
    public void grabar(Usuario usuario) {
        dao.create(usuario);
    }

    @Override
    public void actualizar(Usuario usuario) {
        dao.update(usuario);
    }

    @Override
    public void elminar(String id) {
        dao.delete(id);
    }

    @Override
    public Usuario buscar(String id) {
        return dao.find(id);
    }

    @Override
    public ArrayList<Usuario> listar() {
        return dao.findAll();
    }
}
