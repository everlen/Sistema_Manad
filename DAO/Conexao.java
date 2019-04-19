/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Everlen
 */
public class Conexao {
    protected Connection con;
    protected Statement st;
    protected String query;


    public Conexao() {

        try{

            final String URL = "jdbc:mysql://localhost/bd_manad?zeroDateTimeBehavior=round";
            final String DRIVER = "com.mysql.jdbc.Driver";
            final String USUARIO = "root";
            final String SENHA = "";
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL,USUARIO,SENHA);
            st = con.createStatement();
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
    
    public boolean Max_connections(int valor){
        PreparedStatement ps = null;
            
        try {
            query = "set global max_connections = ?;";
            ps = con.prepareStatement(query);
            ps.setInt(1, valor);
            if (ps.executeUpdate()>0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
