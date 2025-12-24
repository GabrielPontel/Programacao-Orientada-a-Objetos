
package modelo;
public class Aluno {
    private String pront;
    private String nome;
    private int anoIngresso;
    private String siglaCurso;

    public Aluno() {
    }

    public Aluno(String pront, String nome, int anoIngresso, String siglaCurso) {
        this.pront = pront;
        this.nome = nome;
        this.anoIngresso = anoIngresso;
        this.siglaCurso = siglaCurso;
    }

    public String getPront() {
        return pront;
    }

    public String getNome() {
        return nome;
    }

    public int getAnoIngresso() {
        return anoIngresso;
    }

    public String getSiglaCurso() {
        return siglaCurso;
    }

    public void setPront(String pront) {
        this.pront = pront;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAnoIngresso(int anoIngresso) {
        this.anoIngresso = anoIngresso;
    }

    public void setSiglaCurso(String siglaCurso) {
        this.siglaCurso = siglaCurso;
    }

    @Override
    public String toString() {
        return "Aluno{" + "pront=" + pront + ", nome=" + nome + ", anoIngresso=" + anoIngresso + ", siglaCurso=" + siglaCurso + '}';
    }
}
