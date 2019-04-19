/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Modelo_tabelas;

import Controller.C_Apuraçao; 
import Model.Rubrica_apuraçao;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class Model_table_rubr extends AbstractTableModel{

    String[] cabecalho = {"Rubrica", "Código", "Indicador de Previdência Social"};
    ArrayList<Rubrica_apuraçao> list_apuraçao;
    
    @Override
    public int getRowCount() {
        return list_apuraçao.size();
    }

    @Override
    public int getColumnCount() {
        return cabecalho.length;
    }
    
    @Override
    public String getColumnName(int index) {
        return cabecalho[index];
    }
    
    @Override
    public Object getValueAt(int linha, int coluna) {
        Rubrica_apuraçao apuraçao = list_apuraçao.get(linha);
        switch (coluna){
            case 0:
                return apuraçao.getRubrica();
                
            case 1:
                return apuraçao.getCod();
            default:
                return apuraçao.getInss();

        }  
    }
    
    public void setDados(ArrayList<Rubrica_apuraçao> lista_atual){
        if(lista_atual != null){
            list_apuraçao = lista_atual;
            this.fireTableDataChanged();
        }
        
    }
    
    public ArrayList<Rubrica_apuraçao> getList_apuraçao(){
        return list_apuraçao;
    }
    
}
