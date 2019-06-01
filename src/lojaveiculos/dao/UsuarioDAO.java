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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import lojaveiculos.model.MUsuario;

/**
 *
 * @author gabriel
 */
public class UsuarioDAO{

    private Connection connection;

    public UsuarioDAO() {
       this.connection = new Conexao().getConnection();
    }

    public boolean buscarLogin(MUsuario usuario) {

        int cont = 0;

        String sql = "select * from tblUsuario where login=? and senha = ?";
        PreparedStatement stm;
        try {
            stm = connection.prepareStatement(sql);
            stm.setString(1, usuario.getUsuario());
            stm.setString(2, usuario.getSenha());
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                cont++;
            }
            stm.close();
            rs.close();

        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Erro: "+ex.toString());
        }finally {
            try {
                connection.close();
                System.out.println("Desconectou");
            } catch (SQLException ex) {
                Logger.getLogger(MarcaModeloDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        return (cont == 1);
    }
}
