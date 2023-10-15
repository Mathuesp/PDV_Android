package com.example.forcavendasapp.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

import com.example.forcavendasapp.R;

public class ItemPedido extends AppCompatActivity {

    private EditText edId;
    private EditText edCdItem;
    private EditText edCdPedido;
    private EditText edUnMedida;
    private EditText edQtdItem;
    private EditText edVlrUnit;
    private EditText edVlrTotalItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_pedido);

        edId = findViewById(R.id.edId);
        edCdItem = findViewById(R.id.edCdItem);
        edCdPedido = findViewById(R.id.edCdPedido);
        edUnMedida = findViewById(R.id.edUnMedida);
        edQtdItem = findViewById(R.id.edQtdItem);
        edVlrUnit = findViewById(R.id.edVlrUnit);
        edVlrTotalItem = findViewById(R.id.edVlrTotalItem);
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
                salvarItemPedido();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void salvarItemPedido() {
    }
}