package com.example.leagueofchamps;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Campeon {
    @PrimaryKey(autoGenerate = true)
    int id;
    String nombre, apodo, pasiva,habilidad1, habilidad2, habilidad3, habilidad4;

    public Campeon(String nombre, String apodo, String pasiva, String habilidad1, String habilidad2, String habilidad3, String habilidad4) {
        this.nombre = nombre;
        this.apodo = apodo;
        this.pasiva = pasiva;
        this.habilidad1 = habilidad1;
        this.habilidad2 = habilidad2;
        this.habilidad3 = habilidad3;
        this.habilidad4 = habilidad4;
    }
}
