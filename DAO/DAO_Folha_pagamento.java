/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Folha_pagamento;
import Model.Item_folha_pagamento;
import Model.Rubr_folha_pagamento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Victony
 */
public class DAO_Folha_pagamento extends Conexao{
    PreparedStatement ps=null;
    ResultSet rs=null;
    
    public ArrayList<Folha_pagamento> Buscar_todos(){
        ArrayList<Folha_pagamento> folha_completa = null;  
   
        String query = "select * from folha_pagamento";
        try {
            
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Folha_pagamento folha_dt_comp = null;
            ArrayList<Item_folha_pagamento> list_item_folha = null;
            Item_folha_pagamento item_fl = null;
            ArrayList<Rubr_folha_pagamento> list_rubr = null;
            Item_folha_pagamento totalizaçao = null;
            
            while(rs.next()){
                if(folha_completa == null){
                    folha_completa  = new ArrayList<Folha_pagamento>();
                }
                if(folha_dt_comp == null || !folha_dt_comp.getDt_comp().equals(String.valueOf(rs.getInt("DT_COMP")))){
                    folha_dt_comp = new Folha_pagamento();
                    folha_dt_comp.setDt_comp(String.valueOf(rs.getInt("DT_COMP")));
                    folha_dt_comp.setPeriodo("Ainda a ser definido");
                    list_item_folha = new ArrayList<Item_folha_pagamento>();
                    folha_dt_comp.setList_item_folha(list_item_folha);
                    totalizaçao = new Item_folha_pagamento();
                    folha_dt_comp.setTotalizaçao(totalizaçao);
                    
                    folha_completa.add(folha_dt_comp);
                }                   

                if(list_item_folha.size()==0 || !item_fl.getCod_trabalhador().equals(rs.getString("COD_REG_TRAB"))){
                    item_fl = new Item_folha_pagamento();
                    item_fl.setCod_trabalhador(rs.getString("COD_REG_TRAB"));                   
                    item_fl.setNome_trabalhado(rs.getString("NOME_TRAB"));
                    item_fl.setDesc_cargo(rs.getString("DESC_CARGO"));
                    item_fl.setDt_admissao(rs.getString("DT_ADMISSAO"));
                    item_fl.setData_pagamento(formato.format(rs.getDate("DT_PGTO")));
                    item_fl.setValor_base_ps(rs.getFloat("VL_BASE_PS"));
                    list_rubr = new ArrayList<Rubr_folha_pagamento>();
                    item_fl.setList_rubr(list_rubr);
                    
                    list_item_folha.add(item_fl);
                }

                Rubr_folha_pagamento rubr = new Rubr_folha_pagamento();
                rubr.setCod(rs.getString("COD_RUBR"));
                rubr.setDescriçao(rs.getString("DESC_RUBRICA"));
                rubr.setInd_rubr(rs.getString("IND_RUBR").charAt(0));
                rubr.setValor(rs.getFloat("VLR_RUBR"));

                list_rubr.add(rubr);

            }
        
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Folha_pagamento.class.getName()).log(Level.SEVERE, null, ex);
        }

        return folha_completa;
    }  
    
    
}
