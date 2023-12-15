package com.example.leagueofchamps;

import java.util.ArrayList;
import java.util.List;

public class ElementosRepositorio {

    List<Campeon> elementos = new ArrayList<>();

    interface Callback {
        void cuandoFinalice(List<Campeon> elementos);
    }

    ElementosRepositorio(){
        elementos.add(new Campeon("Ahri", "La Encantadora", "Pasiva de Ahri", "Orbe del engaño","Orbe de Fuego", "Encanto", "Destello Espiritual"));
        elementos.add(new Campeon("Gwen", "La Hija de la Araña", "Pasiva de Gwen", "Tijeras Hextech", "Enlace Etéreo", "Vestiduras Hextech", "Hilos"));
        elementos.add(new Campeon("Xayah", "La Rebelde", "Pasiva de Xayah", "Disparo de plumas","Cuchillas Dobles", "Corte de Plumas", "Tormenta de Plumas"));
        elementos.add(new Campeon("Nami", "La Invocadora de Mareas", "Pasiva de Nami", "Golpe del Fluido", "Altas Mareas", "Bendición de las Aguas", "Sunami"));
        elementos.add(new Campeon("Jax", "El Maestro de Armas", "Pasiva de Jax", "Golpe potenciado","Golpe de Salto", "Empujón Relámpago", "Ira del Gran Maestro"));
    }

    List<Campeon> obtener() {
        return elementos;
    }

    void insertar(Campeon elemento, Callback callback){
        elementos.add(elemento);
        callback.cuandoFinalice(elementos);
    }
}
