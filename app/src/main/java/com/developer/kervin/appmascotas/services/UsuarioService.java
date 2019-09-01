package com.developer.kervin.appmascotas.services;

import com.developer.kervin.appmascotas.entidades.Usuario;

import java.util.ArrayList;
import java.util.List;

public interface UsuarioService {

    public Usuario validarLogin(String u, String p);
    public void grabar(Usuario usuario);
    public void actualizar(Usuario usuario);
    public void elminar(String id);
    public Usuario buscar(String id);
    public ArrayList<Usuario> listar();

}
