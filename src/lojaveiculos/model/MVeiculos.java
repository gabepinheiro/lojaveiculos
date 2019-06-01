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
public class MVeiculos {
    private String placa;
    private int anoFab;
    private float preco;
    private String uf;
    private String marca;
    private String modelo;
    private String loja;

    public MVeiculos(String placa, int anoFab, float preco, String uf, String marca, String modelo, String loja) {
        this.placa = placa;
        this.anoFab = anoFab;
        this.preco = preco;
        this.uf = uf;
        this.marca = marca;
        this.modelo = modelo;
        this.loja = loja;
    }

    public MVeiculos() {
    }
    
    

    
    /**
     * @return the placa
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * @param placa the placa to set
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    /**
     * @return the anoFab
     */
    public int getAnoFab() {
        return anoFab;
    }

    /**
     * @param anoFab the anoFab to set
     */
    public void setAnoFab(int anoFab) {
        this.anoFab = anoFab;
    }

    /**
     * @return the preco
     */
    public float getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(float preco) {
        this.preco = preco;
    }

    /**
     * @return the uf
     */
    public String getUf() {
        return uf;
    }

    /**
     * @param uf the uf to set
     */
    public void setUf(String uf) {
        this.uf = uf;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the loja
     */
    public String getLoja() {
        return loja;
    }

    /**
     * @param loja the loja to set
     */
    public void setLoja(String loja) {
        this.loja = loja;
    }
}
