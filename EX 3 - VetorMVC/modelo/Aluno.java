package modelo;

public class Aluno {
    private String prontuario;
    private String nome;
    private String curso;
    private Integer anoIngresso;
    private Double notaProva;
    private Double notaTrabalho;
    private Double frequencia;
    
    public Aluno(String novoProntuario, String novoNome, String novoCurso, int novoAnoIngresso, double novaNotaProva, double novaNotaTrabalho, double novaFrequencia)
    {
        prontuario = novoProntuario;
        nome = novoNome;
        curso = novoCurso;
        anoIngresso = novoAnoIngresso;
        notaProva = novaNotaProva;
        notaTrabalho = novaNotaTrabalho;
        frequencia = novaFrequencia;
    }
    
    public Aluno()
    {
        prontuario = " ";
        nome = " ";
        curso = " ";
        anoIngresso = 0;
        notaProva = 0.0;
        notaTrabalho = 0.0;
        frequencia = 0.0;
    }
    
    public String getProntuario(){
        return prontuario;
    }
    
    public String getNome(){
        return nome;
    }
    
    public String getCurso(){
        return curso;
    }
    
    public Integer getAnoIngresso(){
        return anoIngresso;
    }
    
    public Double getNotaProva(){
        return notaProva;
    }
    
    public Double getNotaTrabalho(){
        return notaTrabalho;
    }
    
    public Double getFrequencia(){
        return frequencia;
    }
    
    public void setProntuario(String novoProntuario){
        prontuario = novoProntuario;
    }
    
    public void setNome(String novoNome){
        nome = novoNome;
    }
    
    public void setCurso(String novoCurso){
        curso = novoCurso;
    }
    
    public void setAnoIngresso(int novoAnoIngresso){
        anoIngresso = novoAnoIngresso;
    }
    
    public void setNotaProva(double novaNotaProva){
        notaProva = novaNotaProva;
    }
    
    public void setNotaTrabalho(double novaNotaTrabalho){
        notaTrabalho = novaNotaTrabalho;
    }
    
    public void setFrequencia(double novaFrequencia){
        frequencia = novaFrequencia;
    }
    
    public Double getMedia(){
        return (notaProva + notaTrabalho)/2;
    }
    
    public boolean validarAprovacao(){
        return getMedia()>=6 && frequencia>=75;
    }
    
    public boolean validarAlunoReprovadoPorFalta(){
        return frequencia<75;
    }
    
    public void apresentarAluno(){
        System.out.println("\nPRONTUARIO: "+ prontuario);
        System.out.println("NOME: "+ nome);
        System.out.println("CURSO: "+ curso);
        System.out.println("ANO DE INGRESSO: "+anoIngresso);
        System.out.println("NOTA DA PROVA: "+ notaProva);
        System.out.println("NOTA DO TRABALHO: "+notaTrabalho);
        System.out.println("FREQUENCIA: "+ frequencia);
    }
}
