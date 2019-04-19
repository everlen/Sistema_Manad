/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAO_K250;
import Model.K250;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Everlen
 */
public class C_K250 {
    
    public static boolean Inserir(ArrayList<K250> list_k250){
        boolean retorno;
        DAO_K250 dao = new DAO_K250();
        retorno = dao.Inserir(list_k250);
        return retorno;
    }
    
    public static K250 Filtrar(String linha){
        
        char[] vetor = new char[linha.length()];
        linha.getChars(0, linha.length(), vetor, 0);
        
        int tipo_campo = -1;
        ArrayList<Character> campo = new ArrayList<Character>();
        K250 k250 = new K250();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String valor;
        
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
                        k250.setCnpj(campo.toString().replaceAll("[,\\s\\[\\]]", ""));
                        break;
                    case 1:
                        k250.setInd_fl(Integer.parseInt(campo.toString().replaceAll("[,\\s\\[\\]]", "")));
                        break;
                    case 2:
                        k250.setCod_ltc(campo.toString().replaceAll("[,\\s\\[\\]]", ""));
                        break;
                    case 3:
                        k250.setCod_reg_trab(campo.toString().replaceAll("[,\\s\\[\\]]", ""));
                        break;
                    case 4:
                        k250.setDt_comp(Integer.parseInt(campo.toString().replaceAll("[,\\s\\[\\]]", "")));
                        break;
                    case 5:
                        if(campo.size()>1){
                            try {
                                String data = campo.toString().replaceAll("[,\\s\\[\\]]", "");
                                data = data.substring(0, 2)+'/'+data.substring(2, 4)+'/'+data.substring(4, 8);
                                k250.setDt_pgto(formato.parse(data));
                            } catch (ParseException ex) {
                                Logger.getLogger(C_K050.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        break;
                    case 6:
                        k250.setCod_cbo(Integer.parseInt(campo.toString().replaceAll("[,\\s\\[\\]]", "")));
                        break;
                    case 7:
                        k250.setCod_ocorr(Integer.parseInt(campo.toString().replaceAll("[,\\s\\[\\]]", "")));
                        break;
                    case 8:
                        k250.setDesc_cargo(campo.toString().replaceAll("[,\\s\\[\\]]", ""));
                        break;
                    case 9:
                        k250.setQtd_dep_ir(Integer.parseInt(campo.toString().replaceAll("[,\\s\\[\\]]", "")));
                        break;
                    case 10:
                        k250.setQtd_dep_sf(Integer.parseInt(campo.toString().replaceAll("[,\\s\\[\\]]", "")));
                        break;
                    case 11:
                        valor = campo.toString().replace(",,", ".");
                        valor = valor.replaceAll("[,\\s\\[\\]]", "");
                        k250.setVl_base_irrf(Float.parseFloat(valor));
                        break;    
                    case 12:
                        valor = campo.toString().replace(",,", ".");
                        valor = valor.replaceAll("[,\\s\\[\\]]", "");
                        k250.setVl_base_ps(Float.parseFloat(valor));
                        break;
                    default:
                        break;
                }
                campo.clear();
                tipo_campo++;
            }
            
            
        }
       return k250; 
    }

}
