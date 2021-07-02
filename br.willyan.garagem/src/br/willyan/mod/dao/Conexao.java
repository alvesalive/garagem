/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.willyan.mod.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Willyan
 */
public class Conexao {
    
    public Connection conectar() throws ClassNotFoundException{
        Connection conexao = null;
        String driver ="com.mysql.cj.jdbc.Driver";
        
        try {
            Class.forName(driver);
            //String url = "jdbc.mysql://localhost:3306/titan?user=root&password=";
            //conexao = DriverManager.getConnection(url);
            
             conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/titan","root","");
            
        } catch ( SQLException e) {
            System.out.println("Erro ao conectar " + e.getMessage());
        }
        
        return conexao;
    }
    
}
