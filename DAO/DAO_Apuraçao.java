/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Apuraçao;
import Model.Rubrica_apuraçao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Victony
 */
public class DAO_Apuraçao extends Conexao{
    private PreparedStatement ps = null;
    private ResultSet rs = null; 
    
    public ArrayList<Apuraçao> Buscar_rubrica_dt_comp(String cod_rubr){
        ArrayList<Apuraçao> retorno = null;
        query = "select relatorio_k300.DESC_RUBRICA, relatorio_k300.DT_COMP, sum(relatorio_k300.VLR_RUBR) as soma from relatorio_k300 where relatorio_k300.COD_RUBR = ? group by relatorio_k300.DT_COMP";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, cod_rubr);
            rs = ps.executeQuery();
            while(rs.next()){
                if(retorno == null)
                    retorno = new ArrayList<Apuraçao>();
                
                Apuraçao apuraçao = new Apuraçao();
                apuraçao.setCod_rubr(cod_rubr);
                apuraçao.setDes_rubr(rs.getString("DESC_RUBRICA"));
                apuraçao.setValor_evento(rs.getFloat("soma"));
                apuraçao.setAno(rs.getString("DT_COMP").substring(rs.getString("DT_COMP").length()-4));
                apuraçao.setMes(rs.getString("DT_COMP").substring(0, rs.getString("DT_COMP").length()-4));
                retorno.add(apuraçao);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Apuraçao.class.getName()).log(Level.SEVERE, null, ex);
            retorno = null;
        }
        
        return retorno;
    }
   
    public int Buscar_apuraçao (String cod_rubr){
        int valor = -1;
        query = "select DISTINCT(IND_BASE_PS) from relatorio_k300 WHERE COD_RUBR = ?";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, cod_rubr);
            rs = ps.executeQuery();
            if(rs.next()){
                valor = rs.getInt("IND_BASE_PS");
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAO_Relatorios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return valor;
    }
    
    public ArrayList<Rubrica_apuraçao> Buscar_todas_apuraçao (){
        ArrayList<Rubrica_apuraçao> retorno = null;
        query = "select DISTINCT(relatorio_k300.DESC_RUBRICA) as DESC_RUBR, relatorio_k300.COD_RUBR, relatorio_k300.IND_BASE_PS from relatorio_k300 ORDER by (DESC_RUBR)";
        try {
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();           
            while(rs.next()){
                if(retorno == null)
                    retorno = new ArrayList<Rubrica_apuraçao>();
                
                Rubrica_apuraçao item = new Rubrica_apuraçao();
                item.setCod(rs.getString("COD_RUBR"));
                item.setRubrica(rs.getString("DESC_RUBR"));
                item.setInss(rs.getInt("IND_BASE_PS"));
                //item.setQuant_encontrado(rs.getInt("QUANT"));
                
                retorno.add(item);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAO_Relatorios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return retorno;
    }    
    
    public ArrayList<Rubrica_apuraçao> Buscar_filtro_apuraçao (String texto_filtro){
        ArrayList<Rubrica_apuraçao> retorno = null;
        query = "select DISTINCT(relatorio_k300.DESC_RUBRICA) as DESC_RUBR, relatorio_k300.COD_RUBR, relatorio_k300.IND_BASE_PS from relatorio_k300 where relatorio_k300.DESC_RUBRICA like ? ORDER by (DESC_RUBR)";
        try {
            ps = con.prepareStatement(query);
            texto_filtro = "%"+texto_filtro+"%";
            ps.setString(1, texto_filtro);
            rs = ps.executeQuery();           
            while(rs.next()){
                if(retorno == null)
                    retorno = new ArrayList<Rubrica_apuraçao>();
                
                Rubrica_apuraçao item = new Rubrica_apuraçao();
                item.setCod(rs.getString("COD_RUBR"));
                item.setRubrica(rs.getString("DESC_RUBR"));
                item.setInss(rs.getInt("IND_BASE_PS"));
                //item.setQuant_encontrado(rs.getInt("QUANT"));
                
                retorno.add(item);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAO_Relatorios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return retorno;
    }
}
