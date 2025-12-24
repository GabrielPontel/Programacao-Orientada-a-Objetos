package controle;

import controle.excecao.IdentificadorClasseExistenteException;
import controle.excecao.IdentificadorClasseInexistenteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.ItemVenda;
import modelo.Venda;

public class ControleVenda {
    private static List<Venda> vendas = new ArrayList<>();

    public ControleVenda() {
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        ControleVenda.vendas = vendas;
    }
    
    public void addVenda(Venda venda) throws IdentificadorClasseExistenteException{
        for(Venda v : vendas){
            if(v.getCliente().equals(venda.getCliente()) && v.getData().equals(venda.getData()) && v.getTotal() == venda.getTotal())
                throw new IdentificadorClasseExistenteException("COMPRA COM CLIENTE , DATA E VALOR TOTAL JA CADASTRADA NO PROGRAMA !!");
        }
        vendas.add(venda);
    }
    
    public List<Venda> getVendasCliente(String cpf){
        List<Venda> vendasCliente = new ArrayList<>();
        for(Venda v : vendas){
            if(v.getCliente().getCpf().equals(cpf))
                vendasCliente.add(v);
        }
        return vendasCliente;
    }
    
    public Integer quantVendasProduto(int codigoBarra){
        int cont = 0;
        for(Venda v : vendas){
            for(ItemVenda item: v.getItens()){
                if(item.getProduto().getCodigoBarra() == codigoBarra)
                    cont++;
            }
        }
        return cont;
    }
    
    public double totalizarVendas(){
        double valor=0;
        for(Venda v : vendas){
            valor+=v.getTotal();
        }
        return valor;
    }
    
    public List<Venda> getVendaEscolhida(List<Venda> listaCliente,Date dataEscolhida) throws IdentificadorClasseInexistenteException{
        List<Venda> escolhida= new ArrayList<>();
        for(Venda v : listaCliente){
            if(v.getData().equals(dataEscolhida)){
                escolhida.add(v);
            }
        }
        if(escolhida.size()!=0){
            return escolhida;
        }
        else {
            throw new IdentificadorClasseInexistenteException("NAO EXISTE VENDA DESSE CLIENTE NESSA DATA!!");
        }
    }
    
    public Venda getValor(List<Venda> ListaClienteData, double valor) throws IdentificadorClasseInexistenteException{
       for(Venda v : vendas){
           if(v.getTotal() == valor)
               return v;
       }
       throw new IdentificadorClasseInexistenteException("NAO EXISTE ESSE VALOR TOTAL DESSE CLIENTE NESSA DATA!!");
    }
    
    public void removeVenda(Venda venda){
        vendas.remove(venda);
    }
}
