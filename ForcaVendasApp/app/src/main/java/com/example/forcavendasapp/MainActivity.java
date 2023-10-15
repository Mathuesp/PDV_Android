package com.example.forcavendasapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.forcavendasapp.view.CadastroCliente;
import com.example.forcavendasapp.view.CadastroEndereco;
import com.example.forcavendasapp.view.CadastroItem;
import com.example.forcavendasapp.view.CadastroPedido;
import com.example.forcavendasapp.view.ItemPedido;

public class MainActivity extends AppCompatActivity {

    private Button btClientes;
    private Button btEndereco;
    private Button btItem;
    private Button btCadastroPedido;
    private Button btCadastroItemPedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btClientes = findViewById(R.id.btClientes);
        btEndereco = findViewById(R.id.btEndereco);
        btItem = findViewById(R.id.btItem);
        btCadastroPedido = findViewById(R.id.btCadastroPedido);
        btCadastroItemPedido = findViewById(R.id.btCadastroItemPedido);

        btClientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CadastroCliente.class);

                startActivity(intent);
            }
        });

        btEndereco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CadastroEndereco.class);

                startActivity(intent);
            }
        });

        btItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CadastroItem.class);

                startActivity(intent);
            }
        });

        btCadastroPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CadastroPedido.class);

                startActivity(intent);
            }
        });

        btCadastroItemPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ItemPedido.class);

                startActivity(intent);
            }
        });


    }
}