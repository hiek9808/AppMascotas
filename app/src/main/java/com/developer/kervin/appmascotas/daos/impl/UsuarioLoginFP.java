package com.developer.kervin.appmascotas.daos.impl;

import android.net.Uri;

import com.developer.kervin.appmascotas.daos.AbstractUsuario;
import com.developer.kervin.appmascotas.daos.UsuarioDao;
import com.developer.kervin.appmascotas.entidades.Usuario;
import com.developer.kervin.appmascotas.util.DBConn;

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

public class UsuarioLoginFP extends AbstractUsuario implements UsuarioDao {

    HttpURLConnection httpURLConnection;
    Uri.Builder builder;
    BufferedWriter bufferedWriter;
    InputStream inputStream;
    BufferedReader bufferedReader;

    @Override
    public Usuario validar(String usuario, String password) {
        Usuario currentUsuario = null; //= new Usuario();
        JSONObject jsonObject;

        try {

            httpURLConnection = DBConn.getConnection("validar_usuario.php");

            //ENVIAR DATOS AL SERVIDOR
            httpURLConnection.setRequestMethod("POST");//Se indica el método de envío

            builder = new Uri.Builder();
            builder.appendQueryParameter("usu", usuario);
            builder.appendQueryParameter("pas", password);
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
                currentUsuario = new Usuario();
                currentUsuario.setCodigo(Integer.parseInt(jsonObject.getString("cod_usu")));
                currentUsuario.setNombre(jsonObject.getString("nom_usu"));
                currentUsuario.setApellido(jsonObject.getString("ape_usu"));
                currentUsuario.setCorreo(jsonObject.getString("cor_usu"));
                currentUsuario.setPassword(jsonObject.getString("pas_usu"));
                //currentUsuario.setFechaNac(jsonObject.getString("fec_nac"));
            }





        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return currentUsuario;
    }
}
