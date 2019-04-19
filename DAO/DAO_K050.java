/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.K050;
import java.sql.Date;
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
public class DAO_K050 extends Conexao{
    private PreparedStatement ps = null;
    private ResultSet rs = null;    
    
    
    public boolean Inserir(ArrayList<K050> list_registro){
        
        boolean retorno = true;
        query = "insert into k050 values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(query);
        } catch (SQLException ex) {
            Logger.getLogger(DAO_K050.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }
        if(retorno){
            for(K050 registro:list_registro){
                if(!retorno)
                    break;
                try {
                    ps.setString(1, registro.getCnpj());
                    ps.setDate(2, new java.sql.Date(registro.getDt_inc_alt().getTime()));
                    ps.setString(3, registro.getCod_reg_trab());
                    ps.setString(4, String.valueOf(registro.getCpf()));
                    ps.setString(5, String.valueOf(registro.getNit()));
                    ps.setInt(6, registro.getCod_categ());
                    ps.setString(7, registro.getNome_trab());
                    ps.setDate(8, new java.sql.Date(registro.getDt_nasc().getTime()));
                    ps.setDate(9, new java.sql.Date(registro.getDt_admissao().getTime()));
                    if(registro.getDt_demissao()!=null)
                        ps.setDate(10, new java.sql.Date(registro.getDt_demissao().getTime()));
                    else
                        ps.setDate(10, null);
                    ps.setInt(11, registro.getInd_vinc());
                    ps.setInt(12, registro.getTipo_ato_nom());
                    ps.setString(13, registro.getNm_ato_nom());
                    if(registro.getDt_ato_nom()!=null)
                        ps.setDate(14, new java.sql.Date(registro.getDt_ato_nom().getTime()));
                    else
                        ps.setDate(14, null);
                    
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
