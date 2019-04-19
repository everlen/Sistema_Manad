/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAO_K050;
import Model.K050;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Everlen
 */
public class C_K050 {
    
    public static boolean Inserir(ArrayList<K050> list_k050){
        boolean retorno;
        DAO_K050 dao = new DAO_K050();
        retorno = dao.Inserir(list_k050);
        return retorno;
    }
    
    
    
    
    public static K050 Filtrar(String linha){
        
        char[] vetor = new char[linha.length()];
        linha.getChars(0, linha.length(), vetor, 0);
        
        int tipo_campo = -1;
        ArrayList<Character> campo = new ArrayList<Character>();
        K050 k050 = new K050();
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
                        k050.setCnpj(campo.toString().replaceAll("[,\\s\\[\\]]", ""));
                        break;
                    case 1:
                       if(campo.size()>1){
                            try {
                                String data = campo.toString().replaceAll("[,\\s\\[\\]]", "");
                                data = data.substring(0, 2)+'/'+data.substring(2, 4)+'/'+data.substring(4, 8);
                                k050.setDt_inc_alt(formato.parse(data));
                            } catch (ParseException ex) {
                                Logger.getLogger(C_K050.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        break;
                    case 2:
                        k050.setCod_reg_trab(campo.toString().replaceAll("[,\\s\\[\\]]", ""));
                        break;
                    case 3:
                        k050.setCpf(campo.toString().replaceAll("[,\\s\\[\\]]", "").toCharArray());
                        break;
                    case 4:
                        k050.setNit(campo.toString().replaceAll("[,\\s\\[\\]]", "").toCharArray());
                        break;
                    case 5:
                        k050.setCod_categ(Integer.parseInt(campo.toString().replaceAll("[,\\s\\[\\]]", "")));
                        break;
                    case 6:
                        char[] nome = new char[campo.size()];
                        int o = 0;
                        for(char c : campo){
                            nome[o]=c;
                            o++;
                        }
                        k050.setNome_trab(String.valueOf(nome));
                        break;
                    case 7:
                        try {
                            String data = campo.toString().replaceAll("[,\\s\\[\\]]", "");
                            data = data.substring(0, 2)+'/'+data.substring(2, 4)+'/'+data.substring(4, 8);
                            k050.setDt_nasc(formato.parse(data));
                        } catch (ParseException ex) {
                            Logger.getLogger(C_K050.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        break;
                    case 8:

                        try {
                            String data = campo.toString().replaceAll("[,\\s\\[\\]]", "");
                            data = data.substring(0, 2)+'/'+data.substring(2, 4)+'/'+data.substring(4, 8);
                            k050.setDt_admissao(formato.parse(data));
                        } catch (ParseException ex) {
                            Logger.getLogger(C_K050.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        break;
                    case 9:
                        if(campo.size()>1){
                            try {
                                String data = campo.toString().replaceAll("[,\\s\\[\\]]", "");
                                data = data.substring(0, 2)+'/'+data.substring(2, 4)+'/'+data.substring(4, 8);
                                k050.setDt_demissao(formato.parse(data));
                            } catch (ParseException ex) {
                                Logger.getLogger(C_K050.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        break;
                    case 10:
                        if(campo.size()>0)
                        k050.setInd_vinc(Integer.parseInt(campo.toString().replaceAll("[,\\s\\[\\]]", "")));
                        break;
                    case 11:
                        if(campo.size()>0)
                            k050.setTipo_ato_nom(Integer.parseInt(campo.toString().replaceAll("[,\\s\\[\\]]", "")));
                        break;
                    case 12:
                        if(campo.size()>0)
                            k050.setNm_ato_nom(campo.toString().replaceAll("[,\\s\\[\\]]", ""));
                        break;
                    case 13:
                        if(campo.size()>1){
                            try {
                                String data = campo.toString().replaceAll("[,\\s\\[\\]]", "");
                                data = data.substring(0, 2)+'/'+data.substring(2, 4)+'/'+data.substring(4, 8);
                                k050.setDt_ato_nom(formato.parse(data));
                            } catch (ParseException ex) {
                                Logger.getLogger(C_K050.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        break;
                    default:
                        break;
                }
                campo.clear();
                tipo_campo++;
            }
            
            
        }
       
      return k050;  
    }
    
    public static ArrayList<String> Verificar_cnpj(ArrayList<K050> list_registro){
        ArrayList<String> list_cnpj = new ArrayList<String>();
        list_cnpj.add(list_registro.get(0).getCnpj());
        String cnpj;
        for(K050 k050 : list_registro){
            for(int i = 0; i < list_cnpj.size(); i++){
                cnpj = list_cnpj.get(i);
                if(!k050.getCnpj().equals(cnpj))
                    list_cnpj.add(k050.getCnpj());     
            }  
        }

        
        return list_cnpj;
    }
}
