package visao;

import controle.GerenciarAcesso;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import modelo.Aluno;
import modelo.Catraca;
import modelo.Pessoa;
import modelo.Professor;

public class ApresentarPessoas {

    private GerenciarAcesso controle = new GerenciarAcesso();

    public Integer getOpcao() {
        Integer escolha;
        Scanner teclado = new Scanner(System.in);
        try {
            System.out.print("DIGITE A OPCAO ESCOLHIDA:\n1 - ADICIONAR ALUNO\n2 - AIDCIONAR PROFESSOR\n:");
            escolha = teclado.nextInt();
            if (escolha < 1 || escolha > 2) {
                throw new Exception("OPCAO VALIDA");
            }
        } catch (InputMismatchException e) {
            System.out.println("ERRO - ELEMENTO DIGITADO NAO E INTEIRO");
            escolha = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            escolha = null;
        }
        return escolha;
    }

    public void exibirPessoas() {
        ArrayList<Pessoa> lista = controle.getLista();
        for (Pessoa p : lista) {
            if (p instanceof Aluno) {
                Aluno pA = (Aluno) p;
                System.out.println(pA.toString());
            } else {
                Professor pP = (Professor) p;
                System.out.println(pP.toString());
            }
        }
    }

    public Integer menu() {
        Scanner ler = new Scanner(System.in);
        Integer opcao;
        try {
            System.out.print("\n===========MENU============\n0 - SAIR\n1 - ADICIONAR\n2 - EXCLUIR\n3 - APRESENTAR\n:");
            opcao = ler.nextInt();
        } catch (Exception e) {
            opcao = null;
        }
        return opcao;
    }

    public Pessoa montarAluno(String nome) {
        boolean certo=true;
        Integer prontuario = null; 
        Pessoa p= null;
        Scanner ler = new Scanner(System.in);
        
        try {
            System.out.print("DIGITE O PRONTUARIO: ");
            prontuario = ler.nextInt();
        } catch (InputMismatchException e) {
            certo = false;
            System.out.println("ERRO - VALOR INVALIDO , NAO E INTEIRO");
        }
        if(certo)
            p = new Aluno(nome, Catraca.getvalor(), prontuario);
        return p;
    }
    
    public Pessoa montarProfessor(String nome) {
        boolean certo=true;
        Double codigo=null; 
        Pessoa p= null;
        Scanner ler = new Scanner(System.in);
        
        try {
            System.out.print("DIGITE O CODIGO: ");
            codigo = ler.nextDouble();
        } catch (InputMismatchException e) {
            certo = false;
            System.out.println("ERRO - VALOR INVALIDO , NAO E DOUBLE");
        }
        if(certo)
            p = new Professor(nome, Catraca.getvalor(), codigo);
        return p;
    }

    public void adicionarLista() {
        Scanner ler = new Scanner(System.in);
        Pessoa p;
        Integer opcao = getOpcao();
        if (opcao != null) {

            System.out.print("DIGITE O NOME: ");
            String nome = ler.nextLine();

            if (opcao == 1) {
                p=montarAluno(nome);
            } else {
                p=montarProfessor(nome);
            }
            if (p != null) {
                controle.adicionar(p);
            } 
            else {
                System.out.println("NÃO FOI POSSIVEL ADICIONAR ESSE OBJETO");
            }
        } 
        else {
            System.out.println("NAO FOI POSSIVEL ADICIONAR ESSE OBJETO NA LISTA");
        }
    }

    public void removerLista(){
        Scanner ler = new Scanner(System.in);
        Pessoa pes;
        System.out.print("DIGITE O NOME DA PESSOA QUE BUSCA: ");
        String nome = ler.nextLine();
        pes = controle.buscar(nome);
        if(pes == null){
            System.out.println("ERRO - NAO CONTEM PESSOA COM ESSE NOME NA LISTA");
        }
        else{
            controle.remover(pes);
        }
    }
    
    public void escolheuNaoInteiro() {
        System.out.println("DIGITE UM INTEIRO!!");
    }

    public void escolherOpcaoInvalida() {
        System.out.println("DIGITE UMA OPCAO VALIDA");
    }

}
