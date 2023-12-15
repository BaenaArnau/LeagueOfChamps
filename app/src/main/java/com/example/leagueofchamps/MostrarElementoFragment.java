package com.example.leagueofchamps;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.leagueofchamps.databinding.FragmentMostrarElementoBinding;

public class MostrarElementoFragment extends Fragment {
    private FragmentMostrarElementoBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMostrarElementoBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ElementosViewModel elementosViewModel = new ViewModelProvider(requireActivity()).get(ElementosViewModel.class);

        elementosViewModel.seleccionado().observe(getViewLifecycleOwner(), new Observer<Campeon>() {
            @Override
            public void onChanged(Campeon elemento) {
                binding.nombre.setText(elemento.nombre);
                binding.apodo.setText(elemento.apodo);
                binding.pasiva.setText(elemento.pasiva);
                binding.habilidadEnLaQ.setText(elemento.habilidad1);
                binding.habilidadEnLaW.setText(elemento.habilidad2);
                binding.habilidadEnLaE.setText(elemento.habilidad3);
                binding.habilidadEnLaR.setText(elemento.habilidad4);
            }
        });
    }
}
