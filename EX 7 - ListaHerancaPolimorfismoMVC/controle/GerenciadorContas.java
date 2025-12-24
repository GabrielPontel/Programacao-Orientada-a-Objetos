package controle;

import java.util.ArrayList;
import modelo.ContaAluno;
import modelo.ContaProfessor;

public class GerenciadorContas {

    private ArrayList<ContaAluno> contas = new ArrayList<>();

    public GerenciadorContas() {
    }

    public ArrayList<ContaAluno> getContas() {
        return contas;
    }

    public void setContas(ArrayList<ContaAluno> contas) {
        this.contas = contas;
    }
    
    public void adicionarConta(ContaAluno conta){
        contas.add(conta);
    }
    
    public ContaAluno buscarContaAluno(int numeroConta){
        for(ContaAluno conta: contas){
            if(numeroConta==conta.getNumeroConta())
                if(!(conta instanceof ContaProfessor))
                    return conta; 
        }
        return null;
    }
    
    public ContaAluno buscarContaProfessor(int numeroConta){
        for(ContaAluno conta: contas){
            if(numeroConta==conta.getNumeroConta())
                if(conta instanceof ContaProfessor)
                    return conta; 
        }
        return null;
    }
    
    public ContaAluno buscarConta(int numeroConta){
        for(ContaAluno conta: contas){
            if(numeroConta==conta.getNumeroConta())
                return conta; 
        }
        return null;
    }
 
}
