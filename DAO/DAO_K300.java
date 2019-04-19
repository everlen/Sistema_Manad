/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.K300;
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
public class DAO_K300 extends Conexao{
    
    private PreparedStatement ps = null;
    private ResultSet rs = null;    
    
    
    public boolean Inserir(ArrayList<K300> list_registro){
        boolean retorno = true;
        
        query = "insert into k300 values(0,?,?,?,?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(query);
        } catch (SQLException ex) {
            Logger.getLogger(DAO_K300.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }
        
        if(retorno){
            for(K300 registro: list_registro){
                if(!retorno)
                    break;
                
                try {
                    ps.setString(1, registro.getCnpj());
                    ps.setInt(2, registro.getInd_fl());
                    ps.setString(3, registro.getCod_ltc());
                    ps.setString(4, registro.getCod_reg_trab());
                    ps.setInt(5, registro.getDt_comp());
                    ps.setString(6, registro.getCod_rubr());
                    ps.setFloat(7, registro.getVlr_rubr());
                    ps.setString(8, String.valueOf(registro.getInd_rubr()));
                    ps.setInt(9, registro.getInd_base_irrf());
                    ps.setInt(10, registro.getInd_base_ps());

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
