/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAO_K200;
import Model.K200;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Everlen
 */
public class C_K200 {
    
    public static boolean Inserir(ArrayList<K200> list_k200){
        boolean retorno;
        DAO_K200 dao = new DAO_K200();
        retorno = dao.Inserir(list_k200);
        return retorno;
    }
    
    public static K200 Filtrar(String linha){
        
        char[] vetor = new char[linha.length()];
        linha.getChars(0, linha.length(), vetor, 0);
        
        int tipo_campo = -1;
        ArrayList<Character> campo = new ArrayList<Character>();
        K200 k200 = new K200();
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
                        if(campo.size()>1){
                            try {
                                String data = campo.toString().replaceAll("[,\\s\\[\\]]", "");
                                data = data.substring(0, 2)+'/'+data.substring(2, 4)+'/'+data.substring(4, 8);
                                k200.setDt_inc_alt(formato.parse(data));
                            } catch (ParseException ex) {
                                Logger.getLogger(C_K050.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        break;
                    case 1:
                        k200.setCnpj(campo.toString().replaceAll("[,\\s\\[\\]]", ""));
                        break;
                    case 2:
                        k200.setCod_rubrica(campo.toString().replaceAll("[,\\s\\[\\]]", ""));
                        break;
                    case 3:
                        k200.setCod_ltc(campo.toString().replaceAll("[,\\s\\[\\]]", ""));
                        break;
                    case 4:
                        k200.setCod_ccus(campo.toString().replaceAll("[,\\s\\[\\]]", ""));
                        break;
                    case 5:
                        k200.setCod_cta(campo.toString().replaceAll("[,\\s\\[\\]]", ""));
                        break;
                    default:
                        break;
                }
                campo.clear();
                tipo_campo++;
            }
            
            
        }
        return k200;
    }
    public static ArrayList<String> Verificar_cnpj(ArrayList<K200> list_registro){
        ArrayList<String> list_cnpj = new ArrayList<String>();
        list_cnpj.add(list_registro.get(0).getCnpj());
        String cnpj;
        for(K200 k200 : list_registro){
            for(int i = 0; i < list_cnpj.size(); i++){
                cnpj = list_cnpj.get(i);
                if(!k200.getCnpj().equals(cnpj))
                    list_cnpj.add(k200.getCnpj());     
            }  
        }
        
        return list_cnpj;
    }
}
