package visao;

import controle.ControleProduto;
import controle.excecao.IdentificadorClasseExistenteException;
import controle.excecao.IdentificadorClasseInexistenteException;
import java.util.InputMismatchException;
import java.util.Scanner;
import modelo.Produto;
import modelo.excecao.ValorNegativoException;

public class VisaoProduto {

    private ControleProduto controleProduto = new ControleProduto();

    public VisaoProduto() {
    }
    
    public void addAutomatico(){
        controleProduto.getProdutos().add(new Produto(1, "ABACATE", 9.990));
        controleProduto.getProdutos().add(new Produto(2, "COCA-COLA 2L", 10.5));
        controleProduto.getProdutos().add(new Produto(3, "BOLACHA", 3.55));
        controleProduto.getProdutos().add(new Produto(4, "HAMBURGUER", 5));
        controleProduto.getProdutos().add(new Produto(5, "MACA", 80));
    }

    public ControleProduto getControleProduto() {
        return controleProduto;
    }

    public void addProduto() {
        Scanner ler = new Scanner(System.in);
        Produto produto = new Produto();
        boolean valido = true;
        
        try {
            System.out.print("CODIGO DE BARRA: ");
            produto.setCodigoBarra(ler.nextInt());
            ler.nextLine();
            System.out.print("NOME DO PRODUTO: ");
            produto.setNome(ler.nextLine());
            System.out.print("PRECO: ");
            produto.setPreco(ler.nextDouble());
            controleProduto.addProduto(produto);
        } catch (ValorNegativoException e){
            System.out.println(e.getMessage());
            valido = false;
        } catch (InputMismatchException e) {
            System.out.println("DIGITOU UM TIPO INVALIDO PARA O ATRIBUTO!!");
            valido = false;
        } catch (IdentificadorClasseExistenteException e) {
            System.out.println(e.getMessage());
            valido = false;
        }
        if (!valido) {
            System.out.println("PORTANTO NAO FOI POSSIVEL ADICIONAR ESSE PRODUTO");
        }
    }

    public void exibirUmProduto(Produto produto) {
        System.out.println("\nCODIGO DE BARRA: " + produto.getCodigoBarra());
        System.out.println("NOME: " + produto.getNome());
        System.out.println("PRECO: " + produto.getPreco());
    }

    public void exibirProdutos() {
        for (Produto p : controleProduto.getProdutos()) {
            exibirUmProduto(p);
        }
    }

    public void removeProduto() {
        Scanner ler = new Scanner(System.in);
        boolean valido = true;

        try {
            System.out.println("DIGITE O CODIGO DE BARRA DESEJADO: ");
            int codigo = ler.nextInt();
            Produto produto = controleProduto.buscarProduto(codigo);
            controleProduto.removeProduto(produto);
        } catch (InputMismatchException e) {
            System.out.println("VALOR INVALIDO, O CODIGO DEVE SER INTEIRO");
            valido = false;
        } catch (IdentificadorClasseInexistenteException e){
            System.out.println(e.getMessage());
            valido = false;
        }
        if(!valido)
            System.out.println("PORTANTO NAO FOI POSSIVEL REMOVER ESSE PRODUTO");
    }
    
    public int apresentarMenu() {
        Scanner ler = new Scanner(System.in);
        int opcao;
        try {
            System.out.println("\n====== MENU PRODUTO ========");
            System.out.println("0 - SAIR DO MENU PRODUTO");
            System.out.println("1 - INCLUIR PRODUTO");
            System.out.println("2 - EXCLUIR PRODUTO");
            System.out.println("3 - APRESENTAR TODOS PRODUTOS");
            System.out.print(":");
            opcao = ler.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("\nTIPO DE ENTRADA INVALIDA, DIGITE UM INTEIRO!!\n");
            opcao = -1;
        }
        return opcao;
    }

    public void menuProduto() {
        int opcao;
        do {
            opcao = apresentarMenu();
            switch (opcao) {
                case 0:
                    break;
                case 1:
                    addProduto();
                    break;
                case 2:
                    removeProduto();
                    break;
                case 3:
                    exibirProdutos();
                    break;
                default:
                    System.out.println("\nOPCAO INVALIDA\n");
            }
        } while (opcao != 0);
    }
}
