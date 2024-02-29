package com.example.leagueofchamps;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;


import com.example.leagueofchamps.databinding.FragmentMenuBinding;

public class MenuFragment extends AppCompatActivity {
    FragmentMenuBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((binding = FragmentMenuBinding.inflate(getLayoutInflater())).getRoot());

        NavController navController = ((NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment)).getNavController();
        NavigationUI.setupWithNavController(binding.bottomNavView, navController);

        // Establecer un OnDestinationChangedListener para ocultar el menú en destinos no deseados
        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, Bundle arguments) {
                // Obtener el ID del fragmento de destino
                int destinationId = destination.getId();

                // Mostrar el menú solo en destinos específicos
                boolean showMenu = destinationId == R.id.buscadorDeCampeones || destinationId == R.id.buscadorDeForoFragment || destinationId == R.id.buscadorDeInvocadoresFragment;
                binding.bottomNavView.setVisibility(showMenu ? View.VISIBLE : View.GONE);
            }
        });
    }
}
