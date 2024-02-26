package com.example.leagueofchamps;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.appbar.MaterialToolbar;

public class PostFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflar el diseño personalizado del fragmento
        View view = inflater.inflate(R.layout.fragment_post, container, false);

        // Obtener una referencia al MaterialToolbar del diseño
        MaterialToolbar toolbar = view.findViewById(R.id.toolbar);

        // Establecer el fondo del MaterialToolbar
        toolbar.setBackgroundResource(R.drawable.hello_world); // Reemplaza "hello_world" con el nombre de tu imagen

        return view;
    }
}
