package lojaveiculos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import lojaveiculos.model.MEstado;

public class EstadoDAO {

    private Connection con;

    public EstadoDAO() {
        this.con = new Conexao().getConnection();
    }

    public void create(MEstado e) throws SQLException {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO tblEstado(uf, nomeEstado)VALUES(?,?)");
            stmt.setString(1, e.getSigla());
            stmt.setString(2, e.getEstado());

            stmt.executeUpdate();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir: " + ex);
        } finally {
            try {
                con.close();
                System.out.println("Desconectou");
            } catch (SQLException ex) {
                Logger.getLogger(MarcaModeloDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public ArrayList<MEstado> read() {

        ArrayList<MEstado> estado = new ArrayList<>();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM tblEstado");
            rs = stmt.executeQuery();

            while (rs.next()) {

                MEstado e = new MEstado();

                e.setSigla(rs.getString("uf"));
                e.setEstado(rs.getString("nomeEstado"));
                estado.add(e);
            }
            stmt.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            try {
                con.close();
                System.out.println("Desconectou");
            } catch (SQLException ex) {
                Logger.getLogger(MarcaModeloDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        return estado;
    }

     public MEstado buscarEstadoPK(MEstado e) {

    

        String sql = "select * from tblEstado where uf = ?";
        PreparedStatement stm = null;
        try {
            stm = con.prepareStatement(sql);
            stm.setString(1, e.getSigla());

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                e.setSigla(rs.getString("uf"));
                e.setEstado(rs.getString("nomeEstado"));
               

            }

            stm.close();
            rs.close();

        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Erro: "+ex.toString());
        } finally {
            try {
                con.close();
                System.out.println("Desconectou");
            

} catch (SQLException ex) {
                Logger.getLogger(MarcaModeloDAO.class
.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return e;
    }
     
       public void Alterar(MEstado e) {

        PreparedStatement stmt = null;
        String sql = "UPDATE tblEstado set nomeEstado = ? where uf = ?";
        try {
            stmt = con.prepareStatement(sql);
            
            stmt.setString(1, e.getEstado());
            stmt.setString(2, e.getSigla());

            
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");

            stmt.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar: " + ex);
        } finally {
            try {
                con.close();
                System.out.println("Desconectou");
            

} catch (SQLException ex) {
                Logger.getLogger(MarcaModeloDAO.class
.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public MEstado buscarEstadoPelaUf(String uf) {

        MEstado mm = new MEstado();

        String sql = "select * from tblEstado where uf = ?";
        PreparedStatement stm = null;
        try {
            stm = con.prepareStatement(sql);
            stm.setString(1, uf);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                mm.setSigla(rs.getString("uf"));
                mm.setEstado(rs.getString("nomeEstado"));
            }

            stm.close();
            rs.close();

        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Erro: "+ex.toString());
        } finally {
            try {
                con.close();
                System.out.println("Desconectou");


            } catch (SQLException ex) {
                Logger.getLogger(MarcaModeloDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return mm;
    }

    public void Eliminar(MEstado mm) {

        PreparedStatement stmt = null;

        String sql = "DELETE FROM tblEstado where uf = ?";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, mm.getSigla());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Eliminado com sucesso!");

            stmt.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Eliminar:  Violação de FK");
        } finally {
            try {
                con.close();
                System.out.println("Desconectou");
            } catch (SQLException ex) {
                Logger.getLogger(MarcaModeloDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
