package com.developer.kervin.appmascotas;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.developer.kervin.appmascotas.entidades.Busqueda;
import com.developer.kervin.appmascotas.entidades.Mascota;
import com.developer.kervin.appmascotas.entidades.Usuario;
import com.developer.kervin.appmascotas.services.BusquedaService;
import com.developer.kervin.appmascotas.services.MascotaService;
import com.developer.kervin.appmascotas.services.impl.BusquedaServiceImpl;
import com.developer.kervin.appmascotas.services.impl.MascotaServiceImpl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;


public class PublicarFragment extends Fragment {

    ImageView mivMascotaPerdida;
    Button btnPublicarMascota;
    Bitmap bitmap;
    EditText etTitulo,etNombre, etRaza, etEdad, etDescripcion, etLugar;
    String tituloBus, nombreMas, razaMas, edadMas, desMas, imgMas, lugarMas;
    Usuario sesion;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_publicar, container, false);

        Bundle datosRecibidos = getArguments();
        final int codigoUsuario = datosRecibidos.getInt("codigo");

        etTitulo = rootView.findViewById(R.id.et_titulo_mascota);
        etNombre = rootView.findViewById(R.id.et_nombre_mascota);
        etRaza = rootView.findViewById(R.id.et_raza_mascota);
        etEdad = rootView.findViewById(R.id.et_edad_mascota);
        etLugar = rootView.findViewById(R.id.et_lugar_mascota);
        etDescripcion = rootView.findViewById(R.id.et_Descripcion_mascota);
        btnPublicarMascota = rootView.findViewById(R.id.bu_publicar);

        mivMascotaPerdida = rootView.findViewById(R.id.iv_mascota_perdida);

        mivMascotaPerdida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                intent.setType("image/");
                startActivityForResult(Intent.createChooser(intent, "Seleccione la aplicacion"),10);
            }
        });

        btnPublicarMascota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MascotaService mascotaService= new MascotaServiceImpl();
                BusquedaService busquedaService = new BusquedaServiceImpl();

                tituloBus = etTitulo.getText().toString();
                nombreMas = etNombre.getText().toString();
                razaMas = etRaza.getText().toString();
                edadMas = etEdad.getText().toString();
                desMas = etDescripcion.getText().toString();
                lugarMas = etLugar.getText().toString();
                imgMas = convertirString(bitmap);
                Mascota mascota= new Mascota();
                mascota.setNombre(nombreMas);
                mascota.setRaza(razaMas);
                mascota.setEdad(Integer.parseInt(edadMas));
                mascota.setImagen(imgMas);
                mascota.setCodigoUsuario(codigoUsuario);
                mascotaService.grabar(mascota);

                Mascota mascota1 = mascotaService.buscar(String.valueOf(codigoUsuario));
                Busqueda busqueda = new Busqueda();
                busqueda.setTitulo(tituloBus);
                busqueda.setDescripcion(desMas);
                busqueda.setCodMascota(mascota1.getCodigo());
                busqueda.setLugar(lugarMas);

                busquedaService.grabar(busqueda);

                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, new BuscarFragment()).commit();


            }
        });

        return rootView;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode== FragmentActivity.RESULT_OK) {
            Uri path = data.getData();
            mivMascotaPerdida.setImageURI(path);
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContext().getContentResolver(), path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    private String convertirString(Bitmap bitmap){
        ByteArrayOutputStream array = new ByteArrayOutputStream();
        bitmap. compress(Bitmap.CompressFormat.JPEG,100, array);
        byte[] imagenByte = array.toByteArray();
        return Base64.encodeToString(imagenByte, Base64.DEFAULT);

    }

}
