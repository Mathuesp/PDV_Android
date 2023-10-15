package com.example.forcavendasapp.model;


public class PedidoVenda {
    private int nrPedido;
    private int codCLiente;
    private int codEnderecoEntrega;
    private int qtdItens;
    private double valorTotalItens;
    private String formaPagamento;
    private int parcelas;
    private double valorFrete;
    private double valorTotalPedido;

    public PedidoVenda(int nrPedido, int codCLiente, int codEnderecoEntrega, int qtdItens, double valorTotalItens, String formaPagamento, int parcelas, double valorFrete, double valorTotalPedido) {
        this.nrPedido = nrPedido;
        this.codCLiente = codCLiente;
        this.codEnderecoEntrega = codEnderecoEntrega;
        this.qtdItens = qtdItens;
        this.valorTotalItens = valorTotalItens;
        this.formaPagamento = formaPagamento;
        this.parcelas = parcelas;
        this.valorFrete = valorFrete;
        this.valorTotalPedido = valorTotalPedido;
    }

    public PedidoVenda() {
    }

    public int getNrPedido() {
        return nrPedido;
    }

    public void setNrPedido(int nrPedido) {
        this.nrPedido = nrPedido;
    }

    public int getCodCLiente() {
        return codCLiente;
    }

    public void setCodCLiente(int codCLiente) {
        this.codCLiente = codCLiente;
    }

    public int getCodEnderecoEntrega() {
        return codEnderecoEntrega;
    }

    public void setCodEnderecoEntrega(int codEnderecoEntrega) {
        this.codEnderecoEntrega = codEnderecoEntrega;
    }

    public int getQtdItens() {
        return qtdItens;
    }

    public void setQtdItens(int qtdItens) {
        this.qtdItens = qtdItens;
    }

    public double getValorTotalItens() {
        return valorTotalItens;
    }

    public void setValorTotalItens(double valorTotalItens) {
        this.valorTotalItens = valorTotalItens;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }

    public double getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(double valorFrete) {
        this.valorFrete = valorFrete;
    }

    public double getValorTotalPedido() {
        return valorTotalPedido;
    }

    public void setValorTotalPedido(double valorTotalPedido) {
        this.valorTotalPedido = valorTotalPedido;
    }
}

