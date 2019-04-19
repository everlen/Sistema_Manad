/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Modelo_tabelas;

import Model.Relatorio;
import Model.Resumo_relatorio;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Everlen
 */
public class Model_table_resumo extends AbstractTableModel{
    
    // criar um modelo que mostre a quantidades de registros encontrados assim como outros dados interessantes nao demais linhas
    ArrayList<Resumo_relatorio> list_resumo_relatorio;
    String[] cabecalho = {"DT_COMP", "Quantidade de Registros Encontrados", "Somatória Rubrica"};
    
    @Override
    public int getRowCount() {
        return list_resumo_relatorio.size();
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
        Resumo_relatorio resumo = list_resumo_relatorio.get(linha);
        DecimalFormat format = new DecimalFormat("0.00");
        if(coluna == 0)
            return resumo.getString_dt_comp();
        else if(coluna == 1)
            return resumo.getQuantidade();
        else if(coluna == 2)
            return format.format(resumo.getSoma_rubrica());
        else
            return null;
    }
    
    public boolean setDados(ArrayList<Relatorio> List_Relatorio){
        boolean retorno = false;
        list_resumo_relatorio = new ArrayList<Resumo_relatorio>();
        
        int dt_comp;
        boolean inserir;
        for(Relatorio relatorio:List_Relatorio){
            dt_comp = relatorio.getK300().getDt_comp();
            inserir = true;
            for(int i = 0; i<list_resumo_relatorio.size(); i++){
                if(dt_comp == list_resumo_relatorio.get(i).getDt_comp()){
                    inserir = false;
                    list_resumo_relatorio.get(i).setQuantidade(list_resumo_relatorio.get(i).getQuantidade()+1);
                    list_resumo_relatorio.get(i).setSoma_rubrica(list_resumo_relatorio.get(i).getSoma_rubrica()+relatorio.getK300().getVlr_rubr());
                }
            }
            if(inserir){
                Resumo_relatorio resumo = new Resumo_relatorio();
                resumo.setDt_comp(dt_comp);
                resumo.setString_dt_comp();
                resumo.setQuantidade(1);
                resumo.setSoma_rubrica(relatorio.getK300().getVlr_rubr());               
                list_resumo_relatorio.add(resumo);
            }
            
        }
        
//Ordenador de lista por DT_COMP 

        ArrayList<Resumo_relatorio> list_resumo_relatorio_ordenada = new ArrayList<Resumo_relatorio>();
        String char_dt_comp, char_dt_comp_aux;
        int indice_menor;
        int size_inicio, size_atual;
        size_inicio = list_resumo_relatorio.size();

        for(int i = 0; i < size_inicio; i++){
            size_atual = list_resumo_relatorio.size();
            indice_menor = 0;
            for(int c = 0; c < size_atual; c++){
                char_dt_comp = String.valueOf(list_resumo_relatorio.get(indice_menor).getDt_comp());
                char_dt_comp_aux = String.valueOf(list_resumo_relatorio.get(c).getDt_comp());
                if(verificar_menor_dt_comp(char_dt_comp_aux, char_dt_comp)){
                    indice_menor = c;
                }                
            }
            list_resumo_relatorio_ordenada.add(list_resumo_relatorio.get(indice_menor));
            list_resumo_relatorio.remove(indice_menor);                
                
        }
        list_resumo_relatorio = list_resumo_relatorio_ordenada;

        return retorno;
    }
    
    boolean verificar_menor_dt_comp(String dt_comp_a, String dt_comp_b){
        boolean retorno;
        SimpleDateFormat format = new SimpleDateFormat("MMyyyy");
        java.util.Date data_a, data_b;
        try {
            if(dt_comp_a.length()<6)
                dt_comp_a = "0"+dt_comp_a;
            if(dt_comp_b.length()<6)
                dt_comp_b = "0"+dt_comp_b;
            data_a = format.parse(dt_comp_a);
            data_b = format.parse(dt_comp_b);
            
        } catch (ParseException ex) {
            Logger.getLogger(Model_table_resumo.class.getName()).log(Level.SEVERE, null, ex);
            data_a = null;
            data_b = null;
        }      
        retorno = data_a.before(data_b);
        
        return retorno;
    }
    
}

