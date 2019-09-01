package com.developer.kervin.appmascotas.daos.impl;

import android.net.Uri;

import com.android.volley.toolbox.JsonArrayRequest;
import com.developer.kervin.appmascotas.daos.MascotaDao;
import com.developer.kervin.appmascotas.entidades.Mascota;
import com.developer.kervin.appmascotas.entidades.Usuario;
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
import java.util.List;

public class MascotaDaoImpl implements MascotaDao {

    HttpURLConnection httpURLConnection;
    Uri.Builder builder;
    BufferedWriter bufferedWriter;
    InputStream inputStream;
    BufferedReader bufferedReader;

    @Override
    public void create(Mascota mascota) {
        try {

            httpURLConnection = DBConn.getConnection("crear_mascota.php");

            //ENVIAR DATOS AL SERVIDOR
            httpURLConnection.setRequestMethod("POST");//Se indica el método de envío

            builder = new Uri.Builder();
            builder.appendQueryParameter("usu", String.valueOf(mascota.getCodigoUsuario()));
            builder.appendQueryParameter("nom", mascota.getNombre());
            builder.appendQueryParameter("raz", mascota.getRaza());
            builder.appendQueryParameter("eda", String.valueOf(mascota.getEdad()));
            builder.appendQueryParameter("siz", mascota.getSize());
            builder.appendQueryParameter("img", mascota.getImagen());


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
    public void update(Mascota mascota) {

    }

    @Override
    public void delete(Object id) {

    }

    @Override
    public Mascota find(Object id) {

        Mascota mascota = null;
        JSONObject jsonObject;
        try {

            httpURLConnection = DBConn.getConnection("buscar_mascota.php");

            //ENVIAR DATOS AL SERVIDOR
            httpURLConnection.setRequestMethod("POST");//Se indica el método de envío

            builder = new Uri.Builder();
            builder.appendQueryParameter("cod", id.toString());
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

            jsonObject = new JSONObject(bufferedReader.readLine());

            if (jsonObject.length() >= 0) {
                mascota = new Mascota();
                mascota.setCodigo(jsonObject.getInt("cod_mas"));
                mascota.setNombre(jsonObject.getString("nom_mas"));
                mascota.setRaza(jsonObject.getString("raz_mas"));
                mascota.setEdad(jsonObject.getInt("eda_mas"));
                mascota.setSize(jsonObject.getString("tam_mas"));
                mascota.setEstado(jsonObject.getInt("est_mas"));
                mascota.setImagen(jsonObject.getString("img_mas"));
                mascota.setCodigoUsuario(jsonObject.getInt("cod_usu"));
            }





        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return mascota;

    }

    @Override
    public ArrayList<Mascota> findAll() {

        ArrayList<Mascota> listaMascota = null;
        Mascota mascota;

        try {

            httpURLConnection = DBConn.getConnection("listar_mascota.php");

            //ENVIAR DATOS AL SERVIDOR//Se indica el método de envío
            //Asi se envio el dato con el nombre del variable dwe formulario
            //o parametro url (si fuera GET)

            //Para enviar los datos definidos al servidor



            inputStream = new BufferedInputStream(
                    httpURLConnection.getInputStream()
            );
            bufferedReader = new BufferedReader(
                    new InputStreamReader(inputStream)
            );

            JSONArray jsonArray = new JSONArray(bufferedReader.readLine());
            listaMascota = new ArrayList<>();

            for(int i = 0;i <= jsonArray.length()-1; i++){
                mascota = new Mascota();
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                mascota.setCodigo(jsonObject.getInt("cod_mas"));
                mascota.setNombre(jsonObject.getString("nom_mas"));
                mascota.setRaza(jsonObject.getString("raz_mas"));
                mascota.setEdad(jsonObject.getInt("eda_mas"));
                mascota.setSize(jsonObject.getString("tam_mas"));
                mascota.setEstado(jsonObject.getInt("est_mas"));
                mascota.setImagen(jsonObject.getString("img_mas"));
                mascota.setCodigoUsuario(jsonObject.getInt("cod_usu"));
                listaMascota.add(mascota);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return listaMascota;
    }
}
