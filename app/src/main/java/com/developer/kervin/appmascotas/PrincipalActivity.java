package com.developer.kervin.appmascotas;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.developer.kervin.appmascotas.entidades.Usuario;

public class PrincipalActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_buscar:
                    getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, new BuscarFragment()).commit();
                    return true;
                case R.id.navigation_informar:

                    getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, new InformarFragment()).commit();
                    return true;
                case R.id.navigation_publicar:
                    PublicarFragment publicarFragment = new PublicarFragment();
                    Bundle bundle = new Bundle();
                    int codigo = sesion.getCodigo();
                    bundle.putInt("codigo", codigo);
                    publicarFragment.setArguments(bundle);
                    getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, publicarFragment).commit();
                    return true;
            }
            return false;
        }
    };

    TextView mtvNombre, mtvCorreo;
    BuscarFragment buscarFragment;
    Usuario sesion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        Bundle datosRecibidos = getIntent().getExtras();
        sesion = datosRecibidos.getParcelable("sesion");

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);
        mtvNombre = headerView.findViewById(R.id.tv_nombre_usuario);
        mtvCorreo = headerView.findViewById(R.id.tv_correro_usuario);
        mtvNombre.setText(sesion.getNombre());
        mtvCorreo.setText(sesion.getCorreo());
        navigationView.setNavigationItemSelectedListener(this);

        getSupportFragmentManager().beginTransaction().add(R.id.contenedor, new BuscarFragment()).commit();



    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {

            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }





    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.



        int id = item.getItemId();

        if (id == R.id.nav_cuenta) {
            // Handle the camera action
        } else if (id == R.id.nav_editar_cuenta) {

        } else if (id == R.id.nav_ver_mascota) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_informar) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
