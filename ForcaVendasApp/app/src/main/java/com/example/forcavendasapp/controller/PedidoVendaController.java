package com.example.forcavendasapp.controller;

import android.content.Context;

import com.example.forcavendasapp.dao.ItemPedidoVendaDao;
import com.example.forcavendasapp.dao.PedidoVendaDao;
import com.example.forcavendasapp.model.ItemPedidoVenda;
import com.example.forcavendasapp.model.PedidoVenda;

import java.util.ArrayList;

public class PedidoVendaController {
    private Context context;

    public PedidoVendaController(Context context) {
        this.context = context;
    }

    public long salvarCliente(PedidoVenda cliente) {
        return PedidoVendaDao.getInstance(context).insert(cliente);
    }

    public long atualizaAluno(PedidoVenda cliente) {
        return PedidoVendaDao.getInstance(context).update(cliente);
    }

    public long apagarAluno(PedidoVenda cliente) {
        return PedidoVendaDao.getInstance(context).update(cliente);
    }

    public ArrayList<PedidoVenda> retornarTodosClientes() {
        return PedidoVendaDao.getInstance(context).getAll();
    }

    public PedidoVenda retornarCliente(int codigo) {
        return PedidoVendaDao.getInstance(context).getById(codigo);
    }
}
