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

import javax.swing.JOptionPane;
import lojaveiculos.model.MMarcaModelo;

/**
 *
 * @author logon
 */
public class MarcaModeloDAO {

    private Connection connection;

    public MarcaModeloDAO() {
        this.connection = new Conexao().getConnection();
    }

    public ArrayList buscarMarcas() {

        ArrayList marcas =  new ArrayList();

        String sql = "select distinct nomeMarca from tblMarcaModelo";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);

            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                String marca = rs.getString("nomeMarca");
              
                marcas.add(marca);

            }
            stm.close();
            rs.close();

        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao mostrar: " + ex.toString());
        } finally {
            try {
                connection.close();
                System.out.println("Desconectou");
            } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro: "+ex.toString());
            }

        }
        return marcas;
    }

    public ArrayList buscarModelos(String marca) {
       
        ArrayList modelos = new ArrayList();
        String sql = "";

        if ("".equals(sql)) {
            sql += "select * from tblMarcaModelo  where nomeMarca = '" + marca + "'";
        } else {
            sql += "select * from tblMarcaModelo";
        }

        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                modelos.add(rs.getString("nomeModelo"));
               

            }
            stm.close();
            rs.close();

        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao consultar: " + ex.toString());
        } finally {
            try {
                connection.close();
                System.out.println("Desconectou");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro: "+ex.toString());
            }
        }
        
    
        return modelos;
        
        
    }

    public void Inserir(int cod, String marca, String modelo) {

        PreparedStatement stmt = null;
        String sql = "INSERT INTO tblMarcaModelo(codMarcaModelo, nomeMarca, nomeModelo)VALUES(?,?,?)";

        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, cod);
            stmt.setString(2, marca);
            stmt.setString(3, modelo);

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");

            stmt.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: Marca e Modelo já cadastrado.");
        } finally {
            try {
                connection.close();
                System.out.println("Desconectou");
            } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null, "Erro: "+ex.toString());
            }
        }
    }

    public void Eliminar(MMarcaModelo mm) {

        PreparedStatement stmt = null;
        String sql = "DELETE FROM tblMarcaModelo where codMarcaModelo = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, mm.getCodigo());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Eliminado com sucesso!");

            stmt.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Eliminar: "+ ex);
        } finally {
            try {
                connection.close();
                System.out.println("Desconectou");
            } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null, "Erro: "+ex.toString());
            }
        }
    }


public ArrayList<MMarcaModelo> buscarMarcasAndModelos() {

        ArrayList<MMarcaModelo> marcasmodelos = new ArrayList<>();

        String sql = "select * from tblMarcaModelo";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);

            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                MMarcaModelo mm = new MMarcaModelo();
                mm.setCodigo(rs.getInt("codMarcaModelo"));
                mm.setNomeMarca(rs.getString("nomeMarca"));
                mm.setNomeModelo(rs.getString("nomeModelo"));

                marcasmodelos.add(mm);

            }

            stm.close();
            rs.close();

        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Erro: "+ex.toString());
        } finally {
            try {
                connection.close();
                System.out.println("Desconectou");
            

} catch (SQLException ex) {
               JOptionPane.showMessageDialog(null, "Erro: "+ex.toString());
            }

        }
        return marcasmodelos;
    }

    public MMarcaModelo buscarMarcasAndModelosPeloCod(int cod) {

        MMarcaModelo mm = new MMarcaModelo();

        String sql = "select * from tblMarcaModelo where codMarcaModelo = ?";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, cod);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                mm.setCodigo(rs.getInt("codMarcaModelo"));
                mm.setNomeMarca(rs.getString("nomeMarca"));
                mm.setNomeModelo(rs.getString("nomeModelo"));

            }

            stm.close();
            rs.close();

        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Erro: "+ex.toString());
        } finally {
            try {
                connection.close();
                System.out.println("Desconectou");
            

} catch (SQLException ex) {
               JOptionPane.showMessageDialog(null, "Erro: "+ex.toString());
            }
        }
        return mm;
    }

    public void Alterar(MMarcaModelo marcamodelo) {

        PreparedStatement stmt = null;
        String sql = "UPDATE tblMarcaModelo set nomeMarca = ?, nomeModelo = ? where codMarcaModelo = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(3, marcamodelo.getCodigo());
            stmt.setString(1, marcamodelo.getNomeMarca());
            stmt.setString(2, marcamodelo.getNomeModelo());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");

            stmt.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar: " + ex);
        } finally {
            try {
                connection.close();
                System.out.println("Desconectou");
            

} catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro: "+ex.toString());
            }
        }
    }

}
