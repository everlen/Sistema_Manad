/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import Model.K250;
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
public class DAO_K250 extends Conexao{
    private PreparedStatement ps = null;
    private ResultSet rs = null;    
    
    
    public boolean Inserir(ArrayList<K250> list_registro){
        boolean retorno = true;
        query = "insert into k250 values(0,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(query);
        } catch (SQLException ex) {
            Logger.getLogger(DAO_K250.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }
        if(retorno){
            for(K250 registro:list_registro){
                if(!retorno)
                    break;
                try {
                    ps.setString(1, registro.getCnpj());
                    ps.setInt(2, registro.getInd_fl());
                    ps.setString(3, registro.getCod_ltc());
                    ps.setString(4, registro.getCod_reg_trab());
                    ps.setInt(5, registro.getDt_comp());
                    ps.setDate(6, new java.sql.Date(registro.getDt_pgto().getTime()));
                    ps.setInt(7, registro.getCod_cbo());
                    ps.setInt(8, registro.getCod_ocorr());
                    ps.setString(9, registro.getDesc_cargo());
                    ps.setInt(10, registro.getQtd_dep_ir());
                    ps.setInt(11, registro.getQtd_dep_sf());
                    ps.setFloat(12, registro.getVl_base_irrf());
                    ps.setFloat(13, registro.getVl_base_ps());

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
