package controleDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class GerenteConexao {
    
    private static String url = "jdbc:mysql://localhost:3306/banco?useSSL=false";

    
    public static Connection  getConexao() {
            Connection conexao=null;
            
        try {
            conexao = DriverManager.getConnection(url,"root","0603");
            conexao.setAutoCommit(false);
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar-se com o banco");
            System.getLogger(GerenteConexao.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            System.exit(0);
        }
        return conexao;
    }
            
}
    

