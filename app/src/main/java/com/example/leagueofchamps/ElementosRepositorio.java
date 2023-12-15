package com.example.leagueofchamps;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ElementosRepositorio {

    Executor executor = Executors.newSingleThreadExecutor();
    ElementosBaseDeDatos.ElementosDao elementosDao;

    ElementosRepositorio(Application application){
        elementosDao = ElementosBaseDeDatos.obtenerInstancia(application).obtenerElementosDao();
    }

    LiveData<List<Campeon>> obtener(){
        return elementosDao.obtener();
    }

    void insertar(Campeon elemento){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                elementosDao.insertar(elemento);
            }
        });
    }
}
