package com.example.leagueofchamps;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.Update;

import java.util.List;

@Database(entities = { Campeon.class }, version = 1, exportSchema = false)
public abstract class ElementosBaseDeDatos extends RoomDatabase {
    public abstract ElementosDao obtenerElementosDao();
    private static volatile ElementosBaseDeDatos INSTANCIA;

    static ElementosBaseDeDatos obtenerInstancia(final Context context) {
        if (INSTANCIA == null) {
            synchronized (ElementosBaseDeDatos.class) {
                if (INSTANCIA == null) {
                    INSTANCIA = Room.databaseBuilder(context,
                                    ElementosBaseDeDatos.class, "elementos.db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCIA;
    }

    @Dao
    interface ElementosDao {
        @Query("SELECT * FROM Campeon")
        LiveData<List<Campeon>> obtener();

        @Insert
        void insertar(Campeon elemento);

        @Update
        void actualizar(Campeon elemento);

        @Delete
        void eliminar(Campeon elemento);
    }
}
