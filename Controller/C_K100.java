/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAO_K100;
import Model.K100;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Everlen
 */
public class C_K100 {
    
    public static boolean Inserir(ArrayList<K100> list_k100){
        boolean retorno;
        DAO_K100 dao = new DAO_K100();
        retorno = dao.Inserir(list_k100);
        return retorno;
    }
    
    public static K100 Filtrar(String linha){
        
        char[] vetor = new char[linha.length()];
        linha.getChars(0, linha.length(), vetor, 0);
        
        int tipo_campo = -1;
        ArrayList<Character> campo = new ArrayList<Character>();
        K100 k100 = new K100();
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
                                k100.setDt_inc_alt(formato.parse(data));
                            } catch (ParseException ex) {
                                Logger.getLogger(C_K050.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        break;
                    case 1:
                        k100.setCod_ltc(campo.toString().replaceAll("[,\\s\\[\\]]", ""));
                        break;
                    case 2:
                        k100.setCnpj(campo.toString().replaceAll("[,\\s\\[\\]]", ""));
                        break;
                    case 3:
                        k100.setDesc_ltc(campo.toString().replaceAll("[,\\s\\[\\]]", ""));
                        break;
                    case 4:
                        k100.setCnpj_tom(campo.toString().replaceAll("[,\\s\\[\\]]", ""));
                        break;
                    default:
                        break;
                }
                campo.clear();
                tipo_campo++;
            }
            
            
        }
        return k100;
    }
    public static ArrayList<String> Verificar_cnpj(ArrayList<K100> list_registro){
        ArrayList<String> list_cnpj = new ArrayList<String>();
        if(list_registro.size()>0){
            list_cnpj.add(list_registro.get(0).getCnpj());
            String cnpj;
            for(K100 k100 : list_registro){
                for(int i = 0; i < list_cnpj.size(); i++){
                    cnpj = list_cnpj.get(i);
                    if(!k100.getCnpj().equals(cnpj))
                        list_cnpj.add(k100.getCnpj());     
                }  
            }
        }
        
        return list_cnpj;
    }
    
    public static ArrayList<K100> Buscar_existentes (){
        DAO_K100 dao = new DAO_K100();
        ArrayList<K100> list_k100 =  dao.Buscar_todos();
        return list_k100;        
    }
}
