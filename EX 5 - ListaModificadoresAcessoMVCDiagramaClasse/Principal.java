/*
    Gabriel Pontel de Mori - 2025

Implementar o Sistema de Conveniência, considerando os diagramas de classes disponibilizados no tópico. Para isso será necessário:
1 - Implementar as 4 classes do modelo;
2 - Implementar os 3 controles, considerando a lista como sendo uma variável de classe (static);
3 - Implementar as telas para manter os dados dos clientes, dos produtos e das vendas, sendo que a tela de vendas utiliza o controle de produtos, clientes e vendas.

O sistema deverá ter as seguintes funcionalidades:
Clientes - incluir, excluir e apresentar os clientes;
Produtos - incluir, excluir e apresentar os produtos;
Vendas - incluir, excluir, apresentar todas as vendas de um cliente, todas as vendas gerais, o total de vendas de um determinado produto, totalizar a venda.
*/
import java.util.InputMismatchException;
import java.util.Scanner;
import visao.*;

public class Principal {

    public static void main(String[] args) {
        Principal telaPrincipal = new Principal();
        VisaoProduto telaProduto = new VisaoProduto();
        VisaoCliente telaCliente = new VisaoCliente();
        VisaoVenda telaVenda = new VisaoVenda();
        int opcao;

        //Funções para adicionar na listas objetos
        telaProduto.addAutomatico();
        telaCliente.addAutomatico();

        do {
            opcao = telaPrincipal.apresentarMenu();
            switch (opcao) {
                case 0:
                    telaPrincipal.encerrarMensagem();
                    break;
                case 1:
                    telaCliente.menuCliente();
                    break;
                case 2:
                    telaProduto.menuProduto();
                    break;
                case 3:
                    telaVenda.menuVenda();
                    break;
                default:
                    telaPrincipal.invalidaMensagem();
            }
        } while (opcao != 0);
    }
    
    public int apresentarMenu(){
        Scanner ler = new Scanner(System.in);
        int opcao;
        try {
            System.out.println("\n====== MENU GERAL ========");
            System.out.println("0 - SAIR DO PROGRAMA");
            System.out.println("1 - MENU CLIENTE");
            System.out.println("2 - MENU PRODUTO");
            System.out.println("3 - MENU VENDA");
            System.out.print(":");
            opcao = ler.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("\nTIPO DE ENTRADA INVALIDA, DIGITE UM INTEIRO!!\n");
            opcao = -1;
        }
        return opcao;
    }
    
    public void encerrarMensagem(){
        System.out.println("\nPROGRAMA ENCERRADO");
    }
    
    public void invalidaMensagem(){
        System.out.println("\nOPCAO INVALIDA");
    }
}
