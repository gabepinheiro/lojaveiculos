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
import lojaveiculos.model.MVeiculos;

/**
 *
 * @author logon
 */
public class VeiculoDAO {

    private Connection connection;

    public VeiculoDAO() {
        this.connection = new Conexao().getConnection();
    }

    public ArrayList<MVeiculos> buscarVeiculos(String m) {
        int qtd = 0;
        
        ArrayList<MVeiculos> veiculos = new ArrayList<>();

        String sql = " SELECT placa, anoFab, preco, uf, marca, modelo, loja FROM tblVeiculo WHERE marca = ? or modelo = ?";

        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, m);
            pstm.setString(2, m);
            rs = pstm.executeQuery();

            while (rs.next()) {

                MVeiculos veiculo = new MVeiculos();

                veiculo.setPlaca(rs.getString("placa"));
                veiculo.setAnoFab((rs.getInt("anoFab")));
                veiculo.setPreco(rs.getFloat("preco"));
                veiculo.setUf(rs.getString("uf"));
                veiculo.setMarca(rs.getString("marca"));
                veiculo.setModelo(rs.getString("modelo"));
                veiculo.setLoja(rs.getString("loja"));

                veiculos.add(veiculo);
                qtd++;

            }
            pstm.close();
            rs.close();

        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Erro: "+ex.toString());
        } finally {
            try {
                connection.close();
                System.out.println("Desconectou");
            } catch (SQLException ex) {
                Logger.getLogger(MarcaModeloDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if(qtd != 0 ){
       return veiculos;
        }else{
            JOptionPane.showMessageDialog(null, "Ainda não existem veiculos cadastrados com essa Marca ou Modelo, cadastre um!");
            return null;
        }
    }

    public ArrayList<MVeiculos> consultaPorFaixaDePreco(Float v1, Float v2) {

        ArrayList<MVeiculos> veiculos = new ArrayList<>();
        System.out.println("" + v1 + "" + v2);

        String sql = " SELECT * FROM tblVeiculo WHERE preco between ? and ?";

        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            pstm = connection.prepareStatement(sql);
            pstm.setFloat(1, v1);
            pstm.setFloat(2, v2);
            rs = pstm.executeQuery();

            while (rs.next()) {
                MVeiculos veiculo = new MVeiculos();

                veiculo.setPlaca(rs.getString("placa"));
                veiculo.setAnoFab((rs.getInt("anoFab")));
                veiculo.setPreco(rs.getFloat("preco"));
                veiculo.setUf(rs.getString("uf"));
                veiculo.setMarca(rs.getString("marca"));
                veiculo.setModelo(rs.getString("modelo"));
                veiculo.setLoja(rs.getString("loja"));

                veiculos.add(veiculo);

            }
            pstm.close();
            rs.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: "+ex.toString());
        } finally {
            try {
                connection.close();
                System.out.println("Desconectou");
            } catch (SQLException ex) {
                Logger.getLogger(MarcaModeloDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        return veiculos;
    }

    public ArrayList<MVeiculos> consultaPorPlaca(String placa) {

        ArrayList<MVeiculos> veiculos = new ArrayList<>();
        MVeiculos veiculo = new MVeiculos();
        String sql = " SELECT * FROM tblVeiculo WHERE placa = ?";

        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, placa);

            rs = pstm.executeQuery();

            while (rs.next()) {

                veiculo.setPlaca(rs.getString("placa"));
                veiculo.setAnoFab((rs.getInt("anoFab")));
                veiculo.setPreco(rs.getFloat("preco"));
                veiculo.setUf(rs.getString("uf"));
                veiculo.setMarca(rs.getString("marca"));
                veiculo.setModelo(rs.getString("modelo"));
                veiculo.setLoja(rs.getString("loja"));

                 veiculos.add(veiculo);
            }
            pstm.close();
            rs.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: "+ex.toString());
        } finally {
            try {
                connection.close();
                System.out.println("Desconectou");
            } catch (SQLException ex) {
                Logger.getLogger(MarcaModeloDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        return veiculos;
    }

    public void create(MVeiculos v) {

        PreparedStatement stmt = null;

        try {
            stmt = connection.prepareStatement("INSERT INTO tblVeiculo(placa, anoFab, preco, uf, marca, modelo, loja)VALUES(?,?,?,?,?,?,?)");
            stmt.setString(1, v.getPlaca());
            stmt.setInt(2, v.getAnoFab());
            stmt.setFloat(3, v.getPreco());
            stmt.setString(4, v.getUf());
            stmt.setString(5, v.getMarca());
            stmt.setString(6, v.getModelo());
            stmt.setString(7, v.getLoja());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            stmt.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            try {
                connection.close();
                System.out.println("Desconectou");
            } catch (SQLException ex) {
                Logger.getLogger(MarcaModeloDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public ArrayList<MVeiculos> read() {

        ArrayList<MVeiculos> veiculos = new ArrayList<>();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = connection.prepareStatement("SELECT * FROM tblVeiculo");
            rs = stmt.executeQuery();

            while (rs.next()) {

                MVeiculos v = new MVeiculos();

                v.setPlaca(rs.getString("placa"));
                v.setAnoFab(rs.getInt("anoFab"));
                v.setPreco(rs.getFloat("preco"));
                v.setUf(rs.getString("uf"));
                v.setMarca(rs.getString("marca"));
                v.setModelo(rs.getString("modelo"));
                v.setLoja(rs.getString("loja"));

                veiculos.add(v);
            }
            stmt.close();
            rs.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            try {
                connection.close();
                System.out.println("Desconectou");
            } catch (SQLException ex) {
                Logger.getLogger(MarcaModeloDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        return veiculos;
    }
    
     public void Alterar(MVeiculos v) {

        PreparedStatement stmt = null;
        String sql = "UPDATE tblVeiculo set anoFab = ?, preco = ?,"
                + "uf = ?, marca = ?, modelo = ?, loja = ? where placa = ?";
        try {
            stmt = connection.prepareStatement(sql);
            
            stmt.setInt(1, v.getAnoFab());
            stmt.setFloat(2, v.getPreco());
            stmt.setString(3, v.getUf());
            stmt.setString(4, v.getMarca());
            stmt.setString(5,v.getModelo());
            stmt.setString(6, v.getLoja());
            stmt.setString(7, v.getPlaca());

            
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
                Logger.getLogger(MarcaModeloDAO.class
.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
     
     public void Eliminar(MVeiculos v) {

        PreparedStatement stmt = null;

        String sql = "DELETE FROM tblVeiculo where placa = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, v.getPlaca());
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
                Logger.getLogger(MarcaModeloDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    } 
}
