package com.developer.kervin.appmascotas.util;

import android.app.Application;
import android.os.StrictMode;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;

public class DBConn {
    private static String url = null;

    /*static {
        //ResourceBundle properties = ResourceBundle.getBundle("/util.config");
        //url = properties.getString("URL");
        try {
        Properties p = new Properties();
        InputStream is = Application.class.getResourceAsStream("/config.properties");

            p.load(is);

            is.close();


        url = p.getProperty("URL");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }*/


    /**
     * Obtiene una conexion a la Base de Datos.
     * @return
     */
    public static HttpURLConnection getConnection(String php) {
        HttpURLConnection connection = null;
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            String ruta = "https://kervin9808.000webhostapp.com/serviciosweb/" + php;
            //String ruta = "http://127.0.0.1/serviciosweb/" + php;
            URL url = new URL(ruta);
            connection = (HttpURLConnection)url.openConnection();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return connection;
    }
}
