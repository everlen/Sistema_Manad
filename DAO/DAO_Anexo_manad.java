/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Anexo_manad;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Everlen
 */
public class DAO_Anexo_manad extends Conexao{
    private PreparedStatement ps = null;
    private ResultSet rs = null; 
    
    /*public Anexo_manad Buscar (String cnpj){
        Anexo_manad anexo = new Anexo_manad();
        
        query = "select * from tb_cnpj where CNPJ = ?";
        
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, cnpj);
            rs = ps.executeQuery();
            if(rs.next()){
                int Id = rs.getInt("Id_arquivo");
                query = "select * from arquivo_manad where Id = ?";
                
                ps = con.prepareStatement(query);
                ps.setInt(1, Id);
                rs = ps.executeQuery();
                if(rs.next()){
                    anexo.setId(rs.getInt("Id"));
                    anexo.setBytes(rs.getBytes("Arquivo"));
                }
                else{
                    anexo = null;
                }
            }else{
                anexo = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Anexo_manad.class.getName()).log(Level.SEVERE, null, ex);
            anexo = null;
        }
        
       return anexo;
   }
    */
    public boolean Inserir_cnpj (ArrayList<String> list_cnpj){
        boolean retorno = false;
        
        query = "insert into tb_cnpj values(?)";
        try {
            ps = con.prepareStatement(query);
            for(String cnpj : list_cnpj){
                ps.setString(1, cnpj);
                if (ps.executeUpdate()>0)
                    retorno = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Anexo_manad.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }
       return retorno; 
    }
    /*
    public boolean Limpar_tabela (ArrayList<String> list_cnpj){
        boolean retorno = true;
        Anexo_manad anexo = Buscar(list_cnpj.get(0));
        try {
            query = "DELETE FROM k050 WHERE CNPJ_CEI = ?; ";
            ps = con.prepareStatement(query);
            for(String cnpj:list_cnpj){ 
                ps.setString(1, cnpj);
                if(ps.executeUpdate()<=0){
                        retorno = false;
                }
            }     
            query = "DELETE FROM k100 WHERE CNPJ_CEI = ?; ";
            ps = con.prepareStatement(query);
            for(String cnpj:list_cnpj){ 
                ps.setString(1, cnpj);
                if(ps.executeUpdate()<=0){
                        retorno = false;
                }
            }
            query = "DELETE FROM k150 WHERE CNPJ_CEI = ?; ";
            ps = con.prepareStatement(query);
            for(String cnpj:list_cnpj){ 
               ps.setString(1, cnpj);
               if(ps.executeUpdate()<=0){
                       retorno = false;
               }
            }
            query = "DELETE FROM k200 WHERE CNPJ_CEI = ?; ";
            ps = con.prepareStatement(query);
            for(String cnpj:list_cnpj){ 
               ps.setString(1, cnpj);
               if(ps.executeUpdate()<=0){
                       retorno = false;
               }
            }
            query = "DELETE FROM k250 WHERE CNPJ_CEI = ?; ";
            ps = con.prepareStatement(query);
            for(String cnpj:list_cnpj){ 
               ps.setString(1, cnpj);
               if(ps.executeUpdate()<=0){
                       retorno = false;
               }
            }
            query = "DELETE FROM k300 WHERE CNPJ_CEI = ?; ";
            ps = con.prepareStatement(query);
            for(String cnpj:list_cnpj){ 
               ps.setString(1, cnpj);
               if(ps.executeUpdate()<=0){
                       retorno = false;
               }
            }
            query = "DELETE FROM tb_cnpj WHERE CNPJ = ?; ";
            ps = con.prepareStatement(query);
            for(String cnpj:list_cnpj){ 
               ps.setString(1, cnpj);
               if(ps.executeUpdate()<=0){
                       retorno = false;
               }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Anexo_manad.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }
        
        return retorno;
    }
    */
    public boolean Limpar_banco (){
        boolean retorno = true;
        
        try {
            query = "delete from k050;";
            ps = con.prepareStatement(query);
            ps.execute();
            
            query = "delete from k100;";
            ps = con.prepareStatement(query);
            ps.execute();
            
            query = "delete from k150;";
            ps = con.prepareStatement(query);
            ps.execute();
            
            query = "delete from k200;";
            ps = con.prepareStatement(query);
            ps.execute();
            
            query = "delete from k250;";
            ps = con.prepareStatement(query);
            ps.execute();
            
            query = "delete from k300;";
            ps = con.prepareStatement(query);
            ps.execute();
            
            query = "delete from tb_cnpj;";
            ps = con.prepareStatement(query);
            ps.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Anexo_manad.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }
        
        return retorno;
    }

}
