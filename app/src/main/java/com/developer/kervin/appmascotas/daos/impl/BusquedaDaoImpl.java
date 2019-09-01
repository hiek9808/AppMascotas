package com.developer.kervin.appmascotas.daos.impl;

import android.net.Uri;

import com.developer.kervin.appmascotas.daos.BusquedaDao;
import com.developer.kervin.appmascotas.entidades.Busqueda;
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
import java.text.DateFormat;
import java.util.ArrayList;

public class BusquedaDaoImpl implements BusquedaDao {

    HttpURLConnection httpURLConnection;
    Uri.Builder builder;
    BufferedWriter bufferedWriter;
    InputStream inputStream;
    BufferedReader bufferedReader;

    @Override
    public void create(Busqueda busqueda) {

        try {

            httpURLConnection = DBConn.getConnection("crear_busqueda.php");

            //ENVIAR DATOS AL SERVIDOR
            httpURLConnection.setRequestMethod("POST");//Se indica el método de envío

            builder = new Uri.Builder();
            builder.appendQueryParameter("cod", String.valueOf(busqueda.getCodMascota()));
            builder.appendQueryParameter("tit", busqueda.getTitulo());
            //builder.appendQueryParameter("fec", publicacion.getFecha());c
            //builder.appendQueryParameter("rec", String.valueOf(publicacion.getRecompensa()));
            builder.appendQueryParameter("lug", busqueda.getLugar());
            builder.appendQueryParameter("des", busqueda.getDescripcion());
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
    public void update(Busqueda busqueda) {

    }

    @Override
    public void delete(Object id) {

    }

    @Override
    public Busqueda find(Object id) {
        return null;
    }

    @Override
    public ArrayList<Busqueda> findAll() {
        ArrayList<Busqueda> listaBusqueda = null;
        Busqueda busqueda;

        try {

            httpURLConnection = DBConn.getConnection("listar_busqueda.php");


            inputStream = new BufferedInputStream(
                    httpURLConnection.getInputStream()
            );
            bufferedReader = new BufferedReader(
                    new InputStreamReader(inputStream)
            );

            JSONArray jsonArray = new JSONArray(bufferedReader.readLine());
            listaBusqueda = new ArrayList<>();

            for(int i = 0;i <= jsonArray.length()-1; i++){
                busqueda = new Busqueda();
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                busqueda.setCodigo(jsonObject.getInt("cod_bus"));
                busqueda.setCodMascota(jsonObject.getInt("cod_mas"));
                busqueda.setTitulo(jsonObject.getString("tit_bus"));
                busqueda.setCantRecompensa(jsonObject.getInt("rec_bus"));
                //busqueda.setFecha(jsonObject.getString("fec_pub"));
                //busqueda.setRecompensa(Integer.parseInt(jsonObject.getString("rec_bus")));
                busqueda.setLugar(jsonObject.getString("lug_bus"));
                busqueda.setDescripcion(jsonObject.getString("des_bus"));
                listaBusqueda.add(busqueda);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return listaBusqueda;
    }
}
