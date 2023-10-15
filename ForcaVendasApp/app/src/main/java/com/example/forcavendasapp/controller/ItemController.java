package com.example.forcavendasapp.controller;

import android.content.Context;

import com.example.forcavendasapp.dao.ClienteDao;
import com.example.forcavendasapp.dao.ItemDao;
import com.example.forcavendasapp.model.Cliente;
import com.example.forcavendasapp.model.Item;

import java.util.ArrayList;

public class ItemController {
    private Context context;

    public ItemController(Context context) {
        this.context = context;
    }

    public long salvarCliente(Item cliente) {
        return ItemDao.getInstance(context).insert(cliente);
    }

    public long atualizaAluno(Item cliente) {
        return ItemDao.getInstance(context).update(cliente);
    }

    public long apagarAluno(Item cliente) {
        return ItemDao.getInstance(context).update(cliente);
    }

    public ArrayList<Item> retornarTodosClientes() {
        return ItemDao.getInstance(context).getAll();
    }

    public Item retornarCliente(int codigo) {
        return ItemDao.getInstance(context).getById(codigo);
    }
}
