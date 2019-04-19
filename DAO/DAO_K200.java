/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.K200;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Everlen
 */
public class DAO_K200 extends Conexao{
    private PreparedStatement ps = null;
    private ResultSet rs = null;    
    
    
    public boolean Inserir(ArrayList<K200> list_registro){
        boolean retorno = true;
        
        query = "insert into k200 values(0,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(query);
        } catch (SQLException ex) {
            Logger.getLogger(DAO_K200.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }
        if(retorno){
            for(K200 registro:list_registro){
                if(!retorno)
                    break;
                
                try {
                    ps.setDate(1, new java.sql.Date(registro.getDt_inc_alt().getTime()));
                    ps.setString(2, registro.getCnpj());
                    ps.setString(3, registro.getCod_rubrica());
                    ps.setString(4, registro.getCod_ltc());
                    ps.setString(5, registro.getCod_ccus());
                    ps.setString(6, registro.getCod_cta());

                    if (ps.executeUpdate()<=0)
                        retorno = false;
                } catch (SQLException ex) {
                    retorno = false;
                }
            }
        }
        return retorno;
    }
    
    
}
