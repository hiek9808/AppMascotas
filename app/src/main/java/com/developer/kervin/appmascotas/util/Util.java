package com.developer.kervin.appmascotas.util;

import android.app.Application;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;

public class Util {

    public static final int FP=0;
    public static final int FB=1;
    public static final int GO=2;


    public static int opc;

    static {
        Properties p = new Properties();
        InputStream is = Application.class.getResourceAsStream("/config.properties");
        try {
            p.load(is);

            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        opc = Integer.parseInt(p.getProperty("opc"));
        //ResourceBundle properties = ResourceBundle.getBundle("/util.config");
        //opc = Integer.parseInt(properties.getString("opc"));
    }

    //public static String rutaServidor = "http://localhost:8080/servicioweb/";

    //Pruebas desde el emulador de android
    //public static String rutaServidor = "http://10.0.2.2/servicioweb/";

    //Pruebas desde el emulador de Genymotion
    //public static String rutaServidor = "http://10.0.3.2/servicioweb/";

    //public static String rutaServidor = "http://pix.pe/servicioandroid/";

    //public static String rutaServidor = "https://kervin9808.000webhostapp.com/serviciosweb/";
}
