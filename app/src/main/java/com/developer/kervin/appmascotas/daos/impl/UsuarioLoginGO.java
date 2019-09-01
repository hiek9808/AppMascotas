package com.developer.kervin.appmascotas.daos.impl;

import com.developer.kervin.appmascotas.daos.AbstractUsuario;
import com.developer.kervin.appmascotas.daos.UsuarioDao;
import com.developer.kervin.appmascotas.entidades.Usuario;

public class UsuarioLoginGO extends AbstractUsuario implements UsuarioDao {
    @Override
    public Usuario validar(String usuario, String password) {
        return null;
    }
}
