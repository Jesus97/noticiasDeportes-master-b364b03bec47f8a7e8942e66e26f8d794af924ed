package com.iesvirgendelcarmen.noticiasdeportes.noticias;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.iesvirgendelcarmen.noticiasdeportes.R;
import com.iesvirgendelcarmen.noticiasdeportes.modelos.Noticia;
import com.iesvirgendelcarmen.noticiasdeportes.noticiasDetalle.NoticiasDetalleActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NoticiasActivity extends AppCompatActivity implements NoticiasContract.View{

    public static final String EXTRA_NOTICIA = "EXTRA_NOTICIA";
    private static NoticiasPresenter noticiasPresenter;

    @BindView(R.id.noticias)
    ListView listViewNoticias;

    @BindView(R.id.toolbar)
    Toolbar toolbar;


    private NoticiasAdapter noticiasAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        noticiasAdapter=new NoticiasAdapter(this, new ArrayList<Noticia>(0));
        listViewNoticias.setAdapter(noticiasAdapter);

        noticiasPresenter=new NoticiasPresenter(this);
        noticiasPresenter.cargaDatos();
        setLayout();
    }

    /**
     * Configuración de la vista
     */
    private void setLayout() {
        //Establece la toolbar de la libreria de soporte
        setSupportActionBar(toolbar);

        //Evento click en item de la lista
        listViewNoticias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Se lanza la Activity de detalles de la noticia
                Intent intent = new Intent(NoticiasActivity.this, NoticiasDetalleActivity.class);
                intent.putExtra(EXTRA_NOTICIA, noticiasPresenter.getNoticia(i));
                startActivity(intent);
            }
        });
    }
    public void showNoticias(List<Noticia>lista){
        noticiasAdapter.updateNoticias(lista);
    }

}
