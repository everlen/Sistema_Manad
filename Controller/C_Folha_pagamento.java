/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAO_Folha_pagamento;
import Model.Folha_pagamento;
import Model.Item_folha_pagamento;
import java.util.ArrayList;

/**
 *
 * @author Victony
 */
public class C_Folha_pagamento {
    public static ArrayList<Folha_pagamento> Montar_folha(){
        ArrayList<Folha_pagamento> retorno = new DAO_Folha_pagamento().Buscar_todos();
        
//Ordenar
        for(int i = 0; i<retorno.size()-1; i ++){
            for(int c = i+1; c<retorno.size(); c++){
                int ano_base = Integer.parseInt(retorno.get(i).getDt_comp().substring(retorno.get(i).getDt_comp().length()-4));
                int mes_base = Integer.parseInt(retorno.get(i).getDt_comp().substring(0, retorno.get(i).getDt_comp().length()-4));
                int ano_atual = Integer.parseInt(retorno.get(c).getDt_comp().substring(retorno.get(c).getDt_comp().length()-4));
                int mes_atual = Integer.parseInt(retorno.get(c).getDt_comp().substring(0, retorno.get(c).getDt_comp().length()-4));
                
                if(ano_base == ano_atual && mes_base+1 == mes_atual){
                    Folha_pagamento aux_folha_pagamento = retorno.get(i+1);
                    retorno.set(i+1, retorno.get(c));
                    retorno.set(c, aux_folha_pagamento);
                    break;
                }
                else if(ano_base+1 == ano_atual && mes_base == 12 && mes_atual == 1){
                    Folha_pagamento aux_folha_pagamento = retorno.get(i+1);
                    retorno.set(i+1, retorno.get(c));
                    retorno.set(c, aux_folha_pagamento);
                    break;
                }
            }            
            
        }

        return retorno;
    }
}
