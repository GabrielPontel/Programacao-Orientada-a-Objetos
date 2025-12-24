/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleDAO;

import java.sql.PreparedStatement;
import modelo.Produto;
import java.sql.Connection;
import java.sql.SQLException;
import modelo.exceptions.NotExistException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Lance;
import modelo.exceptions.NotFoundException;
/**
 *
 * @author gabriel
 */
public class ControleProdutoLance {
    
    public void inserirProduto(Produto p) throws SQLException{
        
        Connection conexao=GerenteConexao.getConexao();
        
        String comandoSQL = "INSERT INTO produto (codigo, valor_atual, descricao) VALUES ( ? , ? , ? );";
        
        PreparedStatement execSQL;
        
        execSQL = conexao.prepareStatement(comandoSQL);
        
        execSQL.setInt(1, p.getCodigo());
        execSQL.setDouble(2, p.getValorAtual());
        execSQL.setString(3, p.getDescricao());
        
        execSQL.executeUpdate();
        
        conexao.commit();
        
        execSQL.close();
        execSQL.close();
    }
    
    public void alterarProduto(Produto p) throws SQLException, NotExistException{
        
        Connection conexao = GerenteConexao.getConexao();
        
        String comandoSQL = "UPDATE produto SET valor_atual = ? , descricao = ? WHERE codigo = ?;";
        
        PreparedStatement execSQL;
        
        execSQL = conexao.prepareStatement(comandoSQL);
        
        execSQL.setDouble(1, p.getValorAtual());
        execSQL.setString(2, p.getDescricao());
        execSQL.setInt(3, p.getCodigo());
        
        int linha = execSQL.executeUpdate();
        
        conexao.commit();
        
        execSQL.close();
        conexao.close();
        
        if(linha != 1){
            throw new NotExistException("Não existe o esse produto no banco");
        }
    }
    
    public void excluirProduto(int codigo) throws SQLException, NotExistException, NotFoundException{
        List<Lance> lista = getTodosLancesDeUmProduto(codigo);
        if(!lista.isEmpty()){
            throw new NotFoundException("Erro - esse produto ja possui lance");
        }
        Connection conexao = GerenteConexao.getConexao();
        
        String comandoSQL = "DELETE FROM produto WHERE codigo = ? ;";
        
        PreparedStatement execSQL;
        execSQL = conexao.prepareStatement(comandoSQL);
        
        execSQL.setInt(1, codigo);
        
        int linha = execSQL.executeUpdate();
        
        conexao.commit();
        
        execSQL.close();
        conexao.close();
        
        if(linha != 1){
          throw new NotExistException("Não contem produto com esse codigo no banco");
        }
        
    }
    
    public Produto pesquisarProduto(int codigo) throws SQLException, NotExistException{
        
        Produto p=null;
        
        Connection conexao = GerenteConexao.getConexao();
        
        String comandoSQL = "SELECT * FROM produto WHERE codigo = ? ;";
        
        PreparedStatement execSQL;
        
        execSQL = conexao.prepareStatement(comandoSQL);
        
        execSQL.setInt(1, codigo);
        
        ResultSet consulta;
        
        consulta = execSQL.executeQuery();
        
        consulta.last();
        
        if(consulta.getRow() > 0){
            p = new Produto();
            p.setCodigo(codigo);
            p.setDescricao(consulta.getString("descricao"));
            p.setValorAtual(consulta.getDouble("valor_atual"));
        
        }
        else
        {
            throw new NotExistException("Produto não foi encontrado");
        }
        execSQL.close();
        conexao.close();
        return p;
    }  
    
    
    public Produto pesquisar(int cod) throws SQLException, NotExistException
    {
        // curso a ser retornado
        Produto p = null;
        
        // pega uma conexao
        Connection conexao = GerenteConexao.getConexao();

        // criar a string contendo o SQL
        String comandoSQL = "SELECT * FROM produto WHERE codigo = ?";
        
        // Preparar a string para execução do SQL
        PreparedStatement execSQL;
     
        // Preparar a string para execução do SQL
        execSQL = conexao.prepareStatement(comandoSQL);
            
        // passar os parametros para o SQL
        execSQL.setInt(1, cod);
        
        // Objeto para armazenar o resuldado de uma consulta SQL
        ResultSet resultadoConsulta;
        
        // executa a consulta
        resultadoConsulta = execSQL.executeQuery();
        
//        resultadoConsulta.first();
//        resultadoConsulta.next();

        // avança para a última linha
        
        // Pega o número da última linha (para esse caso)
        if (resultadoConsulta.next())
        {
                p = new Produto();
                p.setCodigo(resultadoConsulta.getInt("codigo"));
                p.setValorAtual(resultadoConsulta.getDouble("valor_atual"));
                p.setDescricao(resultadoConsulta.getString("descricao"));
        }
        else
        {
            throw new NotExistException("Curso não foi encontrado");
        }
        
        //finaliza a execução do SQL
        execSQL.close();
            
        // finaliza a conexão com o banco de dados
        conexao.close();                   
        
        return p;
    }
    
