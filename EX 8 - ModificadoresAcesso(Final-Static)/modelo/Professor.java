package modelo;

public class Professor extends Pessoa{
    private Double codigo;
    
    public Professor(){}
    
    public Professor(String nome, Integer acesso, Double codigo){
        super(nome, acesso);
        this.codigo = codigo;
    }
    
    public Double getCodigo(){
        return this.codigo;
    }
    
    public void setCodigo(Double codigo){
        this.codigo = codigo;
    }
    
    @Override
    public String toString(){
        return super.toString()+"\nCODIGO: "+this.codigo;
    }
}
