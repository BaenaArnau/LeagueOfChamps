package com.example.leagueofchamps;

import android.os.Bundle;

import androidx.appcompat.view.ContextThemeWrapper;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.appbar.MaterialToolbar;
import com.example.leagueofchamps.databinding.FragmentPostBinding;

public class PostFragment extends Fragment {

    private NavController navController;
    private FragmentPostBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentPostBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        // Obtener el NavController desde el NavHostFragment
        navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);

        // Configurar el OnClickListener para el backArrow
        binding.backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aquí debes reemplazar "R.id.destino_fragmento" con el ID del fragmento al que deseas navegar
                navController.navigate(R.id.buscadorDeForoFragment);
            }
        });

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
