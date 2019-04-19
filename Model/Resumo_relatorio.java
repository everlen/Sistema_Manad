/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Modelo_tabelas.Model_table_resumo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Everlen
 */
public class Resumo_relatorio {
    int dt_comp;
    String string_dt_comp;
    int quantidade;
    double soma_rubrica; 

    public int getDt_comp() {
        return dt_comp;
    }

    public void setDt_comp(int dt_comp) {
        this.dt_comp = dt_comp;
    }  

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getSoma_rubrica() {
        return soma_rubrica;
    }

    public void setSoma_rubrica(double soma_rubrica) {
        this.soma_rubrica = soma_rubrica;
    }

    public String getString_dt_comp() {
        return string_dt_comp;
    }

    public void setString_dt_comp() {
        SimpleDateFormat format = new SimpleDateFormat("MMyyyy");
        SimpleDateFormat format_exibir = new SimpleDateFormat("MM/yyyy");
        java.util.Date data_a;
        String dt_comp_a = String.valueOf(this.dt_comp);
        
        try {
            if(dt_comp_a.substring(0, 2).equals("13")){
                this.string_dt_comp = "13/" + dt_comp_a.substring(2);
            }
            else{
                if(dt_comp_a.length()<6)
                    dt_comp_a = "0"+dt_comp_a;
                data_a = format.parse(dt_comp_a);
                this.string_dt_comp = format_exibir.format(data_a);
            }    
        } catch (ParseException ex) {
            Logger.getLogger(Model_table_resumo.class.getName()).log(Level.SEVERE, null, ex);
            this.string_dt_comp = null;
        }      
        
    }
    
    
}
