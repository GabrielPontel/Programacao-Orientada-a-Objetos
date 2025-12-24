package modelo;

import modelo.excecao.ValorNegativoException;

public class ItemVenda {
    private int quant;
    private double valorUnitario;
    private Produto produto;

    public ItemVenda() {
    }

    public ItemVenda(int quant, Produto produto) {
        this.quant = quant;
        this.valorUnitario= quant* produto.getPreco();
        this.produto = produto;
    }

    public int getQuant() {
        return quant;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setQuant(int quant) throws ValorNegativoException{
        if(quant < 0)
            throw new ValorNegativoException("QUANTIDADE INVALIDA - QUANTIDADE DEVE SER POSITIVA");
        else
            this.quant = quant;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
        valorUnitario= quant* produto.getPreco();
    }

    @Override
    public String toString() {
        return "ItemVenda{" + "quant=" + quant + ", valorUnitario=" + valorUnitario + ", produto=" + produto + '}';
    }
}
