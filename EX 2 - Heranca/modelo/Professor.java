package modelo;

import java.util.Scanner;

public class Professor extends Servidor{
    private String area;
    
    public Professor(){};
    public Professor(String nome,String prontuario,String endereco,String telefone,String email,String rg,String cpf, int siape, String area){
        super(nome, prontuario, endereco, telefone, email, rg, cpf, siape);
        this.area = area;
    }
    
    @Override
    public void ler(){
        Scanner ler = new Scanner(System.in);
        super.ler();
        System.out.print("AREA .............: ");
        this.area = ler.nextLine();
    }
    
    @Override
    public void apresentar(){
        super.apresentar();
        System.out.println("AREA .............: "+this.area);
    }
}
