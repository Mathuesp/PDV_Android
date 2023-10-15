package com.example.forcavendasapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.example.forcavendasapp.R;

public class CadastroItem extends AppCompatActivity {

    private EditText edCodigo;
    private EditText edDescricao;
    private EditText edVlrUnit;
    private EditText edUnMedida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_item);

        edCodigo = findViewById(R.id.edCodigo);
        edDescricao = findViewById(R.id.edDescricao);
        edVlrUnit = findViewById(R.id.edVlrUnit);
        edUnMedida = findViewById(R.id.edUnMedida);
    }
}