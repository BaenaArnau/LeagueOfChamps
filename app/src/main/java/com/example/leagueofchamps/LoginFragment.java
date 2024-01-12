package com.example.leagueofchamps;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        Button btnLogin = view.findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateFields()) {
                    // Todos los campos son válidos, inicia la siguiente actividad
                    Intent intent = new Intent(getActivity(), MenuFragment.class);
                    startActivity(intent);
                }
            }
        });
        TextView enterWithoutLoginTextView = view.findViewById(R.id.enter_witho);
        enterWithoutLoginTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Maneja el evento de clic aquí
                Intent intent = new Intent(getActivity(), MenuFragment.class);
                startActivity(intent);
            }
        });

        return view;
    }

    private boolean validateFields() {
        EditText etEmail = getView().findViewById(R.id.etEmail);
        EditText etPassword = getView().findViewById(R.id.etPassword);

        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();

        if (email.isEmpty() || password.isEmpty()) {
            showToast("Todos los campos deben estar completos.");
            return false;
        }

        if (!isValidEmail(email)) {
            showToast("Ingrese un correo electrónico válido.");
            return false;
        }

        return true;
    }

    private boolean isValidEmail(String email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private void showToast(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }
}
