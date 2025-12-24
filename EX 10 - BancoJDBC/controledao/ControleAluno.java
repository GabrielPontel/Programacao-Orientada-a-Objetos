package controledao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Aluno;
import modelo.Curso;
import modelo.exceptions.NotExistException;

public class ControleAluno {
    
    public void incluir(Aluno a) throws SQLException, NotExistException{
        ControleCurso controle = new ControleCurso();
        Curso c = controle.pesquisar(a.getSiglaCurso());
        if(c==null){
            throw new NotExistException("Não foi possivel inserir, pois não existe esse curso no banco!!");
        }
            
        
        //Criou conexao com o banco
        Connection conexao = GerenteConexao.getConexao();
        
        //Fez a string com os comandos
        String comandoSQL = "INSERT INTO aluno (pront, nome, ano_ingresso, sigla_curso) VALUES ( ? , ? , ? , ? );";
        PreparedStatement execSQL;
        
        //A preparou para ficar executavel
        execSQL = conexao.prepareStatement(comandoSQL);
        
        //Mandando os parametros
        execSQL.setString(1, a.getPront());
        execSQL.setString(2, a.getNome());
        execSQL.setInt(3, a.getAnoIngresso());
        execSQL.setString(4, a.getSiglaCurso());
        
        //Mude os dados no banco
        execSQL.executeUpdate();
        
        //Realmente faca tudo de uma vez
        conexao.commit();
        
        //Encerando conexao 
        execSQL.close();
        
        conexao.close();
        
    }
    
    public void alterar(Aluno a) throws SQLException, NotExistException
    {
        //Fazer conexao com o banco
        Connection conexao = GerenteConexao.getConexao();
        
        //Escrever comando
        String comandoSQL = "UPDATE aluno SET nome = ?, ano_ingresso = ?, sigla_curso = ? WHERE pront = ?;";
        
        //Preparar o comando para poder ser executado
        PreparedStatement execSQL;
        execSQL = conexao.prepareStatement(comandoSQL);
        
        //Mandando os parametros
        execSQL.setString(1, a.getNome());
        execSQL.setInt(2, a.getAnoIngresso());
        execSQL.setString(3, a.getSiglaCurso());
        execSQL.setString(4, a.getPront());
        
        //Executa a modificação, retorna a quantidade de elementos forma modificados
        int linha = execSQL.executeUpdate();
        
        //Faz realmente o comando acontecer
        conexao.commit();
        
        //Fecha a conexao
        execSQL.close();
        conexao.close();
        
        if(linha == 0){
            throw new NotExistException("Esse prontuario nao esta no banco, por isso nao foi possivel altera-lo");
        }
    }
    
    public void excluir(String pront) throws SQLException, NotExistException{
        
        Connection conexao;
        conexao = GerenteConexao.getConexao();
        
        String comandoSQL = "DELETE FROM aluno WHERE pront = ?";
        PreparedStatement execSQL;
        execSQL = conexao.prepareStatement(comandoSQL);
        
        execSQL.setString(1, pront);
        
        int linha = execSQL.executeUpdate();
        
        conexao.commit();
        
        execSQL.close();
        conexao.close();
        
        if(linha == 0){
            throw new NotExistException("Esse prontuario nao esta no banco, por isso nao foi possivel exclui-lo");
        }
    }
    
    public Aluno pesquisa(String pront) throws SQLException, NotExistException{
        Aluno a =null;
        
        Connection conexao;
        conexao = GerenteConexao.getConexao();
        
        String comandoSQL = "SELECT * FROM aluno WHERE pront = ?;";
        
        PreparedStatement execSQL;
        execSQL = conexao.prepareStatement(comandoSQL);
        
        execSQL.setString(1, pront);
        
        ResultSet lista;
        lista = execSQL.executeQuery();
        
        
       
        
        lista.last();
        if(lista.getRow()>0){
            a = new Aluno();
            a.setPront(pront);
            a.setNome(lista.getString("nome"));
            a.setAnoIngresso(lista.getInt("ano_ingresso"));
            a.setSiglaCurso(lista.getString("sigla_curso"));
        }
        else{
            throw new NotExistException("Esse prontuario nao esta no banco");
        }
            
         execSQL.close();
        conexao.close();
        return a;
    }
    
    public List<Aluno> getTodosAlunos() throws SQLException{
        
        List<Aluno> lista = new ArrayList<>();
        
        Connection conexao = GerenteConexao.getConexao();
        
        String comando = "SELECT * FROM aluno";
        
        PreparedStatement execSQL;
        execSQL = conexao.prepareStatement(comando);
        
        ResultSet resultado;
        resultado = execSQL.executeQuery();
        
        Aluno a;
        
        while(resultado.next()){
            a = new Aluno();
            a.setNome(resultado.getString("nome"));
            a.setPront(resultado.getString("pront"));
            a.setAnoIngresso(resultado.getInt("ano_ingresso"));
            a.setSiglaCurso(resultado.getString("sigla_curso"));
            lista.add(a);
        }
        
        execSQL.close();
        conexao.close();
        
        return lista;
    }
}
