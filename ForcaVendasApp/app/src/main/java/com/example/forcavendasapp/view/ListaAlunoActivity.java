package com.example.forcavendasapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.forcavendasapp.R;
import com.example.forcavendasapp.adapter.AlunoListAdapter;
import com.example.forcavendasapp.controller.ClienteController;
import com.example.forcavendasapp.model.Cliente;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ListaAlunoActivity extends AppCompatActivity {

    private ClienteController controller;
    private RecyclerView rvAlunos;
    private FloatingActionButton btNovoAluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_aluno);

        controller = new ClienteController(this);
        rvAlunos = findViewById(R.id.rvAlunos);
        btNovoAluno = findViewById(R.id.btNovoAluno);

        atualiarListaAlunos();
    }

    private void atualiarListaAlunos() {
        ArrayList<Cliente> listaAlunos = controller.retornarTodosClientes();

        AlunoListAdapter adapter = new AlunoListAdapter(listaAlunos, this);

        rvAlunos.setLayoutManager(new LinearLayoutManager(this));
        rvAlunos.setAdapter(adapter);
    }
}