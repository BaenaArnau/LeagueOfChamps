package com.example.leagueofchamps;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.io.IOException;

import pl.droidsonroids.gif.GifDrawable;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View mainLayout = findViewById(android.R.id.content);
        ImageView gifImageView = findViewById(R.id.imagenes);
        TextView tapTextView = findViewById(R.id.tap);

        // Cargar y mostrar el GIF desde el recurso local con Glide
        try {
            GifDrawable gifDrawable = new GifDrawable(getResources(), R.drawable.league_of_legends_logo_animation);
            long gifDuration = gifDrawable.getDuration();

            // Cambiar a una imagen estática después de que termine de reproducirse el GIF
            gifImageView.setImageDrawable(gifDrawable);

            // Aplicar la animación al TextView
            tapTextView.startAnimation(AnimationUtils.loadAnimation(this, R.animator.blink_anim));

            // Cargar la imagen estática con Glide después de que termine el GIF
            mainLayout.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Glide.with(MainActivity.this)
                            .load(R.drawable.logostatico)
                            .diskCacheStrategy(DiskCacheStrategy.ALL) // Opcional: Almacenar en caché para mejorar el rendimiento
                            .into(gifImageView);
                }
            }, gifDuration);
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error al cargar el GIF", Toast.LENGTH_SHORT).show();
        }

        mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirFragmento();
            }
        });
    }

    private void abrirFragmento() {
        LoginFragment tuFragmento = new LoginFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.replace(android.R.id.content, tuFragmento);

        transaction.addToBackStack(null);

        transaction.commit();
    }
}
