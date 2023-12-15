package com.example.leagueofchamps;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.leagueofchamps.databinding.FragmentCrearCampeon1Binding;

public class CrearCampeon1 extends Fragment {

    private FragmentCrearCampeon1Binding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentCrearCampeon1Binding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ElementosViewModel elementosViewModel = new ViewModelProvider(requireActivity()).get(ElementosViewModel.class);
        NavController navController = Navigation.findNavController(view);

        binding.crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = binding.nombre.getText().toString();
                String apodo = binding.descripcion.getText().toString();
                String pasiva = binding.pasiva.getText().toString();
                String habilidad1 = binding.habilidadEnLaQ.getText().toString();
                String habilidad2 = binding.habilidadEnLaW.getText().toString();
                String habilidad3 = binding.habilidadEnLaE.getText().toString();
                String habilidad4 = binding.habilidadEnLaR.getText().toString();

                elementosViewModel.insertar(new Campeon(nombre, apodo,pasiva,habilidad1,habilidad2,habilidad3,habilidad4));

                navController.popBackStack();
            }
        });
    }
}