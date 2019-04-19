/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import Model.K150;
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
public class DAO_K150 extends Conexao{
    
    private PreparedStatement ps = null;
    private ResultSet rs = null;  
    
     public boolean Inserir(ArrayList<K150> list_registro){
        boolean retorno = true;
        query = "insert into k150 values(?,?,?,?)";
        try {
            ps = con.prepareStatement(query);
        } catch (SQLException ex) {
            Logger.getLogger(DAO_K150.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }
        if(retorno){
            for(K150 registro:list_registro){
                if(!retorno)
                    break;
                try {
                    ps.setString(1, registro.getCnpj());
                    ps.setDate(2, new java.sql.Date(registro.getDt_inc_alt().getTime()));
                    ps.setString(3, registro.getCod_rubrica());
                    ps.setString(4, registro.getDesc_rubrica());

                    if (ps.executeUpdate()<=0)
                        retorno = false;
                } catch (SQLException ex) {
                    retorno = false;
                }
            }
        }
        return retorno;
    }
     
    public ArrayList<K150> Buscar_todos(){
        ArrayList<K150> list_k150 = null;
        
        query = "select * from k150 where exists (SELECT relatorio_k300.COD_RUBR from relatorio_k300 where relatorio_k300.COD_RUBR = k150.COD_RUBRICA) ORDER by (k150.DESC_RUBRICA)";
        try {
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            list_k150 = new ArrayList<K150>();
            while(rs.next()){
                K150 k150 = new K150();
                
                k150.setCnpj(rs.getString("CNPJ_CEI"));
                k150.setDt_inc_alt(rs.getDate("DT_INC_ALT"));
                k150.setCod_rubrica(rs.getString("COD_RUBRICA"));
                k150.setDesc_rubrica(rs.getString("DESC_RUBRICA"));

                list_k150.add(k150);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_K100.class.getName()).log(Level.SEVERE, null, ex);
            list_k150 = null;
        }

        return list_k150;
    }
    /*
    public ArrayList<K150> Buscar_k150_inss(){
        ArrayList<K150> list_k150 = null;
        ArrayList<String> list_cod_rubr = Buscar_cod_rubr_inss();
        if(list_cod_rubr!=null){
            query = "select * from k150 where ";
            boolean primeira_inserçao = true;
            for(String cod_rubr:list_cod_rubr){
                if(!primeira_inserçao){
                    query += " || ";
                }
                else{
                    primeira_inserçao = false;
                }
                query += "COD_RUBRICA = ?";
            }
            try {
                ps = con.prepareStatement(query);
                int i = 1;
                for(String cod_rubr:list_cod_rubr){
                    ps.setString(i, cod_rubr);
                    i++;
                }
                
                rs = ps.executeQuery();
                list_k150 = new ArrayList<K150>();
                while(rs.next()){
                    K150 k150 = new K150();
                    k150.setCnpj(rs.getString("CNPJ_CEI"));
                    k150.setDt_inc_alt(rs.getDate("DT_INC_ALT"));
                    k150.setCod_rubrica(rs.getString("COD_RUBRICA"));
                    k150.setDesc_rubrica(rs.getString("DESC_RUBRICA"));
                    list_k150.add(k150);
                }
            } catch (SQLException ex) {
                Logger.getLogger(DAO_K100.class.getName()).log(Level.SEVERE, null, ex);
                list_k150 = null;
            }           
        }
        
        return list_k150;
    }
        */
    private ArrayList<String> Buscar_cod_rubr_inss (){
        ArrayList<String> list_cod_rubr = null;
        query = "select DISTINCT COD_RUBR from relatorio_k300 WHERE IND_BASE_PS = 1";
        try {
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            list_cod_rubr = new ArrayList<String>();
            while(rs.next()){
                list_cod_rubr.add(rs.getString("COD_RUBR"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_K150.class.getName()).log(Level.SEVERE, null, ex);
            list_cod_rubr = null;
        }                
        return list_cod_rubr;
    }
    
}
