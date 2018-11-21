
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db_Connection {    
    private static String str_conection = "jdbc:sqlserver://localhost\\IGORMARTINS-PC\\SQLSERVER:1433;databaseName=db_teste;user=sa;password=123456"; 
    public static String Status;
   
    public static Connection getDB_Connection() throws SQLException, ClassNotFoundException{  
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");     
        try {                      
            Connection connection =  DriverManager.getConnection(str_conection);
            Status = "Conexao estabalecida com Sucesso!";
            // return "Sucesso!";
            return connection;
        } catch (SQLException erro){
            Status = "Erro conexão banco de dados";
            return null;
        }
    }
    public static void Close_Connection (Connection conexao) throws SQLException {
        conexao.close();
    }
   
}
