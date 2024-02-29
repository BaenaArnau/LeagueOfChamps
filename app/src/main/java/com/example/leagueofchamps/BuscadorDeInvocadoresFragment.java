package com.example.leagueofchamps;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.example.leagueofchamps.databinding.FragmentBuscadorDeInvocadoresBinding;

public class BuscadorDeInvocadoresFragment extends Fragment {
    private FragmentBuscadorDeInvocadoresBinding binding;
    private NavController navController;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentBuscadorDeInvocadoresBinding.inflate(inflater, container, false);
        View rootView = binding.getRoot();

        // Obtener el NavController
        navController = NavHostFragment.findNavController(this);

        // Configurar OnClickListener para la flecha hacia atrás
        binding.backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navegar hacia el fragmento de inicio o cualquier otro fragmento deseado
                navController.navigate(R.id.loginFragment);
            }
        });

        binding.imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navegar hacia el fragmento de inicio o cualquier otro fragmento deseado
                navController.navigate(R.id.userFragment);
            }
        });

        return rootView;
    }
}
