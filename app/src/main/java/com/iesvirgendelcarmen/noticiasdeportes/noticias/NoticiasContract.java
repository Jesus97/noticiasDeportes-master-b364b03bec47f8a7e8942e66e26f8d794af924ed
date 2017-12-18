package com.iesvirgendelcarmen.noticiasdeportes.noticias;

import com.iesvirgendelcarmen.noticiasdeportes.modelos.Noticia;

import java.util.List;

/**
 * Created by matinal on 18/12/2017.
 */

public interface NoticiasContract {

    interface View{
        public void showNoticias(List<Noticia> lista);
    }
}
