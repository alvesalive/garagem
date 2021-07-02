/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.willyan._garagem;

import br.willyan.vi.view.formAcesso;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author Willyan
 */
public class BrWillyanGaragem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        formAcesso vai = new formAcesso();
        
        
        Date data = new Date();
        LocalDateTime agora = LocalDateTime.now(); 
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/YY");
        System.out.println(formatador.format( data ));
        System.out.println(agora);
    }
    
}
