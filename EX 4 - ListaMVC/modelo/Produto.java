package modelo;

public class Produto {
    private Integer codigo;
    private String nome;
    private String marca;
    private Integer quantidadeEstoque;
    private Double precoCompra;
    private Double precoVenda;
    
    public Produto(){}
    
    public Produto(Integer novoCodigo, String novoNome, String novaMarca, Double novoPrecoCompra){
        codigo = novoCodigo;
        nome = novoNome;
        marca = novaMarca;
        quantidadeEstoque = 0;
        precoCompra = novoPrecoCompra;
        precoVenda = novoPrecoCompra*1.3;
    }
    
    public Integer getCodigo(){
        return codigo;
    }
    
    public void setPrecoVenda(Double taxa){
        if(taxa <= 100)
            precoVenda -= (taxa/100)*precoVenda;
    }
    
    public String getNome(){
        return nome;
    }
    
    public String getMarca(){
        return marca;
    }
    
    public Integer getQuantidadeEstoque(){
        return quantidadeEstoque;
    }
    
    public Double getPrecoCompra(){
        return precoCompra;
    }
    
    public Double getPrecoVenda(){
        return precoVenda;
    }
    
    public void setCodigo(Integer novoCodigo){
        codigo = novoCodigo;
    }
    
    public void setNome(String novoNome){
        nome = novoNome;
    }
    
    public void setMarca(String novaMarca){
        marca = novaMarca;
    }
    
    public void setQuantidadeEstoque(Integer novaQuantidadeEstoque){
        quantidadeEstoque = novaQuantidadeEstoque;
    }
    
    public void setPrecoCompra(Double novoPrecoCompra){
        precoCompra = novoPrecoCompra;
    }
    
    public boolean venda(Integer quantidade){
        if(quantidadeEstoque >= quantidade && quantidade>=0)
        {
            quantidadeEstoque-=quantidade;
            return true;
        }
        return false;
    }
    
    public boolean compra(Integer quantidade){
        if(quantidade>=0){
            quantidadeEstoque+=quantidade;
            return true;
        }
        return false;
    }
    
    public boolean isEstoque(){
        return quantidadeEstoque>0;
    }
    
    public void atualizarPrecoVenda(Integer quantidadeMinima,Double taxa){
        if(quantidadeEstoque<quantidadeMinima){
            precoVenda-=precoVenda*(taxa/100);
        }
    }
}
