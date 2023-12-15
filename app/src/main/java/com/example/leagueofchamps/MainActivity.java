package com.example.leagueofchamps;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtén la referencia al layout principal (puede ser un ConstraintLayout, RelativeLayout, etc.)
        View mainLayout = findViewById(android.R.id.content);

        // Agregar un OnClickListener al layout principal
        mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Acción a realizar al hacer clic en el layout principal
                // Por ejemplo, abrir un fragmento
                abrirFragmento();
            }
        });
    }

    private void abrirFragmento() {
        // Crea una instancia del fragmento que deseas abrir
        LoginFragment tuFragmento = new LoginFragment();

        // Obtiene el FragmentManager
        FragmentManager fragmentManager = getSupportFragmentManager();

        // Inicia una transacción para realizar cambios en los fragmentos
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        // Reemplaza cualquier fragmento actual en el contenedor con el nuevo fragmento
        transaction.replace(android.R.id.content, tuFragmento);

        // Agrega la transacción a la pila de retroceso (back stack)
        transaction.addToBackStack(null);

        // Realiza la transacción
        transaction.commit();
    }
}

