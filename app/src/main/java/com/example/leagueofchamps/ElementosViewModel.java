package com.example.leagueofchamps;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class ElementosViewModel extends AndroidViewModel {

    ElementosRepositorio elementosRepositorio;

    MutableLiveData<List<Campeon>> listElementosMutableLiveData = new MutableLiveData<>();

    public ElementosViewModel(@NonNull Application application) {
        super(application);

        elementosRepositorio = new ElementosRepositorio(application);
    }

    LiveData<List<Campeon>> obtener(){
        return elementosRepositorio.obtener();
    }
    MutableLiveData<Campeon> elementoSeleccionado = new MutableLiveData<>();

    void insertar(Campeon elemento){
        elementosRepositorio.insertar(elemento);
    }
    void seleccionar(Campeon elemento){
        elementoSeleccionado.setValue(elemento);
    }

    MutableLiveData<Campeon> seleccionado(){
        return elementoSeleccionado;
    }
}
