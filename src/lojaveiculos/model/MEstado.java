package lojaveiculos.model;


public class MEstado {
    
    private String sigla;
    private String estado;
    
    public MEstado() {
        
    }

    public MEstado(String sigla, String estado) {
        this.sigla = sigla;
        this.estado = estado;
    }
  
    public String getSigla() {
        return sigla;
    }

    /**
     * @param sigla the sigla to set
     */
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void getSigla(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
