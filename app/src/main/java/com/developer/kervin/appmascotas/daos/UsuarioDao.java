package com.developer.kervin.appmascotas.daos;

import com.developer.kervin.appmascotas.daos.EntityDao;
import com.developer.kervin.appmascotas.entidades.Usuario;

public interface UsuarioDao extends EntityDao<Usuario> {

    public Usuario validar(String usuario, String password);

}
