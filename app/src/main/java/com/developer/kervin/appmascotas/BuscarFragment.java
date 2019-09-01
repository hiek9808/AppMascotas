package com.developer.kervin.appmascotas;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.developer.kervin.appmascotas.entidades.Busqueda;
import com.developer.kervin.appmascotas.entidades.Mascota;
import com.developer.kervin.appmascotas.entidades.Publicacion;
import com.developer.kervin.appmascotas.services.BusquedaService;
import com.developer.kervin.appmascotas.services.MascotaService;
import com.developer.kervin.appmascotas.services.PublicacionService;
import com.developer.kervin.appmascotas.services.impl.BusquedaServiceImpl;
import com.developer.kervin.appmascotas.services.impl.MascotaServiceImpl;
import com.developer.kervin.appmascotas.services.impl.PublicacionServiceImpl;

import java.util.ArrayList;


public class BuscarFragment extends Fragment {

    ArrayList<Mascota> listaMascotas;
    ArrayList<Busqueda> listaBusqueda;

    public BuscarFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MascotaService mascotaService = new MascotaServiceImpl();
        listaMascotas = mascotaService.listar();

        BusquedaService busquedaService = new BusquedaServiceImpl();
        listaBusqueda = busquedaService.listar();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_buscar, container, false);
        ListView lvMascotas = rootView.findViewById(R.id.lv_lista_mascotas);


        BusquedaAdapter adapter = new BusquedaAdapter(getActivity(), listaBusqueda);

        lvMascotas.setAdapter(adapter);


        return rootView;
    }

}
