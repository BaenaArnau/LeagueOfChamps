package com.example.leagueofchamps;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class ElementosViewModel extends AndroidViewModel {

    ElementosRepositorio elementosRepositorio;

    MutableLiveData<List<Campeon>> listElementosMutableLiveData = new MutableLiveData<>();

    public ElementosViewModel(@NonNull Application application) {
        super(application);

        elementosRepositorio = new ElementosRepositorio();

        listElementosMutableLiveData.setValue(elementosRepositorio.obtener());
    }

    MutableLiveData<List<Campeon>> obtener(){
        return listElementosMutableLiveData;
    }

    void insertar(Campeon elemento){
        elementosRepositorio.insertar(elemento, new ElementosRepositorio.Callback() {
            @Override
            public void cuandoFinalice(List<Campeon> elementos) {
                listElementosMutableLiveData.setValue(elementos);
            }
        });
    }
}
