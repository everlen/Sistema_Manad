/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Modelo_tabelas;

import Model.Relatorio;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class Model_table_relatorio extends AbstractTableModel{
        
    String[] cabecalho_k050 = {"DT_INC_ALT (K050)","COD_REG_TRAB", "CPF", "NIT", "COD_CATEG", "NOME_TRAB", "DT_NASC", "DT_ADMISSAO", "DT_DEMISSAO", "IND_VINC", "TIPO_ATO_NOM", "NM_ATO_NOM", "DT_ATO_NOM"};
    String[] cabecalho_k100 = {"DT_INC_ALT (K100)", "COD_LTC", "DESC_LTC", "CNPJ_CEI_TOM"};
    String[] cabecalho_k150 = {"DT_INC_ALT (K150)", "COD_RUBR", "DESC_RUBR"};
    String[] cabecalho_k200 = {"DT_INC_ALT (K200)", "COD_CCUS", "COD_CTA"};
    String[] cabecalho_k250 = {"IND_FL", "DT_COMP", "DT_PGTO", "COD_CBO", "COD_OCORR", "DESC_CARGO", "QTD_DEP_IR", "QTD_DEP_SF", "VL_BASE_IRRF", "VL_BASE_PS"};
    String[] cabecalho_k300 = {"CNPJ_CEI", "IND_FL", "DT_COMP", "VLR_RUBR", "IND_RUBR", "IND_BASE_IRRF", "IND_BASE_PS"};
    
    ArrayList<String> cabecalho_exibido = new ArrayList<String>();
    
    ArrayList<ArrayList<String>> list_dados = null;
    ArrayList<ArrayList<String>> list_linhas = null;
    
    boolean[] retorno_nulls = new boolean[6];
    
    int int_k050 = -1, int_k100 = -1, int_k150 = -1, int_k200 = -1, int_k250 = -1, int_k300 = -1;
    
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    
    
    @Override
    public int getRowCount() {
        return list_linhas.size();
    }

    @Override
    public int getColumnCount() {
        return cabecalho_exibido.size();
    }

    @Override
    public String getColumnName(int index) {
        return cabecalho_exibido.get(index);
    }
    
    @Override
    public Object getValueAt(int linha, int coluna) {
        return list_linhas.get(linha).get(coluna);
    }
    
    public boolean[] setDados(ArrayList<Relatorio> List_Relatorio){
        list_dados = new ArrayList<ArrayList<String>>();
        ArrayList<String> dados_linha = new ArrayList<String>();
        
        retorno_nulls[0] = false;
        retorno_nulls[1] = false;
        retorno_nulls[2] = false;
        retorno_nulls[3] = false;
        retorno_nulls[4] = false;
        retorno_nulls[5] = false;
        
        for(Relatorio relatorio : List_Relatorio){
           
            dados_linha = new ArrayList<String>();
            
            if(relatorio.k050!= null){
                if(int_k050 == -1)
                    int_k050 = dados_linha.size();
                
                if(relatorio.k050.getDt_inc_alt()!=null)
                dados_linha.add(formato.format(relatorio.k050.getDt_inc_alt()));
                else
                    dados_linha.add("-");
                dados_linha.add(relatorio.k050.getCod_reg_trab());
                dados_linha.add(String.valueOf(relatorio.k050.getCpf()));
                dados_linha.add(String.valueOf(relatorio.k050.getNit()));
                dados_linha.add(String.valueOf(relatorio.k050.getCod_categ()));
                dados_linha.add(relatorio.k050.getNome_trab());
                dados_linha.add(formato.format(relatorio.k050.getDt_nasc()));
                dados_linha.add(formato.format(relatorio.k050.getDt_admissao()));
                if(relatorio.k050.getDt_demissao()!=null)
                    dados_linha.add(formato.format(relatorio.k050.getDt_demissao()));
                else
                    dados_linha.add("-");
                dados_linha.add(relatorio.k050.getString_IND_VINC());           
                dados_linha.add(relatorio.k050.getString_TIPO_ATO_NOM());
                if(relatorio.k050.getNm_ato_nom()!=null)
                    dados_linha.add(relatorio.k050.getNm_ato_nom());
                else
                    dados_linha.add("-");
                if(relatorio.k050.getDt_ato_nom()!=null)
                    dados_linha.add(formato.format(relatorio.k050.getDt_ato_nom()));
                else
                    dados_linha.add("-");
                
                retorno_nulls[0] = true;
            }
            else if(retorno_nulls[0]){
                dados_linha.add("-");
                dados_linha.add("-");
                dados_linha.add("-");
                dados_linha.add("-");
                dados_linha.add("-");
                dados_linha.add("-");
                dados_linha.add("-");
                dados_linha.add("-");
                dados_linha.add("-");
                dados_linha.add("-");
                dados_linha.add("-");
                dados_linha.add("-");
                dados_linha.add("-");
            }
            
            if(relatorio.k100!= null){
                if(int_k100 == -1)
                    int_k100 = dados_linha.size();
              
                dados_linha.add(formato.format(relatorio.k100.getDt_inc_alt()));
                dados_linha.add(relatorio.k100.getCod_ltc());
                dados_linha.add(relatorio.k100.getDesc_ltc());
                dados_linha.add(relatorio.k100.getCnpj_tom());
                              
                retorno_nulls[1] = true;
            }
            else if(retorno_nulls[1]){
                dados_linha.add("-");
                dados_linha.add("-");
                dados_linha.add("-");
                dados_linha.add("-");
            }
            
            if(relatorio.k150!=null){
                if(int_k150 == -1)
                    int_k150 = dados_linha.size();
                
                dados_linha.add(formato.format(relatorio.k150.getDt_inc_alt()));
                dados_linha.add(relatorio.k150.getCod_rubrica());
                dados_linha.add(relatorio.k150.getDesc_rubrica());

                retorno_nulls[2] = true;
            }
            else if(retorno_nulls[2]){
                dados_linha.add("-");
                dados_linha.add("-");
                dados_linha.add("-");
            }
            
            if(relatorio.k200!= null){
                if(int_k200 == -1)
                    int_k200 = dados_linha.size();
                           
                dados_linha.add(formato.format(relatorio.k200.getDt_inc_alt()));
                dados_linha.add(relatorio.k200.getCod_ccus());
                dados_linha.add(relatorio.k200.getCod_cta());
                        
                retorno_nulls[3] = true;
            }
            else if(retorno_nulls[3]){
                dados_linha.add("-");
                dados_linha.add("-");
                dados_linha.add("-");
            }
            
            if(relatorio.k250!= null){
                if(int_k250 == -1)
                    int_k250 = dados_linha.size();
                
                dados_linha.add(relatorio.k250.getString_IND_FL());
                dados_linha.add(String.valueOf(relatorio.k250.getDt_comp()));
                dados_linha.add(formato.format(relatorio.k250.getDt_pgto()));
                dados_linha.add(String.valueOf(relatorio.k250.getCod_cbo()));
                dados_linha.add(String.valueOf(relatorio.k250.getCod_ocorr()));
                dados_linha.add(relatorio.k250.getDesc_cargo());
                dados_linha.add(String.valueOf(relatorio.k250.getQtd_dep_ir()));
                dados_linha.add(String.valueOf(relatorio.k250.getQtd_dep_sf()));
                dados_linha.add(String.valueOf(relatorio.k250.getVl_base_irrf()));
                dados_linha.add(String.valueOf(relatorio.k250.getVl_base_ps()));

                retorno_nulls[4] = true;
            }

            if(relatorio.k300!= null){
                if(int_k300 == -1)
                    int_k300 = dados_linha.size();
                dados_linha.add(relatorio.k300.getCnpj());
                dados_linha.add(relatorio.k300.getString_IND_FL());
                dados_linha.add(String.valueOf(relatorio.k300.getDt_comp()));
                dados_linha.add(String.valueOf(relatorio.k300.getVlr_rubr()));
                dados_linha.add(relatorio.k300.getString_IND_RUBR());
                dados_linha.add(relatorio.k300.getString_IND_BASE_IRRF());
                dados_linha.add(relatorio.k300.getString_IND_BASE_PS());   

                retorno_nulls[5] = true;
            }
            
            list_dados.add(dados_linha);
           
        }
        
        Atualizar_coluna(retorno_nulls[0], retorno_nulls[1], retorno_nulls[2], retorno_nulls[3], retorno_nulls[4], retorno_nulls[5]);

        return retorno_nulls;
    }
    
    public void Atualizar_coluna(boolean k050, boolean k100, boolean k150, boolean k200, boolean k250, boolean k300){
        cabecalho_exibido = new ArrayList<String>();
        
        retorno_nulls[0] = k050;
        retorno_nulls[1] = k100;
        retorno_nulls[2] = k150;
        retorno_nulls[3] = k200;
        retorno_nulls[4] = k250;
        retorno_nulls[5] = k300;
        
        
        if(k050){
            for(int i = 0; i < cabecalho_k050.length; i++)
                cabecalho_exibido.add(cabecalho_k050[i]);
        }
        
        if(k100){
            for(int i = 0; i < cabecalho_k100.length; i++)
                cabecalho_exibido.add(cabecalho_k100[i]);
        }
        
        if(k150){
            for(int i = 0; i < cabecalho_k150.length; i++)
                cabecalho_exibido.add(cabecalho_k150[i]);
        }
          
        if(k200){
            for(int i = 0; i < cabecalho_k200.length; i++)
                cabecalho_exibido.add(cabecalho_k200[i]);
        }
          
        if(k250){
            for(int i = 0; i < cabecalho_k250.length; i++)
                cabecalho_exibido.add(cabecalho_k250[i]);
        }

        if(k300){
            for(int i = 0; i < cabecalho_k300.length; i++)
                cabecalho_exibido.add(cabecalho_k300[i]);
        }
        
        Atualizar_linhas();
        
        this.fireTableStructureChanged();
    }

    public void Atualizar_linhas(){
        
        int tamanho = 0;
        if(retorno_nulls[0]){
            tamanho = tamanho + cabecalho_k050.length;
        }
        if(retorno_nulls[1]){
            tamanho = tamanho + cabecalho_k100.length;
        }
        if(retorno_nulls[2]){
            tamanho = tamanho + cabecalho_k150.length;
        }
        if(retorno_nulls[3]){
            tamanho = tamanho + cabecalho_k200.length;
        }
        if(retorno_nulls[4]){
            tamanho = tamanho + cabecalho_k250.length;
        }
        if(retorno_nulls[5]){
            tamanho = tamanho + cabecalho_k300.length;
        }
        
        int[] id_registros = new int[tamanho];
        int indice = 0;
        
        if(retorno_nulls[0]){
            tamanho = int_k050;
            for(int i = indice; i<indice+cabecalho_k050.length; i++){
                id_registros[i] = tamanho;   
                tamanho++;
            }   
            indice = indice + cabecalho_k050.length;
        }
        if(retorno_nulls[1]){
            tamanho = int_k100;
            for(int i = indice; i<indice+cabecalho_k100.length; i++){
                id_registros[i] = tamanho;   
                tamanho++;
            }
            indice = indice + cabecalho_k100.length;
        }
        if(retorno_nulls[2]){
            tamanho = int_k150;
            for(int i = indice; i<indice+cabecalho_k150.length; i++){
                id_registros[i] = tamanho;  
                tamanho++;
            }
            indice = indice + cabecalho_k150.length;
        }
        if(retorno_nulls[3]){
            tamanho = int_k200;
            for(int i = indice; i<indice+cabecalho_k200.length; i++){
                id_registros[i] = tamanho;  
                tamanho++;
            }
            indice = indice + cabecalho_k200.length;
        }
        if(retorno_nulls[4]){
            tamanho = int_k250;
            for(int i = indice; i<indice+cabecalho_k250.length; i++){
                id_registros[i] = tamanho;
                tamanho++;
            }
            indice = indice + cabecalho_k250.length;
        }
        if(retorno_nulls[5]){
            tamanho = int_k300;
            for(int i = indice; i<indice+cabecalho_k300.length; i++){
                id_registros[i] = tamanho; 
                tamanho++;
            }
            indice = indice + cabecalho_k300.length;
        }

        list_linhas = new ArrayList<ArrayList<String>>();
               
        for(ArrayList<String> dado:list_dados){
            ArrayList<String> linha = new ArrayList<String>();
            for(int i =0; i< id_registros.length; i++){
                linha.add(dado.get(id_registros[i]));
            }
            list_linhas.add(linha);
        }   
        
        this.fireTableDataChanged(); 
    }
    
}
