/*
    Gabriel Pontel de Mori - 2025

    Programa desenvolvido para aprender um pouco mais sobre o Static e final
*/
import visao.ApresentarPessoas;

public class Principal {

    public static void main(String[] args) {
        ApresentarPessoas tela = new ApresentarPessoas();
        Integer opcao;
        do {
            opcao = tela.menu();
            switch (opcao) {
                case null:
                    tela.escolheuNaoInteiro();
                    break;
                case 0:
                    System.out.println("ENCERRANDO...");
                    break;
                case 1:
                    tela.adicionarLista();
                    break;
                case 2:
                    tela.removerLista();
                    break;
                case 3:
                    tela.exibirPessoas();
                    break;
                default:
                    tela.escolherOpcaoInvalida();
            }
        } while (opcao != 0);
    }
}
