package com.example.forcavendasapp.controller;

import android.content.Context;

import com.example.forcavendasapp.dao.ItemDao;
import com.example.forcavendasapp.dao.ItemPedidoVendaDao;
import com.example.forcavendasapp.model.Item;
import com.example.forcavendasapp.model.ItemPedidoVenda;

import java.util.ArrayList;

public class ItemPedidoVendaController {
    private Context context;

    public ItemPedidoVendaController(Context context) {
        this.context = context;
    }

    public long salvarCliente(ItemPedidoVenda cliente) {
        return ItemPedidoVendaDao.getInstance(context).insert(cliente);
    }

    public long atualizaAluno(ItemPedidoVenda cliente) {
        return ItemPedidoVendaDao.getInstance(context).update(cliente);
    }

    public long apagarAluno(ItemPedidoVenda cliente) {
        return ItemPedidoVendaDao.getInstance(context).update(cliente);
    }

    public ArrayList<ItemPedidoVenda> retornarTodosClientes() {
        return ItemPedidoVendaDao.getInstance(context).getAll();
    }

    public ItemPedidoVenda retornarCliente(int codigo) {
        return ItemPedidoVendaDao.getInstance(context).getById(codigo);
    }
}
