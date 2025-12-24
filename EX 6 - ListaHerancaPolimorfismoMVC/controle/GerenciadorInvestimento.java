/*
    Gabriel Pontel de Mori - 2025

 Desenvolva um sistema, utilizando a linguagem de programação Java, que 
represente a instituição financeira IF Invest. A instituição possui contas para 
alunos e professores. As contas devem ser armazenadas em uma lista única 
List). Todas as contas podem depositar e sacar, caso tente depositar um valor 
negativo ou sacar um valor maior do que o saldo, uma exceção deve ser 
lançada. Somente as contas dos professores possuem limite, que pode ser 
considerado como saldo da conta. Os limites podem variar de acordo com o 
nível do professor, como mostra a tabela a seguir:

    Nível     Limite
      
      D1        100
      D2        200
      D3        300
      D4        400

Implementar as classes necessárias para a resolução do enunciado, contendo 
os atributos e os métodos.
    - A classe Principal deve ter:
    - Um método para adicionar uma conta do tipo aluno.
    - Um método para adicionar uma conta do tipo professor.
    - Um método que faça o saque de uma conta do tipo aluno.
    - Um método que faça o saque de uma conta do tipo professor.
    - Um método que liste todas as contas do tipo aluno.
    - Um método que liste todas as contas do tipo professor.
*/
package controle;

import java.util.ArrayList;
import modelo.Investimento;
import modelo.RendaFixa;
import modelo.RendaVariavel;


public class GerenciadorInvestimento {
    private ArrayList<Investimento> investimentos = new ArrayList<>();

    public GerenciadorInvestimento() {
    }

    public void setInvestimentos(ArrayList<Investimento> investimentos) {
        this.investimentos = investimentos;
    }

    public ArrayList<Investimento> getInvestimentos() {
        return investimentos;
    }
    
    public void addInvestimento(Investimento investmento){
        investimentos.add(investmento);
    }
    
}
