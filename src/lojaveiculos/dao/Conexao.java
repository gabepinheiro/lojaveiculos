/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojaveiculos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author gabriel
 */
public class Conexao {
    
    public Connection connection = null;
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String DBANME = "lojaVeiculos";
    private final String URL = "jdbc:mysql://localhost:3306/" + DBANME+"?useTimezone=true&serverTimezone=America/Sao_Paulo";
    private final String LOGIN = "root";
    private final String SENHA = "root";
    
    public Connection getConnection(){
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, LOGIN, SENHA);
            System.out.println("Conectou");
            return connection;
            
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Driver não encontrado: "+ e.toString());
            System.out.println("Driver não encontrado "+ e.toString());
            return null;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao conectar: "+ ex.toString());
            System.out.println("Falha ao conectar "+ ex.toString());
            return null;
        }
    }
    
    
}