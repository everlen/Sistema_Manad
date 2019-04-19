/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAO_K300;
import Model.K300;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author Everlen
 */
public class C_K300 {
    
    public static boolean Inserir(ArrayList<K300> list_k300){
        boolean retorno;
        DAO_K300 dao = new DAO_K300();
        retorno = dao.Inserir(list_k300);
        return retorno;
    }
    
    public static K300 Filtrar(String linha){
        
        char[] vetor = new char[linha.length()];
        linha.getChars(0, linha.length(), vetor, 0);
        
        int tipo_campo = -1;
        ArrayList<Character> campo = new ArrayList<Character>();
        K300 k300 = new K300();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        
       boolean verificador = false;
        for(int i =0; i<= vetor.length; i++){
            verificador = false;
            if(i<vetor.length)
                if(vetor[i] != '|'){
                    campo.add(vetor[i]);
                }
                else{
                   verificador = true; 
                }
            else{
                verificador = true;
            }
            if(verificador){
                switch (tipo_campo) {
                    case 0:
                        k300.setCnpj(campo.toString().replaceAll("[,\\s\\[\\]]", ""));
                        break;
                    case 1:
                        k300.setInd_fl(Integer.parseInt(campo.toString().replaceAll("[,\\s\\[\\]]", "")));
                        break;
                    case 2:
                        k300.setCod_ltc(campo.toString().replaceAll("[,\\s\\[\\]]", ""));
                        break;
                    case 3:
                        k300.setCod_reg_trab(campo.toString().replaceAll("[,\\s\\[\\]]", ""));
                        break;
                    case 4:
                        k300.setDt_comp(Integer.parseInt(campo.toString().replaceAll("[,\\s\\[\\]]", "")));
                        break;
                    case 5:
                        k300.setCod_rubr(campo.toString().replaceAll("[,\\s\\[\\]]", ""));
                        break;
                    case 6:
                        String valor = campo.toString().replace(",,", ".");
                        valor = valor.replaceAll("[,\\s\\[\\]]", "");
                        k300.setVlr_rubr(Float.parseFloat(valor));
                        break;
                    case 7:
                        k300.setInd_rubr(campo.toString().replaceAll("[,\\s\\[\\]]", "").charAt(0));
                        break;
                    case 8:
                        k300.setInd_base_irrf(Integer.parseInt(campo.toString().replaceAll("[,\\s\\[\\]]", "")));
                        break;
                    case 9:
                        k300.setInd_base_ps(Integer.parseInt(campo.toString().replaceAll("[,\\s\\[\\]]", "")));
                        break;
                    default:
                        break;
                }
                campo.clear();
                tipo_campo++;
            }
            
            
        }
        return k300;
    }
}
