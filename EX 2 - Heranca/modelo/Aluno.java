package modelo;

import java.util.Scanner;

public class Aluno extends Pessoa{
    private Double ira;
    private String curso;
    
    public Aluno(){};
    public Aluno(String nome,String prontuario,String endereco,String telefone,String email,String rg,String cpf, Double ira, String curso){
        super(nome, prontuario, endereco, telefone, email, rg, cpf);
        this.ira = ira;
        this.curso = curso;
    }
    
    @Override
    public void ler(){
        Scanner ler = new Scanner(System.in);
        super.ler();
        System.out.print("CURSO ............: ");
        this.curso = ler.nextLine();
        System.out.print("IRA ..............: ");
        this.ira = ler.nextDouble();
    }
    
    @Override
    public void apresentar(){
        super.apresentar();
        System.out.println("CURSO ............: "+this.curso);
        System.out.println("IRA ..............: "+this.ira);
    }
}
