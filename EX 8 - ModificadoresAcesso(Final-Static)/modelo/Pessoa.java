package modelo;

public abstract class Pessoa {
    private String nome;
    private Integer acesso;
    
    public Pessoa(String nome, Integer acesso){
        this.nome = nome;
        this.acesso = acesso;
    }
    
    public Pessoa(){}
    
    public String getNome(){
        return this.nome;
    }
    
    public Integer getAcesso(){
        return this.acesso;
    }
    
    public void setNome(String nome)
    {
        this.nome = nome;
    }
    
    public void setAcesso(Integer acesso){
        this.acesso = acesso;
    }
    
    @Override
    public String toString(){
        return "\nNOME: "+this.nome+"\nACESSO: "+this.acesso;
    }
}
