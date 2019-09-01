package com.developer.kervin.appmascotas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.developer.kervin.appmascotas.entidades.Busqueda;
import com.developer.kervin.appmascotas.entidades.Mascota;
import com.developer.kervin.appmascotas.services.MascotaService;
import com.developer.kervin.appmascotas.services.impl.MascotaServiceImpl;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BusquedaAdapter extends ArrayAdapter<Busqueda> {
    public BusquedaAdapter(Context context, ArrayList<Busqueda> lista)  {
        super(context, 0, lista);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listaBusqueda = convertView;

        if (listaBusqueda == null) {
            listaBusqueda = LayoutInflater.from(getContext()).inflate(R.layout.item_mascota,parent,false);
        }

        Busqueda busqueda = getItem(position);
        MascotaService mascotaService = new MascotaServiceImpl();
        Mascota mascota = mascotaService.buscar(String.valueOf(busqueda.getCodMascota()));
        ImageView imagen = listaBusqueda.findViewById(R.id.iv_mascota);
        Picasso.get().load("https://kervin9808.000webhostapp.com/serviciosweb/imagenes/laila.jgp").into(imagen);
        /*if(mascota.getImagen().isEmpty()) {
            imagen.setImageResource(currentLibro.imagen);
            imagenLibro.setVisibility(View.VISIBLE);
        } else {
            imagenLibro.setVisibility(View.GONE);
        }*/

        TextView titulo = listaBusqueda.findViewById(R.id.tv_titulo);
        titulo.setText(busqueda.getTitulo());

        TextView nombre = listaBusqueda.findViewById(R.id.tv_nombre);
        nombre.setText(busqueda.getLugar());

        TextView recompensa = listaBusqueda.findViewById(R.id.tv_recompensa);
        recompensa.setText(String.valueOf(busqueda.getCantRecompensa()));

        TextView fecha = listaBusqueda.findViewById(R.id.tv_fecha);
        fecha.setText(String.valueOf(busqueda.getCodigo()));


        return listaBusqueda;

    }
}
