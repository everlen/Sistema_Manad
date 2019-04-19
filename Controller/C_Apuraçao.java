/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAO_Apuraçao;
import Model.Apuraçao;
import Model.Rubrica_apuraçao;
import java.util.ArrayList;

/**
 *
 * @author Everlen
 */
public class C_Apuraçao {
    
    ArrayList<Rubrica_apuraçao> list_all_rubrica, list_rubrica_atual;
    
    public static ArrayList<ArrayList<Apuraçao>> Buscar_rubricas_para_apuraçao(ArrayList<String> list_cod_rubr){
        DAO_Apuraçao dao_apuraçao = new DAO_Apuraçao();
        ArrayList<ArrayList<Apuraçao>> retorno = null;
        
        for(String cod_rubr:list_cod_rubr){
            ArrayList<Apuraçao> rubrica_dt_comp = dao_apuraçao.Buscar_rubrica_dt_comp(cod_rubr);
            if(rubrica_dt_comp != null){
                if(retorno == null)
                    retorno = new ArrayList<ArrayList<Apuraçao>>();
                retorno.add(rubrica_dt_comp);
            }          
        }       
        
        return retorno;
    }
    
    public static ArrayList<Rubrica_apuraçao> Buscar_todos_item_apuraçao(){       
        return new DAO_Apuraçao().Buscar_todas_apuraçao();        
    }
    
    public void Iniciar_filtro_apuraçao(ArrayList<Rubrica_apuraçao> lista_all_rubrica){   
        list_all_rubrica = new ArrayList<Rubrica_apuraçao>();     
        list_all_rubrica.addAll(lista_all_rubrica);
        
        list_rubrica_atual = new ArrayList<Rubrica_apuraçao>(); 
        list_rubrica_atual.addAll(list_all_rubrica);

    }

    
    public ArrayList<Rubrica_apuraçao> Buscar (String texto_busca, boolean apenas_inss_1){
        list_rubrica_atual.clear();
        
        for(int i = 0; i< list_all_rubrica.size(); i++){           
            if(list_all_rubrica.get(i).getRubrica().toLowerCase().indexOf(texto_busca.toLowerCase()) != -1){
                if(apenas_inss_1){
                    if(list_all_rubrica.get(i).getInss() == 1)
                        list_rubrica_atual.add(list_all_rubrica.get(i));
                }
                else
                    list_rubrica_atual.add(list_all_rubrica.get(i));
            }           
        }      
        
        return list_rubrica_atual;
    }   

}
