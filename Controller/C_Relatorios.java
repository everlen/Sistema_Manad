/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAO_Relatorios;
import Model.Relatorio;
import Model.Requisitos_busca;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Everlen
 */
public class C_Relatorios {
    
    public static ArrayList<Relatorio> Buscar_relatorio(Date periodo_inicial, Date periodo_final, boolean incluir_13, Requisitos_busca requisitos){
        DAO_Relatorios dao_relatorios = new DAO_Relatorios();
        ArrayList<Relatorio> relatorios = null;
        SimpleDateFormat format_ano = new SimpleDateFormat("yyyy");
        SimpleDateFormat format_mes = new SimpleDateFormat("MM");
        int [] dt_comp = null;
        
        if(periodo_inicial != null && periodo_final != null){
            String text_periodo_inicial_mes = format_mes.format(periodo_inicial);
            String text_periodo_inicial_ano = format_ano.format(periodo_inicial);
            String text_periodo_final_mes = format_mes.format(periodo_final);
            String text_periodo_final_ano = format_ano.format(periodo_final);
            int int_inicial_mes = Integer.parseInt(text_periodo_inicial_mes);
            int int_inicial_ano = Integer.parseInt(text_periodo_inicial_ano);
            int int_final_mes = Integer.parseInt(text_periodo_final_mes);
            int int_final_ano = Integer.parseInt(text_periodo_final_ano);
            
            ArrayList<String> list_dt_comp = new ArrayList<String>();
            int ano_inicial = int_inicial_ano;    
            while(int_inicial_mes != int_final_mes || int_inicial_ano != int_final_ano){
                
                list_dt_comp.add(String.valueOf(int_inicial_mes)+String.valueOf(int_inicial_ano));             
                
                if(int_inicial_mes < 12){
                    int_inicial_mes++;
                }
                else{
                    int_inicial_mes = 1;
                    int_inicial_ano++;
                }
                
            }
            list_dt_comp.add(String.valueOf(int_final_mes)+String.valueOf(int_final_ano));
            if(incluir_13)
                while(ano_inicial <= int_final_ano){
                    list_dt_comp.add("13"+String.valueOf(ano_inicial));
                    ano_inicial++;
                }
            
            
            dt_comp = new int [list_dt_comp.size()];            
            for(int i = 0; i< list_dt_comp.size(); i++){
                dt_comp[i] = Integer.parseInt(list_dt_comp.get(i));
            }
            
        }
        if(requisitos!=null){
            int[] indicador_folha = null;
            if(requisitos.getTipo_folha()!=null){
                indicador_folha = new int[requisitos.getTipo_folha().size()];
                int d = 0;
                for(String s: requisitos.getTipo_folha()){
                    indicador_folha[d] = Integer.parseInt(s);
                    d++;
                }
            }
            
            int[] indicador_previdencia = null;
            if(requisitos.getInd_base_ps()!=null){
                indicador_previdencia = new int[requisitos.getInd_base_ps().size()];
                int d = 0;
                for(String s: requisitos.getInd_base_ps()){
                    indicador_previdencia[d] = Integer.parseInt(s);
                    d++;
                }
            }

            relatorios = dao_relatorios.Buscar_relatorio(dt_comp, indicador_folha, requisitos.getCod_rubr(), requisitos.getCod_ltc(), indicador_previdencia);
        }
        else
            relatorios = dao_relatorios.Buscar_relatorio(dt_comp, null, null, null, null);
        return relatorios;
    }
   /* public static int Buscar_apuraçao (String cod_rubr){
        DAO_Relatorios dao_relatorios = new DAO_Relatorios();
        return dao_relatorios.Buscar_apuraçao(cod_rubr); 
    }  */
}
