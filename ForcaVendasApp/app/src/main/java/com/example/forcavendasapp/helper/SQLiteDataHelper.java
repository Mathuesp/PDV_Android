package com.example.bancodadosexemplo.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteDataHelper extends SQLiteOpenHelper {
    //Passa o nome da base de Dados e não da Tabela
    public SQLiteDataHelper(@Nullable Context context,
                            @Nullable String name,
                            @Nullable SQLiteDatabase.CursorFactory factory,
                            int version) {
        super(context, name, factory, version);
    }
    /**
     * Esse método é executado uma única vez quando o aplicativo é instalado no celular
     */

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE CLIENTE (CODIGO INTEGER, NOME VARCHAR(100), CPF VARCHAR(11)," +
                "DT_NASC VARCHAR(10), COD_ENDERECO)");

        sqLiteDatabase.execSQL("CREATE TABLE ENDERECO (CODIGO INTEGER, LOGRADOURO VARCHAR(100)," +
                "NUMERO VARCHAR(10), BAIRRO VARCHAR(100), CIDADE VARCHAR(100), UF VARCHAR(2))");

        sqLiteDatabase.execSQL("CREATE TABLE ITEM (CODIGO INTEGER, DESCRICAO VARCHAR(100)," +
                "VLR_UNIT DOUBLE, UN_MEDIDA VARCHAR(3))");

        sqLiteDatabase.execSQL("CREATE TABLE PEDIDO_VENDA (NR_PEDIDO INTEGER, COD_CLIENTE INTEGER," +
                "COD_ENDERECO_ENTREGA INTEGER, QTD_ITENS INT, VALOR_TOTAL_ITENS DOUBLE, FORMA_PAGAMENTO VARCHAR(100)," +
                "PARCELAS INTEGER, VALOR_FRETE DOUBLE, VALOR_TOTAL_PEDIDO DOUBLE)");

        sqLiteDatabase.execSQL("CREATE TABLE ITEM_PEDIDO_VENDA (ID INTEGER, COD_ITEM INTEGER, COD_PEDIDO INTEGER," +
                "QTD_ITEM INTEGER, UNIDADE_MEDIDA VARCHAR(3), VALOR_UNITARIO DOUBLE, VALOR_TOTAL_ITEM DOUBLE)");
    }

    /**
     * Esse método é executado quando a versão aplicativo é atualizado no celular
     * @param sqLiteDatabase:
     * @param oldVersion: Versão Antiga do App
     * @param newVersion: Versão Nova que está sendo instalada
     */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }
}
