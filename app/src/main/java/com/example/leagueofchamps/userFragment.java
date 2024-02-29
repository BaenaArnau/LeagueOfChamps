package com.example.leagueofchamps;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class userFragment extends Fragment {

    private NavController navController;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user, container, false);

        // Obtener NavController desde el NavHostFragment
        navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);

        // Configurar el click listener para el botón de retroceso
        View backArrow = view.findViewById(R.id.backArrow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navegar hacia el fragmento de inicio o cualquier otro fragmento deseado
                navController.navigate(R.id.buscadorDeInvocadoresFragment);
            }
        });

        Button favoriteButton = view.findViewById(R.id.favoriteButton);
        favoriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navegar hacia la pantalla deseada
                navController.navigate(R.id.userFavoriteChampsFragment); // Reemplaza "nombre_de_tu_destino" con el ID del destino al que deseas navegar
            }
        });

        Button summaryButton = view.findViewById(R.id.summaryButton);
        summaryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navegar hacia la pantalla deseada
                navController.navigate(R.id.userSummaryFragment); // Reemplaza "nombre_de_tu_destino" con el ID del destino al que deseas navegar
            }
        });

        return view;
    }
}
