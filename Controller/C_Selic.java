/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAO_Selic;
import Model.Selic;
import java.util.ArrayList;

/**
 *
 * @author Victony
 */
public class C_Selic {

    
    public static boolean Realizar_atualizaçao(ArrayList<ArrayList<String>> matriz_selic){
        boolean retorno = false;
        DAO_Selic dao_selic = new DAO_Selic();
        int ultimo_ano = Integer.parseInt(matriz_selic.get(matriz_selic.size()-1).get(0));
        if(dao_selic.Verificar_existencia_ano(ultimo_ano)){
            retorno = Atualizar_selic(matriz_selic);
        }
        else{
            retorno = Inserir_selic(matriz_selic);
        }
        return retorno;
    }
    
    public static boolean Inserir_selic(ArrayList<ArrayList<String>> matriz_selic){
        DAO_Selic dao_selic = new DAO_Selic();
        return dao_selic.Inserir_selic_completa(matriz_selic);
    }
    
    public static ArrayList<ArrayList<Selic>> Buscar_selic_completa(){
        DAO_Selic dao_selic = new DAO_Selic();
        return dao_selic.Buscar_selic_completa();
    }
    
    public ArrayList<ArrayList<String>> Tratar_matriz_selic(ArrayList<ArrayList<String>> matriz_tratada, ArrayList<ArrayList<String>> matriz_selic){
        ArrayList<ArrayList<String>> matriz_atualizada = null;

        
        for(int i = 0; i< matriz_selic.size(); i++){
            matriz_selic.get(i).remove(0);
        }
        if(matriz_tratada == null)
            matriz_atualizada = matriz_selic;
        else{
            boolean inserir = true;
            
            for(String ano_tratado: matriz_tratada.get(0)){
                for(String ano: matriz_selic.get(0)){
                    if(ano_tratado.equals(ano)){
                        inserir = false;
                        break;
                    }
                }      
            }
            if(inserir){
                matriz_atualizada = new ArrayList<ArrayList<String>>();
                
                if(Integer.parseInt(matriz_selic.get(0).get(0))<Integer.parseInt(matriz_tratada.get(0).get(0))){
//Inserir Antes                    
                    matriz_atualizada.addAll(matriz_selic);
                    
                    for(int i = 0; i< matriz_tratada.size(); i++){
                        for( int c = 0; c < matriz_tratada.get(i).size(); c++){
                            matriz_atualizada.get(i).add(matriz_tratada.get(i).get(c));
                        }   
                    }  
                }
                else{
//Inserir depois                    
                    matriz_atualizada.addAll(matriz_tratada);
                    
                    for(int i = 0; i< matriz_selic.size(); i++){
                        for( int c = 0; c < matriz_selic.get(i).size(); c++){
                            matriz_atualizada.get(i).add(matriz_selic.get(i).get(c));
                        }      
                    }
                }         
            }
            else{
                matriz_atualizada = matriz_tratada;
            }
        }

        
        return matriz_atualizada;
    }
    
    public static void Excluir_tudo(){
        new DAO_Selic().Excluir_tudo();
    }
    
    public static boolean Atualizar_selic(ArrayList<ArrayList<String>> matriz_selic){
        return new DAO_Selic().Atualizar_selic(matriz_selic);
    }
    
    public static ArrayList<Selic> Organizar_lista_PDF(ArrayList<Selic> list_selic){
        ArrayList<Selic> lista_selic_tratada = new ArrayList<Selic>();
        
        int ano_inicial = list_selic.get(0).getAno();
        int ano_final = list_selic.get(list_selic.size()-1).getAno();
            
        for(int mes = 1; mes <= 12; mes++){
            
            for(int ano = ano_inicial; ano <= ano_final; ano++){    
                
                for(Selic selic: list_selic){
                    if(selic.getAno() == ano && selic.getMes() == mes){
                        lista_selic_tratada.add(selic);
                        break;
                    }
                }
                
            }           
        }
        
        
        
        
        return lista_selic_tratada;
    }
}
