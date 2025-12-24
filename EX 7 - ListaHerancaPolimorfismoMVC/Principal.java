
import controle.GerenciadorContas;
import modelo.ContaAluno;
import modelo.ContaProfessor;
import modelo.SaqueInvalidoException;
import modelo.ValorNegativoException;

public class Principal {

    private GerenciadorContas controle = new GerenciadorContas();

    public static void main(String[] args) {
        Principal tela = new Principal();
        tela.adicionarContaAluno();
        tela.adicionarContaAluno();
        tela.adicionarContaProfessor("D1");
        tela.depositar(0, 100);
        tela.depositar(1, 100);
        tela.sacarContaAluno(1, 10);
        tela.exibirContaAlunos();
        tela.exibirContaProfessor();
    }

    public void adicionarContaAluno() {
        controle.adicionarConta(new ContaAluno());
        System.out.println("CONTA ADICIONADA COM SUCESSO");
    }
   
    public void adicionarContaProfessor(String nivel) {
        if (nivel.equals("D1") || nivel.equals("D2") || nivel.equals("D3") || nivel.equals("D4")) {
            controle.adicionarConta(new ContaProfessor(nivel));
            System.out.println("CONTA ADICIONADA COM SUCESSO");
        } else {
            System.out.println("NAO FOI POSSIVEL ADICIONAR ESSA CONTA");
        }
    }

   public void depositar(int numeroConta, double deposito) {
        boolean verificar = false;
        ContaAluno contaSaque;
        contaSaque = controle.buscarConta(numeroConta);
        if (contaSaque != null) {
            try {
                
                contaSaque.depositar(deposito);
                verificar = true;
                
            } catch (ValorNegativoException e) {
                System.out.println(e.getMessage());
            }
            if (verificar) {
                System.out.println("DEPOSITO FEITO COM SUCESSO!!");
            } else {
                System.out.println("PORTANTO, NAO FOI POSSIVEL REALIZAR ESSE DEPOSITO");
            }

        } else {
            System.out.println("ESSE NUMERO DE CONTA NAO EXISTE");
        }

    }
    
    public void sacarContaAluno(int numeroConta, double saque) {
        boolean verificar = false;
        ContaAluno contaSaque;
        contaSaque = controle.buscarContaAluno(numeroConta);
        if (contaSaque != null) {
            try {
                
                contaSaque.sacar(saque);
                verificar = true;
                
            } catch (ValorNegativoException | SaqueInvalidoException e) {
                System.out.println(e.getMessage());
            }
            if (verificar) {
                System.out.println("SAQUE FEITO COM SUCESSO!!");
            } else {
                System.out.println("PORTANTO, NAO FOI POSSIVEL REALIZAR ESSE SAQUE");
            }

        } else {
            System.out.println("ESSE NUMERO DE CONTA NAO EXISTE");
        }

    }

    public void sacarContaProfessor(int numeroConta, double saque) {
        boolean verificar = false;
        ContaAluno contaSaque;
        contaSaque = controle.buscarContaProfessor(numeroConta);
        if (contaSaque != null) {
            ContaProfessor contaSaqueProfessor = (ContaProfessor) contaSaque;
            try {
                contaSaqueProfessor.sacar(saque);
                verificar = true;
                
            } catch (ValorNegativoException | SaqueInvalidoException e) {
                System.out.println(e.getMessage());
            }
            if (verificar) {
                System.out.println("SAQUE FEITO COM SUCESSO!!");
            } else {
                System.out.println("PORTANTO, NAO FOI POSSIVEL REALIZAR ESSE SAQUE");
            }

        } else {
            System.out.println("ESSE NUMERO DE CONTA NAO EXISTE OU NAO E PROFESSOR");
        }

    }
    
    public void exibirContaAlunos(){
        for(ContaAluno conta: controle.getContas()){
            if(!(conta instanceof ContaProfessor)){
                System.out.println("\nNUMERO DA CONTA: "+conta.getNumeroConta());
                System.out.println("SALDO: "+conta.getSaldo());
            }
        }
    }
    
    public void exibirContaProfessor(){
        for(ContaAluno conta: controle.getContas()){
            if((conta instanceof ContaProfessor)){
                ContaProfessor contaProfessor = (ContaProfessor) conta; 
                System.out.println("\nNUMERO DA CONTA: "+contaProfessor.getNumeroConta());
                System.out.println("SALDO: "+contaProfessor.getSaldo());
                System.out.println("NIVEL: "+contaProfessor.getNivel());
                System.out.println("LIMITE: "+contaProfessor.getLimite());
            }
        }
    }
}

