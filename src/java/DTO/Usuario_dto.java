/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

public class Usuario_dto {

    public int getUsuario_codigo() {
        return usuario_codigo;
    }

    public void setUsuario_codigo(int usuario_codigo) {
        this.usuario_codigo = usuario_codigo;
    }

    public String getUsuario_nome() {
        return usuario_nome;
    }

    public void setUsuario_nome(String usuario_nome) {
        this.usuario_nome = usuario_nome;
    }

    public String getUsuario_tipo() {
        return usuario_tipo;
    }

    public void setUsuario_tipo(String usuario_tipo) {
        this.usuario_tipo = usuario_tipo;
    }

    public String getUsuario_credencial() {
        return usuario_credencial;
    }

    public void setUsuario_credencial(String usuario_credencial) {
        this.usuario_credencial = usuario_credencial;
    }

    public String getUsuario_senha() {
        return usuario_senha;
    }

    public void setUsuario_senha(String usuario_senha) {
        this.usuario_senha = usuario_senha;
    }
        public String getUsuario_email() {
        return usuario_email;
    }
    public void setUsuario_email(String usuario_email) {
        this.usuario_email= usuario_email;
    }
    private int usuario_codigo;
    private String usuario_nome;
    private String usuario_tipo;
    private String usuario_credencial;
    private String usuario_senha;
    private String usuario_email;
    
}
