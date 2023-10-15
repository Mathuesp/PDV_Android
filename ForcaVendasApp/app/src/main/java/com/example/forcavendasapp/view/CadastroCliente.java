package com.example.forcavendasapp.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.forcavendasapp.MainActivity;
import com.example.forcavendasapp.R;
import com.example.forcavendasapp.controller.ClienteController;
import com.example.forcavendasapp.controller.EnderecoController;
import com.example.forcavendasapp.model.Cliente;
import com.example.forcavendasapp.model.Endereco;

public class CadastroCliente extends AppCompatActivity {

    private EditText edCodigo;
    private EditText edNome;
    private EditText edCpf;
    private EditText edDtNasc;
    private EditText edCdEndereco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_cliente);
        setTitle("Cadastro Aluno");

        edCodigo = findViewById(R.id.edCodigo);
        edNome = findViewById(R.id.edNome);
        edCpf = findViewById(R.id.edCpf);
        edDtNasc = findViewById(R.id.edDtNasc);
        edCdEndereco = findViewById(R.id.edCdEndereco);


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
                salvarCliente();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void salvarCliente() {
        ClienteController clienteController = new ClienteController(this);

        Cliente cliente = new Cliente();
        cliente.setCodigo(Integer.parseInt(String.valueOf(edCodigo.getText())));
        cliente.setNome(String.valueOf(edNome.getText()));
        cliente.setCpf(String.valueOf(edCpf.getText()));
        cliente.setDtNasc(String.valueOf(edDtNasc.getText()));

        String cdEndereco = String.valueOf(edCdEndereco.getText());

        EnderecoController enderecoController = new EnderecoController(this);

        Endereco endereco = enderecoController.retornarEndereco(Integer.parseInt(cdEndereco));
        if (endereco == null) {
            cliente.setCodEndereco(cdEndereco);
            clienteController.salvarCliente(cliente);

            Toast.makeText(this, "Cliente cadastrado com sucesso!",Toast.LENGTH_SHORT);

            Intent intent = new Intent(this, MainActivity.class);

            startActivity(intent);
        } else {
            edCdEndereco.setError("Endereço informado não está cadastrado!");
            Toast.makeText(this, "Favor informar um endereço válido",Toast.LENGTH_SHORT);
        }
    }
}