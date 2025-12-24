package controle;

import java.util.ArrayList;
import modelo.Produto;
import java.util.List;

public class ProdutoControle {

    List<Produto> produtos = new ArrayList<>();

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public Produto localizarProduto(Integer codigoDesejado) {
        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigoDesejado) {
                return produto;
            }
        }
        return null;
    }

    public boolean excluirProduto(Integer codigoDesejado) {
        Produto produto = localizarProduto(codigoDesejado);
        if (produto != null) {
            if (!produto.isEstoque()) {
                produtos.remove(produtos.indexOf(produto));
                return true;
            }
        }
        return false;
    }

    public Double calcularValorEmEstoque() {
        Double somador = 0.0;
        for (Produto produto : produtos) {
            somador += (produto.getQuantidadeEstoque() * produto.getPrecoVenda());
        }
        return somador;
    }

    public List<Produto> fazerListaDeProdutosSemEstoque() {
        List<Produto> produtosSemEstoque = new ArrayList<>();
        for (Produto produto : produtos) {
            if (!produto.isEstoque()) {
                produtosSemEstoque.add(produto);
            }
        }
        return produtosSemEstoque;
    }

    public List<Produto> fazerListaDaMarca(String marcaDesejada) {
        List<Produto> produtosMarca = new ArrayList<>();
        for (Produto produto : produtos) {
            if (produto.getMarca().equals(marcaDesejada)) {
                produtosMarca.add(produto);
            }
        }
        return produtosMarca;
    }

    public List<Produto> fazerListaDeProdutosComEstoque() {
        List<Produto> produtosEstoque = new ArrayList<>();
        for (Produto produto : produtos) {
            if (produto.isEstoque()) {
                produtosEstoque.add(produto);
            }
        }
        return produtosEstoque;
    }

    public List<Produto> fazerListaDeProdutosComValorMaximoEMinimo(Double maximo, Double minimo) {
        List<Produto> produtosValor = new ArrayList<>();
        for (Produto produto : produtos) {
            if (produto.getPrecoCompra() > minimo && produto.getPrecoCompra() < maximo) {
                produtosValor.add(produto);
            }
        }
        return produtosValor;
    }

    public Integer calcularQuantidadeEmEstoque() {
        Integer somador = 0;
        for (Produto produto : produtos) {
            somador += produto.getQuantidadeEstoque();
        }
        return somador;
    }

    public boolean atualizarPrecoVenda(Integer quantidadeMinima, Double taxa) {
        if (taxa<=100 && taxa >= 0 && 0<=quantidadeMinima){
                    for (Produto p : produtos) {
                p.atualizarPrecoVenda(quantidadeMinima, taxa);
            }
                    return true;
        }
                return false;
    }

}
