/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojaveiculos.model;

/**
 *
 * @author logon
 */
public class MMarcaModelo {
    private int codigo;
    private String nomeMarca;
    private String nomeModelo;

    public MMarcaModelo() {
    }

    public MMarcaModelo(int codigo, String nomeMarca, String nomeModelo) {
        this.codigo = codigo;
        this.nomeMarca = nomeMarca;
        this.nomeModelo = nomeModelo;
    }

    
    
    
    /**
     * @return the nomeModelo
     */
    public String getNomeModelo() {
        return nomeModelo;
    }

    /**
     * @param nomeModelo the nomeModelo to set
     */
    public void setNomeModelo(String nomeModelo) {
        this.nomeModelo = nomeModelo;
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nomeMarca
     */
    public String getNomeMarca() {
        return nomeMarca;
    }

    /**
     * @param nomeMarca the nomeMarca to set
     */
    public void setNomeMarca(String nomeMarca) {
        this.nomeMarca = nomeMarca;
    }
    
    
}
