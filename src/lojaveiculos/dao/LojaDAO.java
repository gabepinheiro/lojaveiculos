/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojaveiculos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import lojaveiculos.model.MLoja;

/**
 *
 * @author gabriel
 */
public class LojaDAO {
    
    private Connection connection;
    
    public LojaDAO() {
         this.connection = new Conexao().getConnection();
    }
    
    public ArrayList<MLoja> buscarLojas(){
            ArrayList<MLoja> lojas = new ArrayList<>();
            
             PreparedStatement stmt = null;
             ResultSet rs = null;

        try {
            stmt = connection.prepareStatement("SELECT * FROM tblLoja");
            rs = stmt.executeQuery();

            while (rs.next()) {

                MLoja l = new MLoja();

                l.setIdLoja(rs.getString("idLoja"));
                l.setNomeLoja(rs.getString("nomeLoja"));
                lojas.add(l);
            }
            stmt.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar Lojas: " + ex);
        } finally {
            try {
                connection.close();
                System.out.println("Desconectou");
            } catch (SQLException ex) {
                Logger.getLogger(MarcaModeloDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
            return lojas;
    
    }
    
}
