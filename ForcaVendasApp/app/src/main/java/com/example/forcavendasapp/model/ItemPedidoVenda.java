package com.example.forcavendasapp.model;

public class ItemPedidoVenda {
    private int id;
    private int codItem;
    private int codPedido;
    private int qtdItem;
    private String unidadeMedida;
    private double valorUnitario;
    private double valorTotalItem;

    public ItemPedidoVenda(int id, int codItem, int codPedido, int qtdItem, String unidadeMedida, double valorUnitario, double valorTotalItem) {
        this.id = id;
        this.codItem = codItem;
        this.codPedido = codPedido;
        this.qtdItem = qtdItem;
        this.unidadeMedida = unidadeMedida;
        this.valorUnitario = valorUnitario;
        this.valorTotalItem = valorTotalItem;
    }

    public ItemPedidoVenda() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodItem() {
        return codItem;
    }

    public void setCodItem(int codItem) {
        this.codItem = codItem;
    }

    public int getCodPedido() {
        return codPedido;
    }

    public void setCodPedido(int codPedido) {
        this.codPedido = codPedido;
    }

    public int getQtdItem() {
        return qtdItem;
    }

    public void setQtdItem(int qtdItem) {
        this.qtdItem = qtdItem;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public double getValorTotalItem() {
        return valorTotalItem;
    }

    public void setValorTotalItem(double valorTotalItem) {
        this.valorTotalItem = valorTotalItem;
    }
}
