package controle;

import controle.excecao.IdentificadorClasseExistenteException;
import controle.excecao.IdentificadorClasseInexistenteException;
import java.util.ArrayList;
import java.util.List;
import modelo.Produto;

public class ControleProduto {

    private static List<Produto> produtos = new ArrayList<>();

    public ControleProduto() {
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void addProduto(Produto produto) throws IdentificadorClasseExistenteException {
        for (Produto p : produtos) {
            if (p.getCodigoBarra() == produto.getCodigoBarra()) {
                throw new IdentificadorClasseExistenteException("CODIGO DE BARRA JA CADASTRADO!!");
            }
        }
        produtos.add(produto);
    }
    
    public Produto buscarProduto(int codigoBarra) throws IdentificadorClasseInexistenteException{
        for(Produto p: produtos){
            if(p.getCodigoBarra() == codigoBarra)
                return p;
        }
        throw new IdentificadorClasseInexistenteException("CODIGO DE BARRA INEXISTENTE!!");
    }
    
    public void removeProduto(Produto produto){
        produtos.remove(produto);
    }
}
