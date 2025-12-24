package visao;

import controle.ControleCliente;
import controle.ControleProduto;
import controle.ControleVenda;
import controle.excecao.IdentificadorClasseExistenteException;
import controle.excecao.IdentificadorClasseInexistenteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import modelo.Cliente;
import modelo.ItemVenda;
import modelo.Produto;
import modelo.Venda;
import modelo.excecao.ValorNegativoException;

public class VisaoVenda {

    private ControleVenda controleVenda = new ControleVenda();

    public VisaoVenda() {
    }

    public ControleVenda getControleVenda() {
        return controleVenda;
    }

    public void setControleVenda(ControleVenda controleVenda) {
        this.controleVenda = controleVenda;
    }

    public void exibirUmaVenda(Venda venda) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        System.out.println("\n\n=============================================\nDATA: " + sdf.format(venda.getData()));
        System.out.println("TOTAL: " + venda.getTotal());
        System.out.println("FORMA DE PAGAMENTO: " + venda.getFormaPagto());
        if (!venda.getCliente().getCpf().equals("-1")) {
            System.out.println("NOME DO CLIENTE: " + venda.getCliente().getNome());
            System.out.println("CPF DO CLIENTE: " + venda.getCliente().getCpf());
        }
        for (ItemVenda i : venda.getItens()) {
            System.out.println("\nQUANTIDADE: " + i.getQuant());
            System.out.println("VALOR UNITARIO: " + i.getValorUnitario());
            System.out.println("CODIGO DE BARRA DO PROTUDO: " + i.getProduto().getCodigoBarra());
            System.out.println("NOME DO PRODUTO: " + i.getProduto().getNome());
            System.out.println("PRECO DE UM PRODUTO: " + i.getProduto().getPreco());
        }
    }

    public void exibirVendas() {
        for (Venda v : controleVenda.getVendas()) {
            exibirUmaVenda(v);
        }
    }

    public void exibirVendasDeUmCliente() {
        Scanner ler = new Scanner(System.in);
        ControleCliente controleCliente = new ControleCliente();
        try {
            System.out.print("DIGITE O CPF DO CLIENTE(SE DESEJAR VENDAS SEM CLIENTE DIGITE -1): ");
            String cpfDesejado = ler.nextLine();
            if(!cpfDesejado.equals("-1"))
                controleCliente.buscarCliente(cpfDesejado);
            List<Venda> vendasCliente = controleVenda.getVendasCliente(cpfDesejado);
            for (Venda v : vendasCliente) {
                exibirUmaVenda(v);
            }
        } catch (IdentificadorClasseInexistenteException e) {
            System.out.println(e.getMessage());
            System.out.println("PORTANTO NAO FOI POSSIVEL MOSTRAR AS VENDAS PARA O CLIENTE");
        }
    }

    public void totalizarVendas() {
        System.out.println("\nO VALOR ACUMULADO COM TODAS AS VENDAS: " + controleVenda.totalizarVendas());
    }

    public void totalVendasProduto() {
        Scanner ler = new Scanner(System.in);
        try {
            System.out.print("DIGITE O CODIGO DO PRODUTO DESEJADO: ");
            int codigo = ler.nextInt();
            System.out.println("ESSE PRODUTO JA ESTEVE PRESENTE EM " + controleVenda.quantVendasProduto(codigo) + " VENDAS");
        } catch (InputMismatchException e) {
            System.out.println("NAO FOI POSSIVEL APRESENTAR A QUANTIDADE, POIS O CODIGO DEVE SER POSITIVO");
        }
    }

    public List<ItemVenda> formarListaCompra() {
        ControleProduto controleProduto = new ControleProduto();
        Scanner ler = new Scanner(System.in);
        List<ItemVenda> itens = new ArrayList<>();
        boolean valido = true;
        ItemVenda item = new ItemVenda();
        System.out.println("======= PRODUTOS DISPONIVEIS ==========");
        for (Produto p : controleProduto.getProdutos()) {
            System.out.println("NOME: " + p.getNome() + " CODIGO:" + p.getCodigoBarra());
        }
        do {
            item = new ItemVenda();
            valido = true;
            try {
                System.out.print("\nDIGITE A QUANTIDADE (0 - FECHA A COMPRA): ");
                item.setQuant(ler.nextInt());
                if (item.getQuant() != 0) {
                    System.out.print("DIGITE O CODIGO DE BARRA DO PRODUTO: ");
                    item.setProduto(controleProduto.buscarProduto(ler.nextInt()));
                    itens.add(item);
                }
            } catch (InputMismatchException e) {
                System.out.println("VALOR INVALIDO , POIS DEVE SE UTILIZAR VALOR INTEIRO NOS ATRIBUTOS!!");
                valido = false;
            } catch (ValorNegativoException e) {
                System.out.println(e.getMessage());
                valido = false;
            } catch (IdentificadorClasseInexistenteException e) {
                System.out.println(e.getMessage());
                valido = false;
            }
            if (!valido) {
                System.out.println("PORTANTO NAO FOI POSSIVEL ADICIONAR ESSE ITEM");
            }
        } while (item.getQuant() != 0 || !valido || itens.size()==0);
        return itens;
    }

    public void addVenda() {
        ControleCliente controleCliente = new ControleCliente();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        Scanner ler = new Scanner(System.in);
        Venda venda = new Venda();
        boolean valido = true;
        try {
            System.out.print("DATA (DD/MM/AAAA) : ");
            String data = ler.nextLine();
            venda.setData(sdf.parse(data));
            for (Cliente c : controleCliente.getClientes()) {
                System.out.println("NOME: " + c.getNome() + " CPF: " + c.getCpf());
            }
            System.out.println("DIGITE O CPF DO CLIENTE: (DIGITE -1 CASO NAO DESEJE ARMAZENAR O CLIENTE):");
            String cpfCliente = ler.nextLine();
            if(!cpfCliente.equals("-1"))
                venda.setCliente(controleCliente.buscarCliente(cpfCliente));
            else{
                venda.setCliente(new Cliente(cpfCliente, ""));
            }
            List<ItemVenda> lista = formarListaCompra();
            for(ItemVenda i: lista){
                venda.addItem(i.getQuant(), i.getProduto());
            }
            System.out.println("DIGITE A FORMA DE PAGAMENTO: ");
            venda.setFormaPagto(ler.nextLine());
            controleVenda.addVenda(venda);
        } catch (ParseException e) {
            System.out.println("DIGITOU A DATA NO FORMATO ERRADO!!");
            valido = false;
        } catch (IdentificadorClasseInexistenteException | IdentificadorClasseExistenteException e) {
            System.out.println(e.getMessage());
            valido = false;
        }
        if (!valido) {
            System.out.println("PORTANTO A VENDA NAO FOI REALIZADA");
        }
    }

    public void removeVenda() {
        Scanner ler = new Scanner(System.in);
        boolean valido = true;
        ControleCliente controleCliente = new ControleCliente();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        try {
            System.out.print("\nDIGITE O CPF DO CLIENTE(SE DESEJAR VENDAS SEM CLIENTE DIGITE -1): ");
            String cpfDesejado = ler.nextLine();
            if(!cpfDesejado.equals("-1"))
                controleCliente.buscarCliente(cpfDesejado);
            List<Venda> vendasCliente = controleVenda.getVendasCliente(cpfDesejado);
            for (Venda v : vendasCliente) {
                exibirUmaVenda(v);
            }
            System.out.print("\nESCOLHA UMA DATA (DD/MM/AAAA): ");
            String data = ler.nextLine();
            Date dataEscolhida = sdf.parse(data);
            List<Venda> vendasDataCliente = controleVenda.getVendaEscolhida(vendasCliente, dataEscolhida);
            Venda desejado;
            if (vendasDataCliente.size() != 1) {
                for (Venda v : vendasDataCliente) {
                    exibirUmaVenda(v);
                }
                System.out.print("\nDIGITE O VALOR DA VENDA DESEJADA:");
                double valor = ler.nextDouble();
                desejado = controleVenda.getValor(vendasDataCliente, valor);
            } else {
                desejado = vendasDataCliente.remove(0);
            }
            controleVenda.removeVenda(desejado);
        } catch (InputMismatchException e) {
            System.out.println("VALOR INVALIDO PARA ESSE ATRIBUTO!!");
            valido = false;
        } catch (IdentificadorClasseInexistenteException e) {
            System.out.println(e.getMessage());
            valido = false;
        } catch (ParseException e) {
            System.out.println("NAO DIGITOU A DATA FORMATADA CORRETAMENTE");
            valido = false;
        }
        if (!valido) {
            System.out.println("PORTANTO NAO FOI POSSIVEL REALIZAR A VENDA");
        }
    }

    public int apresentarMenu() {
        Scanner ler = new Scanner(System.in);
        int opcao;
        try {
            System.out.println("\n====== MENU VENDA ========");
            System.out.println("1 - INCLUIR VENDA");
            System.out.println("2 - EXCLUIR VENDA");
            System.out.println("3 - APRESENTAR TODAS VENDAS DE UM CLIENTE");
            System.out.println("4 - APRESENTAR TODAS AS VENDAS");
            System.out.println("5 - TOTAL DE VENDAS DE UM PRODUTO");
            System.out.println("6 - TOTALIZAR AS VENDAS");
            opcao = ler.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("\nTIPO DE ENTRADA INVALIDA, DIGITE UM INTEIRO!!\n");
            opcao = -1;
        }
        return opcao;
    }

    public void menuVenda() {
        int opcao;
        do {
            opcao = apresentarMenu();
            switch (opcao) {
                case 0:
                    break;
                case 1:
                    addVenda();
                    break;
                case 2:
                    removeVenda();
                    break;
                case 3:
                    exibirVendasDeUmCliente();
                    break;
                case 4:
                    exibirVendas();
                    break;
                case 5:
                    totalVendasProduto();
                    break;
                case 6:
                    totalizarVendas();
                    break;
                default:
                    System.out.println("\nOPCAO INVALIDA\n");
            }
        } while (opcao != 0);
    }
}
