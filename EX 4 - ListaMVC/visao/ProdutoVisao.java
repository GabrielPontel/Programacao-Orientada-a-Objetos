package visao;

import modelo.Produto;
import controle.ProdutoControle;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class ProdutoVisao {

    ProdutoControle controle = new ProdutoControle();

    public void adicionarProduto() {
        Scanner ler = new Scanner(System.in);
        System.out.println("CODIGO: ");
        Integer codigo = ler.nextInt();
        System.out.println("NOME: ");
        ler.nextLine();
        String nome = ler.nextLine();
        System.out.println("MARCA: ");
        String marca = ler.nextLine();
        System.out.println("PRECO DE COMPRA: ");
        Double precoCompra = ler.nextDouble();
        Produto produto = new Produto(codigo, nome, marca, precoCompra);
        controle.adicionarProduto(produto);
    }

    public void apresentarProduto(Produto produto) {
        System.out.println("CODIGO: " + produto.getCodigo());
        System.out.println("NOME: " + produto.getNome());
        System.out.println("MARCA: " + produto.getMarca());
        System.out.println("QUANTIDADE EM ESTOQUE: " + produto.getQuantidadeEstoque());
        System.out.println("PRECO COMPRA: " + produto.getPrecoCompra());
        System.out.println("PRECO VENDA: " + produto.getPrecoVenda());
    }

    public void apresentarProdutos() {
        for (Produto produto : controle.getProdutos()) {
            apresentarProduto(produto);
        }
    }

    public void apresentarProdutosSemCompra() {
        for (Produto produto : controle.getProdutos()) {
            System.out.println("CODIGO: " + produto.getCodigo());
            System.out.println("NOME: " + produto.getNome());
            System.out.println("MARCA: " + produto.getMarca());
            System.out.println("PRECO VENDA: " + produto.getPrecoVenda());
        }
    }

    public void excluirProduto() {
        Scanner ler = new Scanner(System.in);
        System.out.println("DIGITE O CODIGO DO PRODUTO DESEJADO: ");
        Integer codigo = ler.nextInt();

        if (controle.excluirProduto(codigo)) {
            System.out.println("PRODUTO EXCLUIDO COM SUCESSO");
        } else {
            System.out.println("NAO FOI POSSIVEL EXCLUIR ESSE PRODUTO");
        }
    }

    public void apresentarProdutoEspecifico() {
        Scanner ler = new Scanner(System.in);
        System.out.println("DIGITE O CODIGO DO PRODUTO DESEJADO: ");
        Integer codigo = ler.nextInt();
        Produto produto = controle.localizarProduto(codigo);
        if (produto != null) {
            apresentarProduto(produto);
        } else {
            System.out.println("NAO CONTEM ESSE PRODUTO NA LISTA");
        }
    }

    public void comprarProdutos() {
        Scanner ler = new Scanner(System.in);
        System.out.println("DIGITE O CODIGO DO PRODUTO DESEJADO: ");
        Integer codigo = ler.nextInt();
        Produto produto = controle.localizarProduto(codigo);
        if (produto != null) {
            apresentarProduto(produto);
            System.out.println("DIGITE A QUANTIDADE COMPRADA: ");
            Integer quantidade = ler.nextInt();
            if (produto.compra(quantidade)) {
                System.out.println("COMPRA REALIZADA COM SUCESSO");
            } else {
                System.out.println("QUANTIDADE INVALIDA");
            }
        } else {
            System.out.println("NAO CONTEM ESSE PRODUTO NA LISTA");
        }
    }

    public void alterarDados() {
        Scanner ler = new Scanner(System.in);
        System.out.println("DIGITE O CODIGO DO PRODUTO DESEJADO: ");
        Integer codigo = ler.nextInt();
        Produto produto = controle.localizarProduto(codigo);
        if (produto != null) {
            System.out.println("DIGITE O NOME:");
            ler.nextLine();
            produto.setNome(ler.nextLine());
            System.out.println("DIGITE A MARCA:");
            produto.setMarca(ler.nextLine());
        } else {
            System.out.println("NAO EXISTE PRODUTO COM ESSE CODIGO NESSA LISTA");
        }
    }

    public void venderproduto(){
        Scanner ler = new Scanner(System.in);
        System.out.println("DIGITE O CODIGO DO PRODUTO DESEJADO: ");
        Integer codigo = ler.nextInt();
        Produto produto = controle.localizarProduto(codigo);
        if(produto!=null)
        {
            System.out.println("DIGITE A QUANTIDADE: ");
            Integer quantidade = ler.nextInt();
            if(produto.venda(quantidade))
                System.out.println("O VALOR TOTAL FOI DE :" + quantidade*produto.getPrecoVenda());
            else
                System.out.println("NÃO FOI POSSIVEL COMPRAR ESSA QUANTIDADE DESSE PRODUTO");
        }
        else {
            System.out.println("NAO EXISTE PRODUTO COM ESSE CODIGO NESSA LISTA");
        }
    }
    
    public void apresentarSomaEmEstoque(){
        System.out.println("A SOMA DE PRODUTOS EM ESTOQUE: "+ controle.calcularQuantidadeEmEstoque());
    }
    
    public void apresentarValorEmEstoque(){
        System.out.println("A SOMA DO VALOR EM ESTOQUE: "+controle.calcularValorEmEstoque());
    }
    
    public void apresentarProdutosComEstoque(){
        List<Produto> estoque =controle.fazerListaDeProdutosComEstoque();
        for(Produto produto: estoque){
            apresentarProduto(produto);
        }
    }
    
     public void apresentarProdutosSemEstoque(){
        List<Produto> semEstoque =controle.fazerListaDeProdutosSemEstoque();
        for(Produto produto: semEstoque){
            apresentarProduto(produto);
        }
    }
     
    public void apresentarProdutosDeMarca(){
        Scanner ler = new Scanner(System.in);
        System.out.println("DIGITE A MARCA DESEJADA: ");
        String marcaDesejada = ler.nextLine();
        List<Produto> produtosMarca =controle.fazerListaDaMarca(marcaDesejada);
        for(Produto produto: produtosMarca){
            apresentarProduto(produto);
        }
    }
    
    public Double validarApartirDeUmMinimo(double minimo){
        Scanner ler = new Scanner(System.in);
        Double valor;
        do{
            System.out.println("DIGITE UM VALOR MAIOR "+minimo+" : ");
            valor = ler.nextDouble();
            if(valor<minimo)
                System.out.println("INVALIDO DIGITE UM VALOR MAIOR QUE O MINIMO :"+minimo);
        }while(valor<minimo);
        return valor;
    }
    
    public void apresentarProdutosEntreMaximoEMinimo(){
        Double minimo = validarApartirDeUmMinimo(0.0);
        Double maximo = validarApartirDeUmMinimo(minimo);
        List<Produto> produtosValor =controle.fazerListaDeProdutosComValorMaximoEMinimo(maximo, minimo);
        for(Produto produto: produtosValor){
            apresentarProduto(produto);
        }
    }
    
    public void apresentarOpcaoInvalida(){
        System.out.println("DIGITE UMA OPCAO VALIDA!!");
    }
    
    public void alterarPrecoVenda(){
        Scanner ler = new Scanner(System.in);
        System.out.println("DIGITE A QUANTIDADE MINIMA DE ITENS PARA ALTERAR O VALOR DE VENDA: ");
        Integer quantidadeMinima = ler.nextInt();
        System.out.println("DIGITE A TAXA DO DESCONTO PARA A QUEIMA DE ESTOQUE: ");
        Double taxa = ler.nextDouble();
        if(controle.atualizarPrecoVenda(quantidadeMinima, taxa)){
            System.out.println("ALTERAÇÕES DE PRECOS FEITAS COM SUCESSO");
        }
        else{
            System.out.println("NAO FOI POSSIVEL REALIZAR ESSA ACAO POR CONTA DA TAXA OU QUANTIDADE INVALIDA");
        }
            
    }
    
    public Integer menu() {
        Scanner ler = new Scanner(System.in);
        System.out.println("""
                           0 - SAIR
                           1 - Cadastrar um novo produto;
                           2 - Alterar os dados de um produto somente nome e marca;
                           3 - Excluir um produto, somente se n\u00e3o tiver estoque;
                           4 - Apresentar os dados de um produto;
                           5 - Realizar uma compra;
                           6 - Realizar uma venda;
                           7 - Atualizar o preco de venda dos produtos que possuem um estoque minimo definido pelo usuario(mudei a instruçao pois nao tava fazendo sentido, ja que o produo nao tem estoque esperado);
                           8 - Apresentar todos os produtos, somente c\u00f3digo, nome, marca e pre\u00e7o de venda;
                           9 - Apresentar todos os produtos sem estoque;
                           10 - Apresentar apenas os produtos que possuem estoque, com todos os dados;
                           11 - Listar todos os produtos de uma determinada marca;
                           12 - Listar todos os produtos com pre\u00e7o entre um valor m\u00ednimo e m\u00e1ximo; 
                           13 - Apresentar o valor total em estoque, onde o valor em estoque de um produto é a quantidade em estoque multiplicado pelo preço de venda.
                           14 - Apresentar o total de produtos que há no estoque, utilizando apenas a quantidade em estoque.
                           """);
        return ler.nextInt();
    }
    
   
}
