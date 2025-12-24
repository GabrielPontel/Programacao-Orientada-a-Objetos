/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Aluno
 */
public class RendaFixa extends Investimento implements Imposto{

    public RendaFixa() {
    }

    public RendaFixa(double valor) {
        super(valor);
    }
    
    @Override
    public double calcularImposto(){
        return valor*0.015;
    }
    
    @Override
    public String toString(){
        return "RendaFixa{" + "valor=" + valor + '}';
    }
}
