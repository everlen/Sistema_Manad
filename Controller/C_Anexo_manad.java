/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAO_Anexo_manad;
import Model.Anexo_manad;
import java.util.ArrayList;

/**
 *
 * @author Everlen
 */
public class C_Anexo_manad {

   public static boolean Inserir (ArrayList<String> list_cnpj){
       boolean resposta = false;
       
       DAO_Anexo_manad dao = new DAO_Anexo_manad();
       resposta = dao.Inserir_cnpj(list_cnpj);
       
       return resposta;
   }
   /*
   public static Anexo_manad Buscar (String cnpj){
       DAO_Anexo_manad dao = new DAO_Anexo_manad();
       return dao.Buscar(cnpj);
   }
   
   public static boolean Limpar_tabela (ArrayList<String> list_cnpj){
        boolean retorno = true;
        DAO_Anexo_manad dao = new DAO_Anexo_manad();
        retorno = dao.Limpar_tabela(list_cnpj);
        return retorno;
   }
    */
   public static boolean Limpar_banco (){
        boolean retorno = true;
        DAO_Anexo_manad dao = new DAO_Anexo_manad();
        retorno = dao.Limpar_banco();
        return retorno;
   }

}
