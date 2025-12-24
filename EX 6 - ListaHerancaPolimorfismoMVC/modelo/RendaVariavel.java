/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Aluno
 */
public class RendaVariavel extends Investimento implements Imposto{

    public RendaVariavel() {
    }

    public RendaVariavel(double valor) {
        super(valor);
    }
    
    
    @Override
    public double calcularImposto(){
        return 12.5;
    }
    
    @Override
    public String toString(){
        return "Renda Variavel{" + "valor=" + valor + '}';
    }
}
