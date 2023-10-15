package com.example.forcavendasapp.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.forcavendasapp.model.PedidoVenda;

import java.util.ArrayList;

public class PedidoVendaDao implements GenericDao<PedidoVenda> {
    //Abrir a Conexão com a BD
    private SQLiteOpenHelper openHelper;

    //Base de Dados
    private SQLiteDatabase bd;

    //Nome das Colunas na Tabela;
    private String[]colunas = {"NR_PEDIDO", "COD_CLIENTE", "COD_ENDERECO_ENTREGA", "QTD_ITENS",
            "VALOR_TOTAL_ITENS", "FORMA_PAGAMENTO", "PARCELAS", "VALOR_FRETE", "VALOR_TOTAL_PEDIDO"};

    //Nome da Tabela;
    private String tableName = "PEDIDO_VENDA";

    private Context context;

    private static PedidoVendaDao instancia;

    /**
     * Método que CRIA a instância uma única vez
     * Toda vez que for necessário utilizar essa classe
     * Irá retornar sempre a mesma instância*/

    public static PedidoVendaDao getInstance(Context context){
        if (instancia == null)
            return instancia = new PedidoVendaDao(context);
        else
            return instancia;
    }

    private PedidoVendaDao(Context context){
        this.context = context;
        //Carregando Base de Dados
        openHelper = new com.example.bancodadosexemplo.helper.SQLiteDataHelper(this.context, "UNIPAR", null, 1);
        // Atribuindo a BD a variável e dando permissão para escrever nas tabelas
        bd = openHelper.getWritableDatabase();
    }

    @Override
    public long insert(PedidoVenda obj) {
        try{
            ContentValues valores = new ContentValues();
            valores.put("NR_PEDIDO", obj.getNrPedido());
            valores.put("COD_CLIENTE", obj.getCodCLiente());
            valores.put("COD_ENDERECO_ENTREGA", obj.getCodEnderecoEntrega());
            valores.put("QTD_ITENS", obj.getQtdItens());
            valores.put("VALOR_TOTAL_ITENS", obj.getValorTotalItens());
            valores.put("FORMA_PAGAMENTO", obj.getFormaPagamento());
            valores.put("PARCELAS", obj.getParcelas());
            valores.put("VALOR_FRETE", obj.getValorFrete());
            valores.put("VALOR_TOTAL_PEDIDO", obj.getValorTotalPedido());

            //Método para inserir na tabela(nome da tabela, coluna especifica que queira inserir, dados
            //Retorna a linha que foi inserida na tabela
            return bd.insert(tableName, null, valores);
        }catch (SQLException e){
            Log.e("insert", e.getMessage());
        }
        return -1;
    }

    @Override
    public long update(PedidoVenda obj) {
        try {
            ContentValues valores = new ContentValues();
            valores.put("NR_PEDIDO", obj.getNrPedido());

            //Identificar para o Where
            String[]identificador = {String.valueOf(obj.getNrPedido())};

            //Método para atualizar
            //<nome da tabela>, <valores> , <clausula where>, <valor do where>
            return bd.update(tableName, valores, "NR_PEDIDO = ?", identificador);

        }catch (SQLException e){
            Log.e("ERROR", "PedidoVendaDao.insert(): " + e.getMessage());
        }
        return -1;
    }

    @Override
    public long delete(PedidoVenda obj) {
        try {
            String[]identificador = {String.valueOf(obj.getNrPedido())};
            return bd.delete(tableName, "NR_PEDIDO = ?", identificador);
        }catch (SQLException ex){
            Log.e("ERRO", "PedidoVendaDao.delete(): " + ex.getMessage());
        }
        return -1 ;
    }

    @Override
    public ArrayList<PedidoVenda> getAll() {
        ArrayList<PedidoVenda> lista = new ArrayList<>();

        try {
            Cursor cursor = bd.query(tableName, colunas, null,
                    null,null,null, "NR_PEDIDO asc");

            if (cursor.moveToFirst()){
                do{
                    PedidoVenda pedido = new PedidoVenda();
                    pedido.setNrPedido(cursor.getInt(0));
                    pedido.setCodCLiente(cursor.getInt(1));
                    pedido.setCodEnderecoEntrega(cursor.getInt(2));
                    pedido.setQtdItens(cursor.getInt(3));
                    pedido.setValorTotalItens(cursor.getInt(4));
                    pedido.setFormaPagamento(cursor.getString(5));
                    pedido.setParcelas(cursor.getInt(6));
                    pedido.setValorFrete(cursor.getDouble(7));
                    pedido.setValorTotalPedido(cursor.getDouble(8));

                    lista.add(pedido);
                }while (cursor.moveToNext());
            }
        }catch (SQLException ex) {
            Log.e("ERRO", "PedidoVendaDao.getAll(): " + ex.getMessage());
        }
        return lista;
    }

    @Override
    public PedidoVenda getById(int id) {
        try {
            String[]identificador = {String.valueOf(id)};

            Cursor cursor = bd.query(tableName, colunas, "NR_PEDIDO = ?",
                    identificador, null, null, null);
            if (cursor.moveToFirst()){
                PedidoVenda pedido = new PedidoVenda();
                pedido.setNrPedido(cursor.getInt(0));
                pedido.setCodCLiente(cursor.getInt(1));
                pedido.setCodEnderecoEntrega(cursor.getInt(2));
                pedido.setQtdItens(cursor.getInt(3));
                pedido.setValorTotalItens(cursor.getInt(4));
                pedido.setFormaPagamento(cursor.getString(5));
                pedido.setParcelas(cursor.getInt(6));
                pedido.setValorFrete(cursor.getDouble(7));
                pedido.setValorTotalPedido(cursor.getDouble(8));

                return pedido;
            }
        }catch (SQLException ex) {
            Log.e("ERRO", "PedidoVendaDao.getId(): " + ex.getMessage());
        }
        return null;
    }
}
