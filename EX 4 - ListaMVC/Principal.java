/*
    Gabriel Pontel de Mori - 2025

Desenvolver uma pequena aplicação capaz de gerenciar um conjunto de produtos em uma mercearia, onde vários produtos podem ser cadastrados e posteriormente realizar sobre eles compras, vendas e atualizações de preços.

Considerem que um produto possui as seguintes informações: código, nome, marca, quantidade em estoque, preço de compra e preço de venda;

Considere também as seguintes informações:

Quando um produto é cadastrado, o preço de venda é 30% maior que o preço de compra e a quantidade em estoque é ZERO;
No processo de compra, o usuário deverá digitar o código do produto, deve ser apresentados os dados do produto, ou que esse produto não existe e posteriormente  solicitar ao usuário que digite a 
quantidade comprada que deve ser adicionada ao produto em estoque, e solicitar também o preço de compra que permitirá alterar o preço de venda (30% maior);
O processo de venda é similar ao de compra, porém deve-se verificar se há produto em estoque e não alterar o preço do produto;
A aplicação desenvolvida deve possuir as seguintes funcionalidades:

Cadastrar um novo produto;
Alterar os dados de um produto somente nome e marca;
Excluir um produto, somente se não tiver estoque;
Apresentar os dados de um produto;
Realizar uma compra;
Realizar uma venda;
Atualizar o preço de venda dos produtos que possuem estoque com um determinado percentual;
Apresentar todos os produtos, somente código, nome, marca e preço de venda;
Apresentar todos os produtos sem estoque;
Apresentar apenas os produtos que possuem estoque, com todos os dados;
Listar todos os produtos de uma determinada marca;
Listar todos os produtos com preço entre um valor mínimo e máximo; 
Apresentar o valor total em estoque, onde o valor em estoque de um produto é a quantidade em estoque multiplicado pelo preço de venda.
Apresentar o total de produtos que há no estoque, utilizando apenas a quantidade em estoque.
*/
import visao.ProdutoVisao;

public class Principal {
    
    public static void main(String[] args) {
        Integer opcao;
        ProdutoVisao visao = new ProdutoVisao();
        do{
            opcao = visao.menu();
            switch(opcao){
                case 1:
                    visao.adicionarProduto();
                    break;
                case 2:
                    visao.alterarDados();
                    break;
                case 3:
                    visao.excluirProduto();
                    break;
                case 4:
                    visao.apresentarProdutoEspecifico();
                    break;
                case 5:
                    visao.comprarProdutos();
                    break;
                case 6:
                    visao.venderproduto();
                    break;
                case 7:
                    visao.alterarPrecoVenda();
                    break;
                case 8:
                    visao.apresentarProdutosSemCompra();
                    break;
                case 9:
                    visao.apresentarProdutosSemEstoque();
                    break;
                case 10:
                    visao.apresentarProdutosComEstoque();
                    break;
                case 11:
                    visao.apresentarProdutosDeMarca();
                    break;
                case 12:
                    visao.apresentarProdutosEntreMaximoEMinimo();
                    break;
                case 13:
                    visao.apresentarValorEmEstoque();
                    break;
                case 14:
                    visao.apresentarSomaEmEstoque();
                    break;
                default:
                    visao.apresentarOpcaoInvalida();
            }
        }while(opcao!=0);
    }
}
