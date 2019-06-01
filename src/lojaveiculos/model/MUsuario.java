/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojaveiculos.model;

/**
 *
 * @author gabriel
 */
public class MUsuario {
    private String usuario;
    private String senha;
    private String nomeUsuario;

    public MUsuario(String usuario, String senha, String nomeUsuario) {
        this.usuario = usuario;
        this.senha = senha;
        this.nomeUsuario = nomeUsuario;
    }   
    
       public MUsuario(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
       
    }  
    
    
    
    /**
     * @return the login
     */
    public String getUsuario() {
        return usuario;
    }

  
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the nomeUsuario
     */
    public String getNomeUsuario() {
        return nomeUsuario;
    }

    /**
     * @param nomeUsuario the nomeUsuario to set
     */
    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }
}
