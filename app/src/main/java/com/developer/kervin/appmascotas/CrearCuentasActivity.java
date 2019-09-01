package com.developer.kervin.appmascotas;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.developer.kervin.appmascotas.util.DBConn;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;

public class CrearCuentasActivity extends AppCompatActivity {

    Button btnCrearCuenta;
    EditText etNombre, etApellido, etEmail, etPassword, etConfirmarPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cuentas);

        btnCrearCuenta = findViewById(R.id.button_crear_cuenta);
        etNombre = findViewById(R.id.edittext_nombre);
        etApellido = findViewById(R.id.edittext_apellido);
        etEmail = findViewById(R.id.edittext_correo);
        etPassword = findViewById(R.id.edittext_password);
        etConfirmarPass = findViewById(R.id.edittext_confir_contras);

        btnCrearCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    String nombre, apellido, email, password, confirPass;
                    nombre = etNombre.getText().toString();
                    apellido = etApellido.getText().toString();
                    email = etEmail.getText().toString();
                    password = etPassword.getText().toString();
                    confirPass = etConfirmarPass.getText().toString();

                    Boolean creado = crearUsuario(nombre, apellido, email, password);
                    if (creado){
                        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                    }else {
                        Toast.makeText(getApplicationContext(),"Datos incorrectos",Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception ex){
                    Toast.makeText(getApplicationContext(), "Error: "+ex, Toast.LENGTH_SHORT).show();
                }


            }
        });
    }

    public boolean crearUsuario(String nom, String ape, String ema, String pas){

        Boolean estaCreado = false;

        try {
            HttpURLConnection httpURLConnection = DBConn.getConnection("crear_usuario.php");

            //ENVIAR DATOS AL SERVIDOR
            httpURLConnection.setRequestMethod("POST");//Se indica el método de envío

            Uri.Builder builder = new Uri.Builder();
            builder.appendQueryParameter("nom", nom);
            builder.appendQueryParameter("ape", ape);
            builder.appendQueryParameter("ema", ema);
            builder.appendQueryParameter("pas", pas);
            //Asi se envio el dato con el nombre del variable dwe formulario
            //o parametro url (si fuera GET)

            //Para enviar los datos definidos al servidor
            BufferedWriter bufferedWriter = new BufferedWriter(
                    new OutputStreamWriter(httpURLConnection.getOutputStream())
            );
            bufferedWriter.write(builder.build().getEncodedQuery());
            bufferedWriter.flush();

            InputStream inputStream = new BufferedInputStream(
                    httpURLConnection.getInputStream()
            );
            estaCreado = true;




        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return estaCreado;
    }

}
