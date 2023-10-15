package com.example.forcavendasapp.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

import com.example.forcavendasapp.R;

public class CadastroPedido extends AppCompatActivity {

    private EditText edNrPedido;
    private EditText edCdCliente;
    private EditText edCdEnderecoEntrega;
    private EditText edQtdItens;
    private EditText edVlrTotalItens;
    private EditText edFormaPagamento;
    private EditText edParcelas;
    private EditText edVlrFrete;
    private EditText edVlrTotalPedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_pedido);

        edNrPedido = findViewById(R.id.edNrPedido);
        edCdCliente = findViewById(R.id.edCdCliente);
        edCdEnderecoEntrega = findViewById(R.id.edCdEnderecoEntrega);
        edQtdItens = findViewById(R.id.edQtdItens);
        edVlrTotalItens = findViewById(R.id.edVlrTotalItens);
        edFormaPagamento = findViewById(R.id.edFormaPagamento);
        edParcelas = findViewById(R.id.edParcelas);
        edVlrFrete = findViewById(R.id.edVlrFrete);
        edVlrTotalPedido = findViewById(R.id.edVlrTotalPedido);
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
                salvarPedido();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void salvarPedido() {


    }
}