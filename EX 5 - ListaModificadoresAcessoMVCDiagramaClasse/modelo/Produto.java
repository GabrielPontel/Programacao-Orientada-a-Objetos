package modelo;

import modelo.excecao.ValorNegativoException;

public class Produto {
    private int codigoBarra;
    private String nome;
    private double preco;

    public Produto() {
    }

    public Produto(int codigoBarra, String nome, double preco) {
        this.codigoBarra = codigoBarra;
        this.nome = nome;
        this.preco = preco;
    }

    public int getCodigoBarra() {
        return codigoBarra;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setCodigoBarra(int codigoBarra) throws ValorNegativoException{
            if(codigoBarra >= 0)
                this.codigoBarra = codigoBarra;
            else
                throw new ValorNegativoException("CODIGO INVALIDO, O CODIGO DEVE SER POSITIVO");
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) throws ValorNegativoException{
        if(preco >= 0)
            this.preco = preco;
        else
            throw new ValorNegativoException("PRECO INVALIDO, O PRECO DEVE SER POSITIVO");
    }

    @Override
    public String toString() {
        return "Produto{" + "codigoBarra=" + codigoBarra + ", nome=" + nome + ", preco=" + preco + '}';
    }
    
}
