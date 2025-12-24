package controle;

import java.util.Scanner;
import modelo.Aluno;

public class AlunoControle {

    private Aluno[] alunos = new Aluno[20];
    private Integer tamanhoVetor;

    public AlunoControle() {
        tamanhoVetor = 0;
    }

    public Integer getTamanhoVetor() {
        return tamanhoVetor;
    }

    public Aluno[] getAlunos() {
        return alunos;
    }

    public Integer calcularQuantidadeAprovados() {
        int quantidade = 0;
        for (int i = 0; i < tamanhoVetor; i++) {
            if (alunos[i].validarAprovacao()) {
                quantidade++;
            }
        }
        return quantidade;
    }

    public void adicionar(Aluno aluno) {
        if (tamanhoVetor < 20) {
            alunos[tamanhoVetor] = aluno;
            tamanhoVetor++;
        }

    }

    public void apresenatarAlunosReprovadosFalta() {
        for (int i = 0; i < tamanhoVetor; i++) {
            if (alunos[i].validarAlunoReprovadoPorFalta()) {
                alunos[i].apresentarAluno();
            }
        }
    }

    

    public Aluno getAluno(int pos) {
        if (pos < tamanhoVetor) {
            return alunos[pos];
        } else {
            return null;
        }
    }

    public Integer getPosicaoAluno(String prontuarioDesejado) {
        int i = 0;
        while (i < tamanhoVetor && !alunos[i].getProntuario().equals(prontuarioDesejado)) {
            i++;
        }
        if (i != tamanhoVetor) {
            return i;
        }
        return -1;
    }

    public boolean excluirAluno(String prontuarioDesejado) {
        int posicao = getPosicaoAluno(prontuarioDesejado);
        if (posicao != -1) {
            for (int i = posicao; i < tamanhoVetor; i++) {
                alunos[i] = alunos[i + 1];
            }
            tamanhoVetor--;
            return true;
        }
        return false;
    }

    
}
