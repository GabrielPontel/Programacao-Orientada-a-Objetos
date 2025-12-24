package modelo;

import java.util.Scanner;

public class Pessoa {
    private String nome;
    private String prontuario;
    private String endereco;
    private String telefone;
    private String email;
    private String rg;
    private String cpf;
    
    public Pessoa(){};
    public Pessoa(String nome,String prontuario,String endereco,String telefone,String email,String rg,String cpf){
        this.nome = nome;
        this.prontuario = prontuario;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.rg = rg;
        this.cpf = cpf;
    }

    
    
    public void apresentar(){
        System.out.println("NOME .............: "+this.nome);
        System.out.println("PRONTUARIO .......: "+this.prontuario);
        System.out.println("ENDERECO .........: "+this.endereco);
        System.out.println("TELEFONE .........: "+this.telefone);
        System.out.println("EMAIL ............: "+this.email);
        System.out.println("RG ...............: "+this.rg);
        System.out.println("CPF ..............: "+this.cpf);
    }
    
    public void ler(){
        Scanner ler = new Scanner(System.in);
        System.out.print("NOME .............: ");
        this.nome = ler.nextLine();
        System.out.print("PRONTUARIO .......: ");
        this.prontuario = ler.nextLine();
        System.out.print("ENDERECO .........: ");
        this.endereco = ler.nextLine();
        System.out.print("TELEFONE .........: ");
        this.telefone = ler.nextLine();
        System.out.print("EMAIL ............: ");
        this.email = ler.nextLine();
        System.out.print("RG ...............: ");
        this.rg = ler.nextLine();
        System.out.print("CPF ..............: ");
        this.cpf = ler.nextLine();
    }
         
    public String toString(){
        return this.nome+" - "+this.cpf;
    }
}
