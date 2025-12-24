package visao;

import modelo.Aluno;
import controle.AlunoControle;
import java.util.Scanner;

public class visaoAluno {

    private AlunoControle controle = new AlunoControle();

    public AlunoControle getControle() {
        return controle;
    }
    
    

    public void apresentarAlunos() {
        for (int i = 0; i < controle.getTamanhoVetor(); i++) {
            controle.getAluno(i).apresentarAluno();
        }
    }

    public void adicionarAluno() {
        Aluno aluno = new Aluno();
        Scanner ler = new Scanner(System.in);

        System.out.println("PRONTUARIO: ");
        aluno.setProntuario(ler.nextLine());
        System.out.println("NOME: ");
        aluno.setNome(ler.nextLine());
        System.out.println("CURSO: ");
        aluno.setCurso(ler.nextLine());
        System.out.println("ANO INGRESSO: ");
        aluno.setAnoIngresso(ler.nextInt());
        System.out.println("NOTA PROVA: ");
        aluno.setNotaProva(ler.nextDouble());
        System.out.println("NOTA TRABALHO: ");
        aluno.setNotaTrabalho(ler.nextDouble());
        System.out.println("FREQUENCIA: ");
        aluno.setFrequencia(ler.nextDouble());

        controle.adicionar(aluno);
    }

    public void adicionarAlunos() {
        for (int i = 0; i < 1; i++) {
            adicionarAluno();
        }
    }
 
    public int validarMenu() {
        Scanner ler = new Scanner(System.in);
        int opcao;
        System.out.println("""
                           0 - SAIR
                           1 - Incluir alunos;
                           2 - Excluir alunos pelo prontuário;
                           3 - Alterar um aluno, solicitando o prontuário, apresentando seus dados e permitindo a alteração desses dados;
                           4 - Apresentar os dados de um aluno pelo prontuário, além dos dados, apresentar a média e a situação do aluno;
                           5 - Apresentar todos os alunos, somente o prontuário, nome, curso e média;
                           6 - Apresentar a quantidade de alunos aprovados;
                           7 - Apresentar todos os alunos de um determinado curso, digitado pelo usuário;
                           8 - Apresentar os alunos reprovados por falta;
                           """);
        opcao = ler.nextInt();
        return opcao;
    }

    public String lerProntuario() {
        Scanner ler = new Scanner(System.in);
        System.out.println("PRONTUARIO DESEJADO: ");
        return ler.nextLine();
    }

    public String lerDisciplina() {
        Scanner ler = new Scanner(System.in);
        System.out.println("DISCIPLINA DESEJADA: ");
        return ler.nextLine();
    }
    
     public void alterarAluno() {
        String pront = lerProntuario();
        int posicao = controle.getPosicaoAluno(pront);
        Aluno aluno = controle.getAluno(posicao);
        aluno.apresentarAluno();
        if (posicao != -1) {
           
            Scanner ler = new Scanner(System.in);

            System.out.println("NOME: ");
            aluno.setNome(ler.nextLine());
            System.out.println("CURSO: ");
            aluno.setCurso(ler.nextLine());
            System.out.println("ANO INGRESSO: ");
            aluno.setAnoIngresso(ler.nextInt());
            System.out.println("NOTA PROVA: ");
            aluno.setNotaProva(ler.nextDouble());
            System.out.println("NOTA TRABALHO: ");
            aluno.setNotaTrabalho(ler.nextDouble());
            System.out.println("FREQUENCIA: ");
            aluno.setFrequencia(ler.nextDouble());
        }
        else
            System.out.println("Prontuario invalido!!");
    }
     
    public void exclusaoAluno(){
       String pront = lerProntuario();
                   
                    if (controle.excluirAluno(pront)) {
                        System.out.println("Aluno excluido com sucesso!!");
                    } else {
                        System.out.println("O aluno nao esta no vetor!!");
                    }
    }

    public void apresentarSituacao(){
       int posicao;
        String pront = lerProntuario();
                    posicao = controle.getPosicaoAluno(pront);
                    controle.getAluno(posicao).apresentarAluno();
                    if (controle.getAluno(posicao).validarAprovacao()) {
                        System.out.println("Aluno aprovado!!");
                    } else {
                        System.out.println("Aluno reprovado!!");
                    }
                    System.out.println("A media foi de: " + controle.getAluno(posicao).getMedia());
    }
    
    public void apresentarAlunoReprovadoFalta(){
    int posicao;
        String pront = lerProntuario();
                    posicao = controle.getPosicaoAluno(pront);
                    if (controle.getAluno(posicao).validarAlunoReprovadoPorFalta()) {
                        System.out.println("Aluno reprovado por falta!!");
                    } else {
                        System.out.println("Aluno nao reprovado por falta!!");
                    }
    }
    
    public void apresentarQuantidadeAprovados(){
        System.out.println("A quantidade de alunos aprovados: " + controle.calcularQuantidadeAprovados());
    }
    
    public void apresentarAlunosDeUmDeterminadoCurso() {
        String cursoEscolhido = lerDisciplina();
        for (int i = 0; i < controle.getTamanhoVetor(); i++) {
            if (controle.getAluno(i).getCurso().equals(cursoEscolhido)) {
                controle.getAluno(i).apresentarAluno();
            }
        }
    }
            
    public void apresentarAlgunsDadosAlunos() {
        for(int i=0; i<controle.getTamanhoVetor();i++)
        {
            System.out.println("PRONTUARIO: "+controle.getAluno(i).getProntuario()
                               +"\nNOME: "+ controle.getAluno(i).getNome()
                               +"\nCURSO: "+ controle.getAluno(i).getCurso()
                               +"\nMEDIA: "+ controle.getAluno(i).getMedia());
        }
    }

   
}
