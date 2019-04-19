/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Modelo_tabelas;

import Model.Selic;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class Model_table_selic extends AbstractTableModel{

    ArrayList<ArrayList<Selic>> matriz_selic = null;
    String[] cabeçalho = {"Ano", "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
    public void setDados(ArrayList<ArrayList<Selic>> matriz_selic_banco){
        matriz_selic = matriz_selic_banco;
        if(matriz_selic == null)
            matriz_selic = new ArrayList<ArrayList<Selic>>();
    }
    
    @Override
    public int getRowCount() {
        return matriz_selic.size();
    }
    
    @Override
    public String getColumnName(int index) {
        return cabeçalho[index];
    }
    
    @Override
    public int getColumnCount() {
        return cabeçalho.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        String retorno;
        if(coluna == 0)
            retorno = String.valueOf(matriz_selic.get(linha).get(0).getAno());
        else{
            if(matriz_selic.get(linha).get(coluna - 1).getPorcentagem() == -1)
                retorno = "-";
            else
                retorno = String.valueOf(matriz_selic.get(linha).get(coluna - 1).getPorcentagem());
        }
             
        return retorno;
    }
    
}
