/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.K050;
import Model.K100;
import Model.K150;
import Model.K300;
import Model.Relatorio;
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
public class DAO_Relatorios extends Conexao{
    PreparedStatement ps=null;
    ResultSet rs=null;

    public ArrayList<Relatorio> Buscar_relatorio(int[] periodo, int[] indicador_folha, ArrayList<String> cod_rubr, ArrayList<String> cod_ltc, int[] indicador_previdencia){
        ArrayList<Relatorio> relatorios =  null;
        int i = 0;
        try {
        
            query = "select * from relatorio_k300";
            if(periodo != null || indicador_folha != null || cod_rubr != null || cod_ltc != null || indicador_previdencia != null){
                query += " WHERE ";
                i++;
                if(periodo != null){
                    if(i>1)
                        query += " AND ";
                    
                    query += "(";
                    for(int c = 0; c<periodo.length; c++){
                        if(c>0)
                            query += " OR ";
                        query += "DT_COMP = ?";       
                    }
                    query += ")";
                    
                    i++;
                }
                if(indicador_folha != null){
                    if(i>1)
                        query += " AND ";
                    
                    query += "(";
                    for(int c = 0; c < indicador_folha.length; c++){
                        if(c>0)
                            query += " OR ";
                        if(indicador_folha[c] < 6)
                            query += "IND_FL = ?";
                        else
                            query += "IND_FL >= ?";     
                    }
                    query += ")";

                    i++;
                }
                if(cod_rubr != null){
                    if(i>1)
                        query += " AND ";
                    
                    query += "(";
                    for(int c = 0; c < cod_rubr.size(); c++){
                        if(c>0)
                            query += " OR ";
                        query += "COD_RUBR = ?";    
                    }
                    query += ")";
                    
                    i++;
                }
                if(cod_ltc != null){
                    if(i>1)
                        query += " AND ";
                    query += "(";
                    for(int c = 0; c < cod_ltc.size(); c++){
                        if(c>0)
                            query += " OR ";
                        query += "COD_LTC = ?";   
                    }
                    query += ")";
                    
                    i++;
                }
                if(indicador_previdencia != null){
                    if(i>1)
                        query += " AND ";
                    
                    query += "(";
                    for(int c = 0; c < indicador_previdencia.length; c++){
                        if(c>0)
                            query += " OR ";
                        query += "IND_BASE_PS = ?";    
                    }
                    query += ")";

                }
            }    
            
            query +=";";
            ps = con.prepareStatement(query);
            i = 1;
            if(periodo != null){
                for(int c = 0; c<periodo.length; c++){
                    ps.setInt(i, periodo[c]);
                    i++;
                }
            }
            if(indicador_folha != null){
                for(int c = 0; c<indicador_folha.length; c++){
                    ps.setInt(i, indicador_folha[c]);
                    i++;
                }
            }
            if(cod_rubr != null){
                for(int c = 0; c<cod_rubr.size(); c++){
                     ps.setString(i, cod_rubr.get(c));
                    i++;
                }
            }
            if(cod_ltc != null){
                for(int c = 0; c<cod_ltc.size(); c++){
                    ps.setString(i, cod_ltc.get(c));
                    i++;
                }
            }
            if(indicador_previdencia != null){
                for(int c = 0; c<indicador_previdencia.length; c++){
                    ps.setInt(i, indicador_previdencia[c]);
                    i++;
                }
            }

            rs = ps.executeQuery();
            relatorios = Criar_lista(); 

        } catch (SQLException ex) {
            Logger.getLogger(DAO_Relatorios.class.getName()).log(Level.SEVERE, null, ex);
            relatorios = null;
        } 
        
        return relatorios;
    }
    
    
    private ArrayList<Relatorio> Criar_lista(){
        ArrayList<Relatorio> relatorios = new ArrayList<>();
        Relatorio relatorio;
        boolean verificador = true;
        try {
            
            while(rs.next()){
                verificador = false;
                relatorio = new Relatorio();
                K050 k050 = new K050();
                K100 k100 = new K100();
                K150 k150 = new K150();
                K300 k300 = new K300();
                
                k050.setCnpj(rs.getString("CNPJ_CEI"));
                k050.setDt_inc_alt(rs.getDate("K050_DT_INC_ALT"));
                k050.setCod_reg_trab(rs.getString("COD_REG_TRAB"));
                k050.setCpf(rs.getString("CPF").toCharArray());
                k050.setNit(rs.getString("NIT").toCharArray());
                k050.setCod_categ(rs.getInt("COD_CATEG"));
                k050.setNome_trab(rs.getString("NOME_TRAB"));
                k050.setDt_nasc(rs.getDate("DT_NASC"));
                k050.setDt_admissao(rs.getDate("DT_ADMISSAO"));
                k050.setDt_demissao(rs.getDate("DT_DEMISSAO"));
                k050.setInd_vinc(rs.getInt("IND_VINC"));
                k050.setTipo_ato_nom(rs.getInt("TIPO_ATO_NOM"));
                k050.setNm_ato_nom(rs.getString("NM_ATO_NOM"));
                k050.setDt_ato_nom(rs.getDate("DT_ATO_NOM"));
                if(k050.getCod_reg_trab().length() == 0)
                    k050 = null;
                
                k100.setDt_inc_alt(rs.getDate("K100_DT_INC_ALT"));
                k100.setCod_ltc(rs.getString("COD_LTC"));
                k100.setCnpj(rs.getString("CNPJ_CEI"));
                k100.setDesc_ltc(rs.getString("DESC_LTC"));
                k100.setCnpj_tom(rs.getString("CNPJ_CEI_TOM"));
                if(k100.getCod_ltc().length()==0)
                    k100 = null;
                
                k150.setCnpj(rs.getString("CNPJ_CEI"));
                k150.setDt_inc_alt(rs.getDate("K150_DT_INC_ALT"));
                k150.setCod_rubrica(rs.getString("COD_RUBR"));
                k150.setDesc_rubrica(rs.getString("DESC_RUBRICA"));
                if(k150.getCod_rubrica().length() == 0)
                    k150 = null;
                
                k300.setCnpj(rs.getString("CNPJ_CEI"));
                k300.setInd_fl(rs.getInt("IND_FL"));
                k300.setCod_ltc(rs.getString("COD_LTC"));
                k300.setCod_reg_trab(rs.getString("COD_REG_TRAB"));
                k300.setDt_comp(rs.getInt("DT_COMP"));
                k300.setCod_rubr(rs.getString("COD_RUBR"));
                k300.setVlr_rubr(Float.valueOf(rs.getFloat("VLR_RUBR")).floatValue());
                k300.setInd_rubr(rs.getString("IND_RUBR").charAt(0));
                k300.setInd_base_irrf(rs.getInt("IND_BASE_IRRF"));
                k300.setInd_base_ps(rs.getInt("IND_BASE_PS"));
                
                relatorio.k050=k050;
                relatorio.k100=k100;
                relatorio.k150=k150;
                relatorio.k300=k300;
                
                relatorios.add(relatorio);
            }
            if(verificador)
                relatorios = null;
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Relatorios.class.getName()).log(Level.SEVERE, null, ex);
            relatorios = null;
        }
        return relatorios;
    }
}
