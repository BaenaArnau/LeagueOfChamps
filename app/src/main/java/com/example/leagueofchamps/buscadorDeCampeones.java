package com.example.leagueofchamps;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.leagueofchamps.databinding.FragmentBuscadorDeCampeonesBinding;
import com.example.leagueofchamps.databinding.ViewholderElementoBinding;

import java.util.List;

public class buscadorDeCampeones extends Fragment {
    private FragmentBuscadorDeCampeonesBinding binding;
    private ElementosViewModel elementosViewModel;
    private NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentBuscadorDeCampeonesBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);
        elementosViewModel = new ViewModelProvider(this).get(ElementosViewModel.class);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        ElementosAdapter elementosAdapter = new ElementosAdapter();
        binding.recyclerView.setAdapter(elementosAdapter);

        binding.irANuevoElemento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_recyclerElementosFragment_to_nuevoElementoFragment);
            }
        });

        elementosViewModel.obtener().observe(getViewLifecycleOwner(), new Observer<List<Campeon>>() {
            @Override
            public void onChanged(List<Campeon> elementos) {
                elementosAdapter.establecerLista(elementos);
            }
        });

    }

    class ElementoViewHolder extends RecyclerView.ViewHolder {
        private final ViewholderElementoBinding binding;

        public ElementoViewHolder(ViewholderElementoBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    class ElementosAdapter extends RecyclerView.Adapter<ElementoViewHolder> {

        List<Campeon> elementos;

        @NonNull
        @Override
        public ElementoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ElementoViewHolder(ViewholderElementoBinding.inflate(getLayoutInflater(), parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull ElementoViewHolder holder, int position) {

            Campeon elemento = elementos.get(position);

            holder.binding.nombre.setText(elemento.nombre);
        }

        @Override
        public int getItemCount() {
            return elementos != null ? elementos.size() : 0;
        }

        public void establecerLista(List<Campeon> elementos){
            this.elementos = elementos;
            notifyDataSetChanged();
        }
    }
}