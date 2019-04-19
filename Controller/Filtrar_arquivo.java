/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Empresa;
import Model.K050;
import Model.K100;
import Model.K150;
import Model.K200;
import Model.K250;
import Model.K300;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Everlen
 */
public class Filtrar_arquivo{
    
    
    
    public static Empresa Inserir_registros(FileReader FR_file){
        FileReader FR_file_inteiro = FR_file;
        BufferedReader BR_file = new BufferedReader(FR_file); 
        String linha = null;
        char[] char_tipo = new char[4];
        
        ArrayList<K050> list_k050 = new ArrayList();
        ArrayList<K100> list_k100 = new ArrayList();
        ArrayList<K150> list_k150 = new ArrayList();
        ArrayList<K200> list_k200 = new ArrayList();
        ArrayList<K250> list_k250 = new ArrayList();
        ArrayList<K300> list_k300 = new ArrayList();
        
        ArrayList<String> list_cnpj = null;
        boolean erro = true;
        Empresa empresa = new Empresa();

        try {
            linha = BR_file.readLine();
        
            while(linha != null){
//ações durante a leitura da linha 
                linha.getChars(0, 4, char_tipo, 0);
                String string_tipo = new String(char_tipo);
                if(erro){
                    if(char_tipo[0]=='K'){
                        if(string_tipo.equals("K050"))
                        {
                            K050 k050 = C_K050.Filtrar(linha);
                            list_k050.add(k050);
                        }   
                        else if(string_tipo.equals("K100"))
                        {
                            if(list_k050!=null){
                                list_cnpj = C_K050.Verificar_cnpj(list_k050);
                                erro = C_K050.Inserir(list_k050);
                                list_k050=null;
                            }
                            K100 k100 = C_K100.Filtrar(linha);
                            list_k100.add(k100);
                        }  
                        else if(string_tipo.equals("K150"))
                        {
                            
                            if(list_k100 != null){
                                if(list_k100.size() == 0){
                                    list_cnpj = C_K050.Verificar_cnpj(list_k050);
                                    erro = C_K050.Inserir(list_k050);
                                    list_k050=null;
                                }
                                list_cnpj.addAll(C_K100.Verificar_cnpj(list_k100));
                                erro = C_K100.Inserir(list_k100);
                                list_k100=null;
                            }
                            
                            K150 k150 = C_K150.Filtrar(linha);
                            list_k150.add(k150);
                        }  
                        else if(string_tipo.equals("K200"))
                        {
                            if(list_k150!=null){
                                list_cnpj.addAll(C_K150.Verificar_cnpj(list_k150));
                                erro = C_K150.Inserir(list_k150);
                                list_k150=null;
                            }
                            
                            K200 k200 = C_K200.Filtrar(linha);
                            list_k200.add(k200);
                            
                        }  
                        else if(string_tipo.equals("K250"))
                        {
                            
                            if(list_k200!=null){
                                list_cnpj.addAll(C_K200.Verificar_cnpj(list_k200));
                                erro = C_K200.Inserir(list_k200);
                                list_k200=null;
                            }
                            
                            K250 k250 = C_K250.Filtrar(linha);
                            list_k250.add(k250);
                            
                        }  
                        else if(string_tipo.equals("K300"))
                        {
                            
                            if(list_k250!=null){
                                erro = C_K250.Inserir(list_k250);
                                list_k250=null;
                            }
                            
                            K300 k300 = C_K300.Filtrar(linha);
                            list_k300.add(k300);  
                        } 
                        else if(string_tipo.equals("K990"))
                        {   
                            if(list_k300!=null){
                                erro = C_K300.Inserir(list_k300);
                                list_k300=null;
                            }
                        }
                    }
                    else if(char_tipo[0]=='0'){             
// Puxar nome e dados da empresa
                        if(string_tipo.equals("0000")){
                            empresa = C_Empresa.Filtrar(linha);
                        }
                        
                    }
                    else{
                        // Outros tipos de registro  
                    }
                }
                else{          
//filtro de erro
                    list_cnpj = null;
                    break;
                }
                linha = BR_file.readLine();
            }
            BR_file.close();
            
            if(list_cnpj != null){
                ArrayList<String> list_cnpj_inserido = new ArrayList();
                list_cnpj_inserido.add(list_cnpj.get(0));
                String cnpj_verificador = list_cnpj_inserido.get(0);
                for(String cnpj: list_cnpj){
                    for(int i = 0; i<list_cnpj_inserido.size(); i++){
                        if(!cnpj.equals(cnpj_verificador))
                            list_cnpj_inserido.add(cnpj); 
                        cnpj_verificador = list_cnpj_inserido.get(i);
                    }    
                }
                if(list_cnpj_inserido.size()<=0)
                    list_cnpj_inserido = null;

                list_cnpj = list_cnpj_inserido;
            } 
        } catch (IOException ex) {
            Logger.getLogger(Filtrar_arquivo.class.getName()).log(Level.SEVERE, null, ex);
            list_cnpj = null;
        }

        if(list_cnpj==null)
            empresa = null;
        else
            empresa.setCNPJ(list_cnpj);
        return empresa;
    }

   
}
