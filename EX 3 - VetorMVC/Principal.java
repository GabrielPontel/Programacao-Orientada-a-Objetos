/*
    Gabriel Pontel de Mori - 2025

Criar um menu principal para todas as ações a serem desenvolvidas:
    1. Incluir alunos;
    2. Excluir alunos pelo prontuário;
    3. Alterar um aluno, solicitando o prontuário, apresentando seus dados e permitindo a alteração desses dados;
    4. Apresentar os dados de um aluno pelo prontuário, além dos dados, apresentar a média e a situação do aluno;
    5. Apresentar todos os alunos, somente o prontuário, nome, curso e média;
    6. Apresentar a quantidade de alunos aprovados;
    7. Apresentar todos os alunos de um determinado curso, digitado pelo usuário;
    8. Apresentar os alunos reprovados por falta;
Desenvolver:
    1. Um método para calcular a média de um aluno;
    2. Um método para determinar se o aluno está aprovado;
    3. Um método para determinar se o aluno está reprovado por falta;
    4. Um método para calcular a quantidade de alunos aprovado;
    5. Um método para apresentar os alunos de um determinado curso;
    6. Um método para apresentar os alunos reprovados por falta;
    7. A exclusão de um aluno a partir do seu prontuário;
    8. A alteração dos dados de um aluno, com exceção do prontuário.
*/

import visao.visaoAluno;

public class Principal {
    public static void main(String[] args) {
            visaoAluno tela = new visaoAluno();
            int opcao;
        do {
            opcao = tela.validarMenu();
            switch (opcao) {
                case 1 -> {
                    tela.adicionarAluno();
                }
                case 2 -> {
                    tela.exclusaoAluno();
                }
                case 3 -> {
                    tela. alterarAluno();
                }
                case 4 -> {
                    tela.apresentarSituacao(); 
                }
                case 5 -> {
                    tela.apresentarAlgunsDadosAlunos();
                }
                case 6 -> {
                    tela.apresentarQuantidadeAprovados(); 
                }
                case 7 -> {
                    tela.apresentarAlunosDeUmDeterminadoCurso();
                }
                case 8 -> {
                   tela.getControle().apresenatarAlunosReprovadosFalta();
                }
                default -> {
                    System.out.println("Opcao invalida!!");
                }
            }

        } while (opcao != 0);
        }
}
