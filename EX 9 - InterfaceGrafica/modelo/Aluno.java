
package modelo;

public class Aluno {
    private String prontuario;
    private String nome;
    private double prova;
    private double trabalho;

    public Aluno() {
    }

    public Aluno(String prontuario, String nome, double prova, double trabalho) {
        this.prontuario = prontuario;
        this.nome = nome;
        this.prova = prova;
        this.trabalho = trabalho;
    }

    public String getProntuario() {
        return prontuario;
    }

    public void setProntuario(String prontuario) {
        this.prontuario = prontuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getProva() {
        return prova;
    }

    public void setProva(double prova) {
        this.prova = prova;
    }

    public double getTrabalho() {
        return trabalho;
    }

    public void setTrabalho(double trabalho) {
        this.trabalho = trabalho;
    }

    public double getMedia()
    {
        return (prova+trabalho)/2;
    }
    
    public String getSituacao()
    {
        String situacao = "Aprovado";
        if (getMedia() < 6)
            situacao = "Reprovado";
        return situacao;
    }
}
