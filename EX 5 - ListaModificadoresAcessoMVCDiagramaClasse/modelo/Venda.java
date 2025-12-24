package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Venda {
    private Date data;
    private double total;
    private String formaPagto;
    private Cliente cliente;
    private List<ItemVenda> itens = new ArrayList<>();

    public Venda() {
        this.total = 0;
    }

    public Venda(Date data, double total, String formaPagto, Cliente cliente) {
        this.data = data;
        this.total = total;
        this.formaPagto = formaPagto;
        this.cliente = cliente;
    }

    public Date getData() {
        return data;
    }

    public double getTotal() {
        return total;
    }

    public String getFormaPagto() {
        return formaPagto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setFormaPagto(String formaPagto) {
        this.formaPagto = formaPagto;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setItens(List<ItemVenda> itens) {
        for(ItemVenda i: itens){
            total+=i.getValorUnitario();
        }
        this.itens = itens;
    }

    public void addItem(int quant,Produto produto){
        ItemVenda item = new ItemVenda(quant, produto);
        itens.add(item);
        total+=item.getValorUnitario();
    }
    
    @Override
    public String toString() {
        return "Venda{" + "data=" + data + ", total=" + total + ", formaPagto=" + formaPagto + ", cliente=" + cliente +'}';
    }
}
