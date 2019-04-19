/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.K100;
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
public class DAO_K100 extends Conexao{
    private PreparedStatement ps = null;
    private ResultSet rs = null;  
    
    
    public boolean Inserir(ArrayList<K100> list_registro){
        boolean retorno = true;
        query = "insert into k100 values(?,?,?,?,?)";
        
        try {
            ps = con.prepareStatement(query);
        } catch (SQLException ex) {
            Logger.getLogger(DAO_K100.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }
        
        if(retorno){
            for(K100 registro:list_registro){
                if(!retorno)
                    break;
                try {

                    ps.setDate(1, new java.sql.Date(registro.getDt_inc_alt().getTime()));
                    ps.setString(2, registro.getCod_ltc());
                    ps.setString(3, registro.getCnpj());
                    ps.setString(4, registro.getDesc_ltc());
                    ps.setString(5, registro.getCnpj_tom());

                    if (ps.executeUpdate()<=0)
                        retorno = true;
                } catch (SQLException ex) {
                    retorno = false;
                }
            }
        }
        return retorno;
    }
    public ArrayList<K100> Buscar_todos(){
        ArrayList<K100> list_k100 = null;
        
        query = "select * from k100 where exists (SELECT relatorio_k300.COD_LTC from relatorio_k300 where relatorio_k300.COD_LTC = k100.COD_LTC)";
        try {
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next()){
                if(list_k100 == null)
                    list_k100 = new ArrayList<K100>();
                K100 k100 = new K100();
                k100.setDt_inc_alt(rs.getDate("DT_INC_ALT"));
                k100.setCod_ltc(rs.getString("COD_LTC"));
                k100.setCnpj(rs.getString("CNPJ_CEI"));
                k100.setDesc_ltc(rs.getString("DESC_LTC"));
                k100.setCnpj_tom(rs.getString("CNPJ_CEI_TOM"));

                list_k100.add(k100);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_K100.class.getName()).log(Level.SEVERE, null, ex);
            list_k100 = null;
        }

        return list_k100;
    }
    
}
