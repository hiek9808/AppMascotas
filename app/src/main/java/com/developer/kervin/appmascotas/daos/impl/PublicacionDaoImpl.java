package com.developer.kervin.appmascotas.daos.impl;

import android.net.Uri;

import com.developer.kervin.appmascotas.daos.PublicacionDao;
import com.developer.kervin.appmascotas.entidades.Publicacion;
import com.developer.kervin.appmascotas.util.DBConn;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.util.ArrayList;

public class PublicacionDaoImpl implements PublicacionDao {

    HttpURLConnection httpURLConnection;
    Uri.Builder builder;
    BufferedWriter bufferedWriter;
    InputStream inputStream;
    BufferedReader bufferedReader;

    @Override
    public void create(Publicacion publicacion) {

        try {

            httpURLConnection = DBConn.getConnection("crear_busqueda.php");

            //ENVIAR DATOS AL SERVIDOR
            httpURLConnection.setRequestMethod("POST");//Se indica el método de envío

            builder = new Uri.Builder();
            builder.appendQueryParameter("tit_bus", publicacion.getTitulo());
            //builder.appendQueryParameter("fec_pub", publicacion.getFecha());
            //builder.appendQueryParameter("rec_bus", String.valueOf(publicacion.getRecompensa()));
            builder.appendQueryParameter("lug_bus", publicacion.getLugar());
            builder.appendQueryParameter("des_bus", publicacion.getDescripcion());
            //Asi se envio el dato con el nombre del variable dwe formulario
            //o parametro url (si fuera GET)

            //Para enviar los datos definidos al servidor
            bufferedWriter = new BufferedWriter(
                    new OutputStreamWriter(httpURLConnection.getOutputStream())
            );
            bufferedWriter.write(builder.build().getEncodedQuery());
            bufferedWriter.flush();


            inputStream = new BufferedInputStream(
                    httpURLConnection.getInputStream()
            );
            bufferedReader = new BufferedReader(
                    new InputStreamReader(inputStream)
            );



        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Publicacion publicacion) {

    }

    @Override
    public void delete(Object id) {

    }

    @Override
    public Publicacion find(Object id) {
        return null;
    }

    @Override
    public ArrayList<Publicacion> findAll() {

        ArrayList<Publicacion> listaPublicacion = null;
        Publicacion publicacion;

        try {

            httpURLConnection = DBConn.getConnection("listar_busqueda.php");


            inputStream = new BufferedInputStream(
                    httpURLConnection.getInputStream()
            );
            bufferedReader = new BufferedReader(
                    new InputStreamReader(inputStream)
            );

            JSONArray jsonArray = new JSONArray(bufferedReader.readLine());
            listaPublicacion = new ArrayList<>();

            for(int i = 0;i <= jsonArray.length()-1; i++){
                publicacion = new Publicacion();
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                publicacion.setCodigo(jsonObject.getInt("cod_bus"));
                publicacion.setTitulo(jsonObject.getString("tit_bus"));
                //publicacion.setFecha(jsonObject.getString("fec_pub"));
                //publicacion.setRecompensa(jsonObject.getInt("rec_bus"));
                publicacion.setLugar(jsonObject.getString("lug_bus"));
                publicacion.setDescripcion(jsonObject.getString("des_bus"));
                listaPublicacion.add(publicacion);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return listaPublicacion;
    }

}
