package com.example.forcavendasapp.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.forcavendasapp.model.ItemPedidoVenda;
import com.example.forcavendasapp.model.PedidoVenda;

import java.util.ArrayList;

public class ItemPedidoVendaDao implements GenericDao<ItemPedidoVenda> {
    //Abrir a Conexão com a BD
    private SQLiteOpenHelper openHelper;

    //Base de Dados
    private SQLiteDatabase bd;

    //Nome das Colunas na Tabela;
    private String[]colunas = {"ID", "COD_ITEM", "COD_PEDIDO", "QTD_ITEM", "UNIDADE_MEDIDA",
            "VALOR_UNITARIO", "VALOR_TOTAL_ITEM"};

    //Nome da Tabela;
    private String tableName = "ITEM_PEDIDO_VENDA";

    private Context context;

    private static ItemPedidoVendaDao instancia;

    /**
     * Método que CRIA a instância uma única vez
     * Toda vez que for necessário utilizar essa classe
     * Irá retornar sempre a mesma instância*/

    public static ItemPedidoVendaDao getInstance(Context context){
        if (instancia == null)
            return instancia = new ItemPedidoVendaDao(context);
        else
            return instancia;
    }

    private ItemPedidoVendaDao(Context context){
        this.context = context;
        //Carregando Base de Dados
        openHelper = new com.example.bancodadosexemplo.helper.SQLiteDataHelper(this.context, "UNIPAR", null, 1);
        // Atribuindo a BD a variável e dando permissão para escrever nas tabelas
        bd = openHelper.getWritableDatabase();
    }

    @Override
    public long insert(ItemPedidoVenda obj) {
        try{
            ContentValues valores = new ContentValues();
            valores.put("ID", obj.getId());
            valores.put("COD_ITEM", obj.getCodItem());
            valores.put("COD_PEDIDO", obj.getCodPedido());
            valores.put("QTD_ITEM", obj.getQtdItem());
            valores.put("UNIDADE_MEDIDA", obj.getUnidadeMedida());
            valores.put("VALOR_UNITARIO", obj.getValorUnitario());
            valores.put("VALOR_TOTAL_ITEM", obj.getValorTotalItem());

            //Método para inserir na tabela(nome da tabela, coluna especifica que queira inserir, dados
            //Retorna a linha que foi inserida na tabela
            return bd.insert(tableName, null, valores);
        }catch (SQLException e){
            Log.e("insert", e.getMessage());
        }
        return -1;
    }

    @Override
    public long update(ItemPedidoVenda obj) {
        try {
            ContentValues valores = new ContentValues();
            valores.put("ID", obj.getId());

            //Identificar para o Where
            String[]identificador = {String.valueOf(obj.getId())};

            //Método para atualizar
            //<nome da tabela>, <valores> , <clausula where>, <valor do where>
            return bd.update(tableName, valores, "ID = ?", identificador);

        }catch (SQLException e){
            Log.e("ERROR", "ItemPedidoVendaDao.insert(): " + e.getMessage());
        }
        return -1;
    }

    @Override
    public long delete(ItemPedidoVenda obj) {
        try {
            String[]identificador = {String.valueOf(obj.getId())};
            return bd.delete(tableName, "ID = ?", identificador);
        }catch (SQLException ex){
            Log.e("ERRO", "ItemPedidoVendaDao.delete(): " + ex.getMessage());
        }
        return -1 ;
    }
    
    @Override
    public ArrayList<ItemPedidoVenda> getAll() {
        ArrayList<ItemPedidoVenda> lista = new ArrayList<>();

        try {
            Cursor cursor = bd.query(tableName, colunas, null,
                    null,null,null, "ID asc");

            if (cursor.moveToFirst()){
                do{
                    ItemPedidoVenda itemPedidoVenda = new ItemPedidoVenda();
                    itemPedidoVenda.setId(cursor.getInt(0));
                    itemPedidoVenda.setCodItem(cursor.getInt(1));
                    itemPedidoVenda.setCodPedido(cursor.getInt(2));
                    itemPedidoVenda.setQtdItem(cursor.getInt(3));
                    itemPedidoVenda.setUnidadeMedida(cursor.getString(4));
                    itemPedidoVenda.setValorUnitario(cursor.getDouble(5));
                    itemPedidoVenda.setValorTotalItem(cursor.getDouble(6));

                    lista.add(itemPedidoVenda);
                }while (cursor.moveToNext());
            }
        }catch (SQLException ex) {
            Log.e("ERRO", "ItemPedidoVendaDao.getAll(): " + ex.getMessage());
        }
        return lista;
    }

    @Override
    public ItemPedidoVenda getById(int id) {
        try {
            String[]identificador = {String.valueOf(id)};

            Cursor cursor = bd.query(tableName, colunas, "NR_PEDIDO = ?",
                    identificador, null, null, null);
            if (cursor.moveToFirst()){
                ItemPedidoVenda itemPedidoVenda = new ItemPedidoVenda();
                itemPedidoVenda.setId(cursor.getInt(0));
                itemPedidoVenda.setCodItem(cursor.getInt(1));
                itemPedidoVenda.setCodPedido(cursor.getInt(2));
                itemPedidoVenda.setQtdItem(cursor.getInt(3));
                itemPedidoVenda.setUnidadeMedida(cursor.getString(4));
                itemPedidoVenda.setValorUnitario(cursor.getDouble(5));
                itemPedidoVenda.setValorTotalItem(cursor.getDouble(6));

                return itemPedidoVenda;
            }
        }catch (SQLException ex) {
            Log.e("ERRO", "ItemPedidoVendaDao.getId(): " + ex.getMessage());
        }
        return null;
    }
}
