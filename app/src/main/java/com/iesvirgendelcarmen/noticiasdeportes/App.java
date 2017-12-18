package com.iesvirgendelcarmen.noticiasdeportes;

import android.app.Application;
import android.content.Context;

/**
 * Created by matinal on 18/12/2017.
 */

public class App extends Application{

    private static Context contexto;

    @Override
    public void onCreate() {
        super.onCreate();
        contexto=getApplicationContext();
    }

    public static Context getContexto(){
        return contexto;
    }
}
