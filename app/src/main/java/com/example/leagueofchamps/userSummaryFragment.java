package com.example.leagueofchamps;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class userSummaryFragment extends Fragment {

    private NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user_summary, container, false);

        // Obtener el NavController desde el NavHostFragment
        navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);

        // Configurar el OnClickListener para el botón backArrow
        View backArrow = view.findViewById(R.id.backArrow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navegar hacia el fragmento de inicio o cualquier otro fragmento deseado
                navController.navigate(R.id.userFragment);
            }
        });

        return view;
    }
}
