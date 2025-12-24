package modelo;

import java.util.Scanner;

public class Servidor extends Pessoa{
    private int siape;
    
    public Servidor(){};
    public Servidor(String nome,String prontuario,String endereco,String telefone,String email,String rg,String cpf, int siape){
        super(nome, prontuario, endereco, telefone, email, rg, cpf);
        this.siape = siape;
    }
    
    @Override
    public void ler(){
        Scanner ler = new Scanner(System.in);
        super.ler();
        System.out.print("SIAPE ............: ");
        this.siape = ler.nextInt();
    }
    
    @Override
    public void apresentar(){
        super.apresentar();
        System.out.println("SIAPE ............: "+this.siape);
    }
    @Override
    public String toString(){
        return super.toString()+this.siape;
    }
}
