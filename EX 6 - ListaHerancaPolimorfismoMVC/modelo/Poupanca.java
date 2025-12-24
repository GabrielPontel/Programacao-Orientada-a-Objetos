/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Aluno
 */
public class Poupanca extends Investimento{

    public Poupanca() {
    }

    public Poupanca(double valor) {
        super(valor);
    }
    
    @Override
    public String toString(){
        return "Poupanca{" + "valor=" + valor + '}';
    }
}
