package com.dam.t02p02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.dam.t02p02.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
//        setContentView(R.layout.activity_main);
        setContentView(binding.getRoot());

        binding.btAceptar.setOnClickListener(btAceptar_OnClickListener);
        binding.btCancelar.setOnClickListener(btCancelar_OnClickListener);
    }
    private final View.OnClickListener btCancelar_OnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            binding.etDni.setText("");
            binding.etNombre.setText("");
            binding.rgSexo.clearCheck();
            binding.cbMayorEdad.setChecked(false);
            binding.etDni.requestFocus();
            Toast.makeText(MainActivity.this,
                    R.string.msg_DatosEliminados,
                    Toast.LENGTH_SHORT
            ).show();
        }
    };
    private final View.OnClickListener btAceptar_OnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (!binding.etDni.getText().toString().equals("")&&!binding.etNombre.getText().toString().equals("")) {
                String texto = "";
                texto = getString(R.string.msg_Dni) + binding.etDni.getText().toString() + "\r\n" +
                        getString(R.string.msg_Nombre) + binding.etNombre.getText().toString() + "\r\n";
                if (binding.rbHombre.isChecked())
                    texto = texto +
                            getString(R.string.msg_SexoH) + "\r\n";
                if (binding.rbMujer.isChecked())
                    texto = texto +
                            getString(R.string.msg_SexoM) + "\r\n";

                if (binding.cbMayorEdad.isChecked()) {
                    texto = texto +
                            getString(R.string.msg_MayorE) + "\r\n";
                } else {
                    texto = texto +
                            getString(R.string.msg_MenorE) + "\r\n";
                }
                Toast.makeText(MainActivity.this, texto, Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(MainActivity.this,R.string.msg_DatosObligatorios, Toast.LENGTH_SHORT).show();
            }
            binding.etDni.setText("");
            binding.etNombre.setText("");
            binding.rgSexo.clearCheck();
            binding.cbMayorEdad.setChecked(false);
            binding.etDni.requestFocus();
            Toast.makeText(MainActivity.this,
                    R.string.msg_DatosEliminados,
                    Toast.LENGTH_SHORT
            ).show();
        }
    };


}