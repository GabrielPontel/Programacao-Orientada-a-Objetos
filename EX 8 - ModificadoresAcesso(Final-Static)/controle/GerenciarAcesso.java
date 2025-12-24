package controle;

import java.util.ArrayList;
import modelo.Pessoa;

public class GerenciarAcesso {
      ArrayList<Pessoa> lista = new ArrayList<>();
      
      public ArrayList<Pessoa> getLista(){
          return lista;
      }
      
      public void adicionar(Pessoa pes){
          lista.add(pes);   
      }
      
      public Pessoa buscar(String nome){
          Pessoa buscada = null;
          for(Pessoa p : lista){
              if(p.getNome().equals(nome)){
                  buscada = p;
              }
          }
          return buscada;
      }
      
      public void remover(Pessoa p){
          lista.remove(lista.indexOf(p));
      }
}
