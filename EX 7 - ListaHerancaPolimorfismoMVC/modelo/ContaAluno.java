/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Aluno
 */
public class ContaAluno {
    private static int incrementar=0;
    private double saldo;
    private int numeroConta;

    public ContaAluno() {
        this.numeroConta = getIncrementarNumeroConta();
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public static int getIncrementarNumeroConta(){
        return incrementar++;
    }
    
    public void depositar(double deposito) throws ValorNegativoException{
        if(deposito < 0)
            throw new ValorNegativoException("NAO SE PODE DEPOSITAR UM VALOR NEGATIVO!!");
        else
            this.saldo+=deposito;
    }
    
    public void sacar(double saque) throws SaqueInvalidoException, ValorNegativoException{
        if(saque<0){
            throw new ValorNegativoException("NAO SE PODE INSERIR UM VALOR NEGATIVO PARA O SAQUE!!");
        }
        else if(saque > this.saldo){
            throw new SaqueInvalidoException("NAO PODE SACAR UM VALOR MAIOR QUE SEU SALDO!!");
        }
        else{
            this.saldo-=saque;
        }
    }

    @Override
    public String toString() {
        return "Conta{" + "saldo=" + saldo + ", numeroConta=" + numeroConta + '}';
    }
    
}
