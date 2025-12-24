/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author gabriel
 */
public class Lance {
    private int codigoProduto;
    private double valorLance;
    private String nome;
    private String telefone;
    private int numLance;

    public Lance() {
    }

    public Lance(int codigoProduto, double ultimoLance, String nome, String telefone, int numLance) {
        this.codigoProduto = codigoProduto;
        this.valorLance = ultimoLance;
        this.nome = nome;
        this.telefone = telefone;
        this.numLance = numLance;
    }

    public int getCodigoProduto() {
        return codigoProduto;
    }

    public double getValorLance() {
        return valorLance;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public int getNumLance() {
        return numLance;
    }

    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public void setValorLance(double ultimoLance) {
        this.valorLance = ultimoLance;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setNumLance(int numLance) {
        this.numLance = numLance;
    }

    @Override
    public String toString() {
        return "Lance{" + "codigoProduto=" + codigoProduto + ", ultimoLance=" + valorLance + ", nome=" + nome + ", telefone=" + telefone + ", numLance=" + numLance + '}';
    }
    
    
}
