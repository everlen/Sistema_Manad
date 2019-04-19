/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAO_K150;
import Model.K150;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Everlen
 */
public class C_K150 {
    
    public static boolean Inserir(ArrayList<K150> list_k150){
        boolean retorno;
        DAO_K150 dao = new DAO_K150();
        retorno = dao.Inserir(list_k150);
        return retorno;
    }
    
    public static K150 Filtrar(String linha){
        
        char[] vetor = new char[linha.length()];
        linha.getChars(0, linha.length(), vetor, 0);
        
        int tipo_campo = -1;
        ArrayList<Character> campo = new ArrayList<Character>();
        K150 k150 = new K150();
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
                        k150.setCnpj(campo.toString().replaceAll("[,\\s\\[\\]]", ""));
                        break;
                    case 1:
                        if(campo.size()>1){
                            try {
                                String data = campo.toString().replaceAll("[,\\s\\[\\]]", "");
                                data = data.substring(0, 2)+'/'+data.substring(2, 4)+'/'+data.substring(4, 8);
                                k150.setDt_inc_alt(formato.parse(data));
                            } catch (ParseException ex) {
                                Logger.getLogger(C_K050.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        
                        break;
                    case 2:
                        k150.setCod_rubrica(campo.toString().replaceAll("[,\\s\\[\\]]", ""));
                        break;
                    case 3:
                        char[] nome = new char[campo.size()];
                        int o = 0;
                        for(char c : campo){
                            nome[o]=c;
                            o++;
                        }
                        k150.setDesc_rubrica(String.valueOf(nome));
                        break;
                    default:
                        break;
                }
                campo.clear();
                tipo_campo++;
            }
            
            
        }
        return k150;
    }
    public static ArrayList<String> Verificar_cnpj(ArrayList<K150> list_registro){
        ArrayList<String> list_cnpj = new ArrayList<String>();
        list_cnpj.add(list_registro.get(0).getCnpj());
        String cnpj;
        for(K150 k150 : list_registro){
            for(int i = 0; i < list_cnpj.size(); i++){
                cnpj = list_cnpj.get(i);
                if(!k150.getCnpj().equals(cnpj))
                    list_cnpj.add(k150.getCnpj());     
            }  
        }
        
        return list_cnpj;
    }
    
    public static ArrayList<K150> Buscar_existentes (){
        DAO_K150 dao = new DAO_K150();
        ArrayList<K150> list_k150 =  dao.Buscar_todos();
        return list_k150;        
    }

    public static ArrayList<K150> Buscar_filtro_combo(ArrayList<K150> lista_atual, String filtro){
        ArrayList<K150> retorno = null;
        
        
        return retorno;
    }
    
    
}
