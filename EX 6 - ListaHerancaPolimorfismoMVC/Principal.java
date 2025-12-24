/*
    Gabriel Pontel de Mori - 2025

 Implemente o diagrama abaixo, utilizando a linguagem de programação Java. O 
cálculo do imposto da renda fixa é 1,5% sobre o valor e o imposto da renda 
variável é um valor fixo de R$ 12,50. Crie um programa, utilizando os conceitos 
de orientação a objetos, para controlar os investimentos. A classe principal 
deve ter os seguintes métodos:
    - adicionarPoupanca: deve adicionar um investimeto do tipo poupança.
    - adicionarRendaFixa: deve adicionar um investimeto do tipo renda fixa.
    - adicionarRendaVariavel: deve adicionar um investimeto do tipo renda 
variável.
    - exibirInvestimentos: deve listar todos os investimentos.
    - exibirImpostos: deve apresentar os impostos de todos os investimentos 
que possuem impostos.
 É permitido criar métodos e atributos que sejam importantes para a resolução 
do exercício.
 Não é obrigatório utilizar a classe Scanner para ler as informações. As 
infomações podem ser estáticas
*/
import controle.GerenciadorInvestimento;
import modelo.Investimento;
import modelo.Poupanca;
import modelo.RendaFixa;
import modelo.RendaVariavel;

public class Principal {

    private GerenciadorInvestimento controle = new GerenciadorInvestimento();

    public static void main(String[] args) {
          Principal tela = new Principal();
          tela.adicionarPoupanca(1);
          tela.adicionarRendaFixa(2);
          tela.adicionarRendaFixa(1000);
          tela.adicionarRendaFixa(100);
          tela.adicionarRendaVariavel(3);
          tela.adicionarRendaVariavel(1000);
          tela.adicionarRendaVariavel(200);
          
          tela.exibirImpostos();
          tela.exibirInvestimentos();
    }
    
    public void adicionarPoupanca(double valor){
        controle.addInvestimento(new Poupanca(valor));
    }
    
    public void adicionarRendaFixa(double valor){
        controle.addInvestimento(new RendaFixa(valor));
    }
    
    public void adicionarRendaVariavel(double valor){
        controle.addInvestimento(new RendaVariavel(valor));
    }
    
    public void exibirInvestimentos(){
        for(Investimento investimento: controle.getInvestimentos()){
            System.out.println("VALOR INVESTIMENTO: "+ investimento.getValor());
        }
    }
    
    public void exibirImpostos(){
        for(Investimento invest: controle.getInvestimentos()){
            if(invest instanceof RendaFixa){
                RendaFixa rendaFixa = (RendaFixa) invest;
                System.out.println("O IMPOSTO DESSA RENDA FIXA: "+ rendaFixa.calcularImposto());
            }else if(invest instanceof RendaVariavel){
                RendaVariavel rendaVariavel = (RendaVariavel) invest;
                System.out.println("O IMPOSTO DESSA RENDA FIXA: "+ rendaVariavel.calcularImposto());
            }     
        }
    }
}
