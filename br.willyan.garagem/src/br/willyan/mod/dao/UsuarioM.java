/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.willyan.mod.dao;

import br.willyan.cont.dto.UsuarioC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Willyan
 */
public class UsuarioM {
    
    Connection conexao;
    
    public ResultSet rs_aut(UsuarioC usuarioc) throws ClassNotFoundException {
        conexao = new Conexao().conectar();
        
        try {
            
            String sql = "select * from tbl_usuario where usuario=? and senha=?";
            PreparedStatement pstm_conex = conexao.prepareStatement(sql);
            pstm_conex.setString(1, usuarioc.getNome());
            pstm_conex.setString(2, usuarioc.getSenha());
            
            ResultSet resultado = pstm_conex.executeQuery();
            
            return resultado;
            
        } catch (SQLException erro) {
            System.out.println("Problemas ao executar UsuarioM : " + erro);
            return null;
        }
        
    }
    
}
