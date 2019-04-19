/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Selic;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DAO_Selic extends Conexao{
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    
    public boolean Inserir_selic_completa(ArrayList<ArrayList<String>> matriz_selic){
        boolean retorno = true;
        query = "insert into tb_selic values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        try {
            ps = con.prepareStatement(query);
        } catch (SQLException ex) {
            retorno = false;
        }
        if(retorno){           
            for(ArrayList<String> linha_selic : matriz_selic){
                for(int i =0; i< linha_selic.size(); i++){
                    if(retorno){
                        try {
                            if(linha_selic.get(i) != " "){
                                if(i == 0)
                                    ps.setInt(1, Integer.parseInt(linha_selic.get(i)));
                                else
                                    ps.setFloat(i+1, Float.parseFloat(linha_selic.get(i)));
                            }
                            else{
                                ps.setFloat(i+1, -1);
                            }
                        } catch (SQLException ex) {
                            retorno = false;
                        }
                    }
                    else{
                        break;
                    }
                }
                try {
                    if (ps.executeUpdate()<=0)
                        retorno = false;
                } catch (SQLException ex) {
                    retorno = false;
                }
                if(!retorno)
                    break;
            }
        }    
 
        return retorno;
    }
    
    public void Excluir_tudo(){
        query = "DELETE from tb_selic";
        try {
            ps = con.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Selic.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    public ArrayList<ArrayList<Selic>> Buscar_selic_completa(){
        ArrayList<ArrayList<Selic>> retorno = null;
        query = "SELECT * FROM `tb_selic` order by Ano";
        
        try {
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next()){
                if(retorno == null)
                    retorno = new ArrayList<ArrayList<Selic>>();
                
                ArrayList<Selic> linha_mes = new ArrayList<Selic>();
                for(int i =1; i<13; i++){
                    Selic selic = new Selic();                
                    selic.setAno(rs.getInt("Ano"));
                    selic.setMes(i);
                    if(i ==1)
                        selic.setPorcentagem(rs.getFloat("Janeiro"));
                    else if(i ==2)
                        selic.setPorcentagem(rs.getFloat("Fevereiro"));
                    else if(i ==3)
                        selic.setPorcentagem(rs.getFloat("Março"));
                    else if(i ==4)
                        selic.setPorcentagem(rs.getFloat("Abril"));
                    else if(i ==5)
                        selic.setPorcentagem(rs.getFloat("Maio"));
                    else if(i ==6)
                        selic.setPorcentagem(rs.getFloat("Junho"));
                    else if(i ==7)
                        selic.setPorcentagem(rs.getFloat("Julho"));
                    else if(i ==8)
                        selic.setPorcentagem(rs.getFloat("Agosto"));
                    else if(i ==9)
                        selic.setPorcentagem(rs.getFloat("Setembro"));
                    else if(i ==10)
                        selic.setPorcentagem(rs.getFloat("Outubro"));
                    else if(i ==11)
                        selic.setPorcentagem(rs.getFloat("Novembro"));
                    else if(i ==12)
                        selic.setPorcentagem(rs.getFloat("Dezembro"));
                    
                    linha_mes.add(selic);
                }
                
                retorno.add(linha_mes);
            } 
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Selic.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return retorno;
    }
    
    public boolean Atualizar_selic (ArrayList<ArrayList<String>> matriz_selic){
        boolean retorno = true;
        query = "update tb_selic set tb_selic.Ano = ?, tb_selic.Janeiro = ?, tb_selic.Fevereiro = ?, tb_selic.Março = ?, tb_selic.Abril = ?, tb_selic.Maio = ?, tb_selic.Junho = ?, tb_selic.Julho = ?, tb_selic.Agosto = ?, tb_selic.Setembro = ?, tb_selic.Outubro = ?, tb_selic.Novembro = ?, tb_selic.Dezembro = ? where tb_selic.Ano = ?";
        
         try {
            ps = con.prepareStatement(query);
        } catch (SQLException ex) {
            retorno = false;
        }
        if(retorno){           
            for(ArrayList<String> linha_selic : matriz_selic){
                for(int i =0; i< linha_selic.size(); i++){
                    if(retorno){
                        try {
                            if(linha_selic.get(i) != " "){
                                if(i == 0){
                                    ps.setInt(1, Integer.parseInt(linha_selic.get(i)));
                                    ps.setInt(14, Integer.parseInt(linha_selic.get(i)));
                                }
                                    
                                else
                                    ps.setFloat(i+1, Float.parseFloat(linha_selic.get(i)));
                            }
                            else{
                                ps.setFloat(i+1, -1);
                            }
                        } catch (SQLException ex) {
                            retorno = false;
                        }
                    }
                    else{
                        break;
                    }
                }
                try {
                    if (ps.executeUpdate()<=0)
                        retorno = false;
                } catch (SQLException ex) {
                    retorno = false;
                }
                if(!retorno)
                    break;
            }
        }    
        return retorno;
    }
    
    public boolean Verificar_existencia_ano(int Ano){
        boolean retorno = false;
        query = "select tb_selic.Ano from tb_selic where tb_selic.Ano = ?";
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, Ano);
            rs = ps.executeQuery();
            if(rs.next())
                retorno = true;
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Selic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
}
