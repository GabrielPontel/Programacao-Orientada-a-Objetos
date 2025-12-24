/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author gabriel
 */
public class Produto {
    private int codigo;
    private double valorAtual;
    private String descricao;

    public Produto() {
    }

    public Produto(int codigo, double valorAtual, String descricao) {
        this.codigo = codigo;
        this.valorAtual = valorAtual;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public double getValorAtual() {
        return valorAtual;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setValorAtual(double valorAtual) {
        this.valorAtual = valorAtual;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Produto{" + "codigo=" + codigo + ", valorAtual=" + valorAtual + ", descricao=" + descricao + '}';
    }
    
    
}