    public List<Produto> getTodosProdutos() throws SQLException{
        
        List<Produto> lista = new ArrayList<>();
        
        Connection conexao = GerenteConexao.getConexao();
        
        String comandoSQL = "SELECT * FROM produto;";
        
        PreparedStatement execSQL;
        
        execSQL = conexao.prepareStatement(comandoSQL);
        
        ResultSet consulta;
        
        consulta = execSQL.executeQuery();
        

        Produto p;
        
        while(consulta.next()){
            p = new Produto();
            p.setCodigo(consulta.getInt("codigo"));
            p.setDescricao(consulta.getString("descricao"));
            p.setValorAtual(consulta.getDouble("valor_atual"));
            lista.add(p);
        }
        execSQL.close();
        conexao.close();
        return lista;
    }
    
    public List<Lance> getTodosLancesDeUmProduto(int codigo) throws SQLException{
        
        List<Lance> lista = new ArrayList<>();
        
        Connection conexao = GerenteConexao.getConexao();
        
        String comandoSQL = "SELECT * FROM lance WHERE codigo_produto = ? ;";
        
        PreparedStatement execSQL;
        
        execSQL = conexao.prepareStatement(comandoSQL);
        
        execSQL.setInt(1, codigo);
        
        ResultSet consulta;
        
        consulta = execSQL.executeQuery();
        
     
        Lance l;
        while(consulta.next()){
            l = new Lance();
            l.setCodigoProduto(codigo);
            l.setValorLance(consulta.getDouble("valor_lance"));
            l.setNome(consulta.getString("nome"));
            l.setTelefone(consulta.getString("telefone"));
            l.setNumLance(consulta.getInt("num_lance"));
            lista.add(l);
        }
        
        execSQL.close();
        conexao.close();
        
        return lista;
    }
    
    public void incluirLance(Lance l) throws SQLException{
        
        Connection conexao = GerenteConexao.getConexao();
        
        String comandoSQL = "INSERT INTO lance (codigo_produto, valor_lance, nome, num_lance, telefone) VALUES (? , ? , ? , ? , ?);";
        
        PreparedStatement execSQL;        

        execSQL = conexao.prepareStatement(comandoSQL);
        
        execSQL.setInt(1, l.getCodigoProduto());
        execSQL.setDouble(2, l.getValorLance());
        execSQL.setString(3, l.getNome());
        execSQL.setInt(4, l.getNumLance());
        execSQL.setString(5, l.getTelefone());
        
        execSQL.executeUpdate();
        
        conexao.commit();
        
        execSQL.close();
        conexao.close();
    }
    
    public Lance pesquisarLance(Produto p)throws SQLException, NotExistException{
        
        Lance l = null;
        
        Connection conexao = GerenteConexao.getConexao();
        
        String comandoSQL = "SELECT * FROM lance WHERE codigo_produto = ? AND valor_lance = ?;";
        
        PreparedStatement execSQL;
        
        execSQL = conexao.prepareStatement(comandoSQL);
        
        execSQL.setInt(1, p.getCodigo());
        execSQL.setDouble(2, p.getValorAtual());
        
        ResultSet consulta;
        
        consulta = execSQL.executeQuery();
        
        if(consulta.next()){
            l = new Lance();
            l.setCodigoProduto(p.getCodigo());
            l.setValorLance(p.getValorAtual());
            l.setNome(consulta.getString("nome"));
            l.setTelefone(consulta.getString("telefone"));
            l.setNumLance(consulta.getInt("num_lance"));
        }
        else
        {
            throw new NotExistException("Lance não foi encontrado");
        }
        
        execSQL.close();
        conexao.close();
        return l;
    }
    
    public void darLance(Lance l) throws SQLException, NotExistException{
        
        
        System.out.println("0");
        Produto p = pesquisar(l.getCodigoProduto());
        System.out.println("1");
        if(p.getValorAtual() < l.getValorLance()){
            System.out.println("2");
            List<Lance> lista = getTodosLancesDeUmProduto(p.getCodigo());
            System.out.println("3");
            if(lista.isEmpty()){
                l.setNumLance(1);
            }
            else{
                Lance ultimo = pesquisarLance(p);
                l.setNumLance(ultimo.getNumLance()+1);
            }
            incluirLance(l);
            p.setValorAtual(l.getValorLance());
            alterarProduto(p);
        }
        else{
            System.out.println("NAO FOI POSSIVEL");
        }
    }
}