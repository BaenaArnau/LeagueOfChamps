package com.example.leagueofchamps;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.example.leagueofchamps.databinding.FragmentBuscadorDeForoBinding;

public class BuscadorDeForoFragment extends Fragment {
    private FragmentBuscadorDeForoBinding binding;
    private NavController navController;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentBuscadorDeForoBinding.inflate(inflater, container, false);
        View rootView = binding.getRoot();

        // Obtener el NavController
        navController = NavHostFragment.findNavController(this);

        // Configurar OnClickListener para el TextView
        binding.foro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.postFragment);
            }
        });

        // Configurar OnClickListener para la flecha hacia atrás
        binding.backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navegar hacia el fragmento de inicio o cualquier otro fragmento deseado
                navController.navigate(R.id.loginFragment);
            }
        });

        return rootView;
    }
}