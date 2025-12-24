package visao;

import controle.ControleCliente;
import controle.excecao.IdentificadorClasseExistenteException;
import controle.excecao.IdentificadorClasseInexistenteException;
import java.util.InputMismatchException;
import java.util.Scanner;

import modelo.Cliente;

public class VisaoCliente {

    private ControleCliente controleCliente = new ControleCliente();

    public VisaoCliente() {
    }

    public void addAutomatico() {
        controleCliente.getClientes().add(new Cliente("1", "JOSE"));
        controleCliente.getClientes().add(new Cliente("2", "JOAO ANTUNES"));
        controleCliente.getClientes().add(new Cliente("3", "RICARDO"));
        controleCliente.getClientes().add(new Cliente("4", "FELIPE"));
        controleCliente.getClientes().add(new Cliente("5", "ANTONIO"));
    }

    public ControleCliente getControleCliente() {
        return controleCliente;
    }

    public void exibirUmCliente(Cliente cliente) {
        System.out.println("\nNOME: " + cliente.getNome());
        System.out.println("CPF: " + cliente.getCpf());
    }

    public void exibirClientes() {
        for (Cliente c : controleCliente.getClientes()) {
            exibirUmCliente(c);
        }
    }

    public void addCliente() {
        Scanner ler = new Scanner(System.in);
        Cliente cliente = new Cliente();

        System.out.println("\n======== ADICIONAR CLIENTE =========");
        System.out.print("NOME: ");
        cliente.setNome(ler.nextLine());
        System.out.print("CPF: ");
        cliente.setCpf(ler.nextLine());

        try {
            controleCliente.addCliente(cliente);
        } catch (IdentificadorClasseExistenteException ex) {
            System.out.println(ex.getMessage());
            System.out.println("PORTANTO NAO FOI POSSIVEL ADICIONAR ESSE CLIENTE");
        }
    }

    public void removeCliente() {
        Scanner ler = new Scanner(System.in);
        String cpf;
        Cliente cliente = null;

        System.out.println("\n======== REMOVER CLIENTE =========");

        System.out.print("CPF DESEJADO: ");
        cpf = ler.nextLine();

        try {
            cliente = controleCliente.buscarCliente(cpf);
            controleCliente.removeCliente(cliente);
        } catch (IdentificadorClasseInexistenteException e) {
            System.out.println(e.getMessage());
            System.out.println("PORTANTO NAO FOI POSSIVEL EXCLUIR ESSE CLIENTE");
        }
    }

    public int apresentarMenu() {
        Scanner ler = new Scanner(System.in);
        int opcao;
        try {
            System.out.println("\n====== MENU CLIENTE ========");
            System.out.println("0 - SAIR DO MENU CLIENTE");
            System.out.println("1 - INCLUIR CLIENTE");
            System.out.println("2 - EXCLUIR CLIENTE");
            System.out.println("3 - APRESENTAR TODOS CLIENTES");
            System.out.print(":");
            opcao = ler.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("\nTIPO DE ENTRADA INVALIDA, DIGITE UM INTEIRO!!\n");
            opcao = -1;
        }
        return opcao;
    }

    public void menuCliente() {
        int opcao;
        do {
            opcao = apresentarMenu();
            switch (opcao) {
                case 0:
                    break;
                case 1:
                    addCliente();
                    break;
                case 2:
                    removeCliente();
                    break;
                case 3:
                    exibirClientes();
                    break;
                default:
                    System.out.println("\nOPCAO INVALIDA\n");
            }
        } while (opcao != 0);
    }
}
