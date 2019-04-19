/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Empresa;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Everlen
 */
public class C_Empresa {
    
    public static Empresa Filtrar(String linha){
        
        char[] vetor = new char[linha.length()];
        linha.getChars(0, linha.length(), vetor, 0);
        
        int tipo_campo = -1;
        ArrayList<Character> campo = new ArrayList<Character>();
        Empresa empresa = new Empresa();
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
                        char[] nome = new char[campo.size()];
                        int o = 0;
                        for(char c : campo){
                            nome[o]=c;
                            o++;
                        }
                        empresa.setNome(String.valueOf(nome));
                        break;
                    case 11:
                    try {
                        String data = campo.toString().replaceAll("[,\\s\\[\\]]", "");
                        data = data.substring(0, 2)+'/'+data.substring(2, 4)+'/'+data.substring(4, 8);
                        empresa.setInicio(formato.parse(data));
                    } catch (ParseException ex) {
                        Logger.getLogger(C_Empresa.class.getName()).log(Level.SEVERE, null, ex);
                        empresa.setInicio(null);
                    }
                        break;
                    case 12:
                    try {
                        String data = campo.toString().replaceAll("[,\\s\\[\\]]", "");
                        data = data.substring(0, 2)+'/'+data.substring(2, 4)+'/'+data.substring(4, 8);
                        empresa.setFim(formato.parse(data));
                    } catch (ParseException ex) {
                        Logger.getLogger(C_Empresa.class.getName()).log(Level.SEVERE, null, ex);
                    }
                        break;
                    default:
                        break;
                }
                campo.clear();
                tipo_campo++;
            }
            
            
        }
        return empresa;
    }
}
