package com.example.forcavendasapp.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.forcavendasapp.MainActivity;
import com.example.forcavendasapp.R;
import com.example.forcavendasapp.controller.EnderecoController;
import com.example.forcavendasapp.model.Endereco;

public class CadastroEndereco extends AppCompatActivity {

    private EditText edCodigo;
    private EditText edLogradouro;
    private EditText edNumero;
    private EditText edBairro;
    private EditText edCidade;
    private EditText edUf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_endereco);

        edCodigo = findViewById(R.id.edCodigo);
        edLogradouro = findViewById(R.id.edLogradouro);
        edBairro = findViewById(R.id.edBairro);
        edCidade = findViewById(R.id.edCidade);
        edUf = findViewById(R.id.edUf);
        edNumero = findViewById(R.id.edNumero);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mnInflater = getMenuInflater();
        mnInflater.inflate(R.menu.menu_padrao, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mnSalvar:
                //salvar registro
                salvarEndereco();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void salvarEndereco() {
        EnderecoController enderecoController = new EnderecoController(this);

        Endereco endereco = new Endereco();
        endereco.setUf(String.valueOf(edUf.getText()));
        endereco.setCidade(String.valueOf(edCidade.getText()));
        endereco.setLogradouro(String.valueOf(edLogradouro.getText()));
        endereco.setCodigo(Integer.parseInt(String.valueOf(edCodigo.getText())));
        endereco.setBairro(String.valueOf(edBairro.getText()));
        endereco.setNumero(Integer.parseInt(String.valueOf(edNumero.getText())));

        enderecoController.salvarEndereco(endereco);

        Toast.makeText(this, "Endereço cadastrado com sucesso!",Toast.LENGTH_SHORT);

        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);
    }
}