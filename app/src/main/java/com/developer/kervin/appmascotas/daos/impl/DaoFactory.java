package com.developer.kervin.appmascotas.daos.impl;

import com.developer.kervin.appmascotas.daos.UsuarioDao;
import com.developer.kervin.appmascotas.util.Util;

public class DaoFactory {

    private DaoFactory() {
    }

    public static DaoFactory getInstance() {
        return DaoFactoryHolder.INSTANCE;
    }

    private static class DaoFactoryHolder {

        private static final DaoFactory INSTANCE = new DaoFactory();
    }

    public UsuarioDao getUsuarioDao(int opcion){
        UsuarioDao dao;
        switch(opcion){
            case Util.FP: dao = new UsuarioLoginFP(); break;
            case Util.FB: dao = new UsuarioLoginFB(); break;
            case Util.GO: dao = new UsuarioLoginGO(); break;
            default: dao = null;
        }
        return dao;
    }

}
