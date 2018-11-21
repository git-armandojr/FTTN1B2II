
package DAO;

import DTO.Usuario_dto;
import Interfaces.IGeneric_Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Usuario_DAO implements IGeneric_Dao{
    @Override
    public List<Usuario_dto> Select() {
        List<Usuario_dto> lista_usuarios = new ArrayList<>();
        PreparedStatement select = null;
        ResultSet rs = null;
        Connection connection = null;
        try {
            connection = Db_Connection.getDB_Connection();
            select = connection.prepareStatement("select * from usuarios");
            rs = select.executeQuery();
            
            while(rs.next()){
                Usuario_dto usuario = new Usuario_dto();
                usuario.setUsuario_codigo(rs.getInt(1));//código
                usuario.setUsuario_nome(rs.getString(2));//nome
                usuario.setUsuario_tipo(rs.getString(3));//tipo
                usuario.setUsuario_credencial(rs.getString(4));//credencial
                usuario.setUsuario_senha(rs.getString(5));
                usuario.setUsuario_email(rs.getString(6));             
                lista_usuarios.add(usuario);
            }
            return lista_usuarios;
        } catch (ClassNotFoundException | SQLException erro){
            System.out.println(erro.getMessage());
            return null;
        }  
        finally {
            try {
                Db_Connection.Close_Connection(connection);
            } catch (SQLException ex) {
                Logger.getLogger(Usuario_DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    @Override
    public Usuario_dto Buscar(int codigo) {
        PreparedStatement select = null;
        ResultSet rs = null;
        Connection connection = null;
        try {
            connection = Db_Connection.getDB_Connection();
            select = connection.prepareStatement("select * from usuarios where usuario_codigo ="+codigo);
            rs = select.executeQuery();
            Usuario_dto usuario = new Usuario_dto();
            while(rs.next()){
                usuario.setUsuario_codigo(rs.getInt(1));//código
                usuario.setUsuario_nome(rs.getString(2));//nome
                usuario.setUsuario_tipo(rs.getString(3));//tipo
                usuario.setUsuario_credencial(rs.getString(4));//credencial
                usuario.setUsuario_senha(rs.getString(5));//Senha
                usuario.setUsuario_email(rs.getString(6));//email             
            }
            return usuario;
        } catch (ClassNotFoundException | SQLException erro){
            System.out.println(erro.getMessage());
            return null;
        }  
        finally {
            try {
                Db_Connection.Close_Connection(connection);
            } catch (SQLException ex) {
                Logger.getLogger(Usuario_DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @Override
    public String Update(Usuario_dto usuario){
        Connection connection = null;      
        String select = 
        "update usuarios set usuario_nome ='"+usuario.getUsuario_nome()
        +"', usuario_tipo ='"+usuario.getUsuario_tipo()
        +"', usuario_credencial ='"+usuario.getUsuario_credencial()
        +"', usuario_senha ='"+usuario.getUsuario_senha()
        +"', usuario_email = '"+usuario.getUsuario_email()
        +"' where usuario_codigo ="+usuario.getUsuario_codigo();
        
        try {                      
        connection = Db_Connection.getDB_Connection();
        connection.prepareStatement(select).executeUpdate();        
        return "Update Realizado com Sucesso!";
            
        } catch (ClassNotFoundException | SQLException erro){
            System.out.println(erro.getMessage());
            return null;
        }  
        finally {
            try {
                Db_Connection.Close_Connection(connection);
            } catch (SQLException ex) {
               Logger.getLogger(Usuario_DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @Override
    public String Delete(int codigo){
        PreparedStatement select = null;        
        Connection connection = null;
        try {
            connection = Db_Connection.getDB_Connection();
            select = connection.prepareStatement("delete from usuarios where usuario_codigo ="+codigo);
            select.executeUpdate();
            return "Deletado com sucesso!";
        } catch (ClassNotFoundException | SQLException erro){
            System.out.println(erro.getMessage());
            return "Erro ao deletar usuário!";
        }  
        finally {
            try {
                Db_Connection.Close_Connection(connection);
            } catch (SQLException ex) {
                Logger.getLogger(Usuario_DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @Override
    public String Insert(Usuario_dto usuario){
        Connection connection = null;   
        String select = "select usuario_codigo from usuarios where usuario_codigo="+usuario.getUsuario_codigo();       
        try {
        connection = Db_Connection.getDB_Connection();
        ResultSet data = connection.prepareStatement(select).executeQuery();
        // Verifica se usuário já     
        if (data == null) {      
            select =         
            "insert into usuarios values ("
            +usuario.getUsuario_codigo()
            +",'"+usuario.getUsuario_nome()+"'"
            +",'"+usuario.getUsuario_tipo()+"'"
            +",'"+usuario.getUsuario_credencial()+"'"
            +",'"+usuario.getUsuario_senha()+"'"
            +",'"+usuario.getUsuario_email()+"')";
                          
        connection.prepareStatement(select).executeUpdate();        
        return "Insert Realizado com Sucesso!";
        }
        else{
            return "Usuário já cadastrado no banco!";
        }
        } catch (ClassNotFoundException | SQLException erro){
            System.out.println(erro.getMessage());
            return "Erro ao inserir usuário!";
        }  
        finally {
            try {
                Db_Connection.Close_Connection(connection);
            } catch (SQLException ex) {
               Logger.getLogger(Usuario_DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}

   //private 



