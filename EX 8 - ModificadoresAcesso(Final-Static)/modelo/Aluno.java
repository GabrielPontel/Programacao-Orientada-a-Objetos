package modelo;

public class Aluno extends Pessoa{
    private Integer prontuario;
    
    public Aluno(){}
    
    public Aluno(String nome, Integer acesso, Integer prontuario){
        super(nome, acesso);
        this.prontuario = prontuario;
    }
    
    public Integer getProntuario(){
        return prontuario;
    }
    
    public void setProntuario(Integer prontuario){
        this.prontuario = prontuario;
    }
    
    @Override
    public String toString(){
        return super.toString() + "\nPRONTUARIO: "+this.prontuario;
    }
}
