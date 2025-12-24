/* 
    Gabriel Pontel de Mori - 2025

Exercicio básico de herança, diversas classes modelos uma herdando de outra.

*/
import modelo.Aluno;
import modelo.Pessoa;
import modelo.Professor;
import modelo.Servidor;
import modelo.Tecnico;


public class Principal {
    public static void main(String[] args) {
        
        Pessoa pes = new Pessoa();
        Aluno alu = new Aluno();
        Servidor serv = new Servidor();
        Professor prof = new Professor();
        Tecnico tec = new Tecnico();
        
        System.out.println("Leitura:\n");
        System.out.println("Pessoa:");
        pes.ler();
        System.out.println("Aluno: ");
        alu.ler();
        System.out.println("Servidor:");
        serv.ler();
        System.out.println("Professor:");
        prof.ler();
        System.out.println("Tecnico:");
        tec.ler();
        
        System.out.println("Escrita:\n");
        System.out.println("Pessoa:");
        pes.apresentar();
        System.out.println("Aluno: ");
        alu.apresentar();
        System.out.println("Servidor:");
        serv.apresentar();
        System.out.println("Professor:");
        prof.apresentar();
        System.out.println("Tecnico:");
        tec.apresentar();
    }
}
