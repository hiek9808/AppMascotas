package com.developer.kervin.appmascotas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.developer.kervin.appmascotas.entidades.Usuario;
import com.developer.kervin.appmascotas.services.UsuarioService;
import com.developer.kervin.appmascotas.services.impl.UsuarioServiceImpl;

public class LoginActivity extends AppCompatActivity {

    EditText etCorreo, etPassword;
    Button btnIngresar;
    TextView twCrearCuenta;
    Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usuario = new Usuario();

        etCorreo = findViewById(R.id.edittext_usuario);
        etPassword = findViewById(R.id.edittext_contra);
        btnIngresar = findViewById(R.id.button_ingresar);
        twCrearCuenta = findViewById(R.id.textview_crearcuenta);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String usua = etCorreo.getText().toString();
                String contra = etPassword.getText().toString();
                UsuarioService service = new UsuarioServiceImpl();
                usuario = service.validarLogin(usua, contra);

                if (usuario != null){
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("sesion", usuario);
                    Intent intent = new Intent(getApplicationContext(),PrincipalActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(),"datos incorrectos", Toast.LENGTH_SHORT).show();
                }


            }
        });

        twCrearCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CrearCuentasActivity.class));
            }
        });





    }


}
