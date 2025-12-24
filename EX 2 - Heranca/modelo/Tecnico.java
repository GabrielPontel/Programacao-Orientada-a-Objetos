package modelo;

import java.util.Scanner;

public class Tecnico extends Servidor{
       private String carga;
       
       public Tecnico(){};
       public Tecnico(String nome,String prontuario,String endereco,String telefone,String email,String rg,String cpf, int siape,String carga){
           super(nome, prontuario, endereco, telefone, email, rg, cpf, siape);
           this.carga = carga;
       }
       
       @Override
       public void ler(){
           Scanner ler = new Scanner(System.in);
           super.ler();
           System.out.print("CARGA ............: ");
           this.carga = ler.nextLine();
       }
       
       @Override
       public void apresentar(){
           super.apresentar();
           System.out.println("CARGA ............: "+this.carga);
       }
}
