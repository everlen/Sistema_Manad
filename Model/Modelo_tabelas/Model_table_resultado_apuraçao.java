/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Modelo_tabelas;

import Controller.C_Relatorios;
import Model.Apuraçao;
import Model.Selic;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class Model_table_resultado_apuraçao extends AbstractTableModel{

    String[] cabecalho_tabela1 = {"Mes/Ano", "Valor Evento", "Juros Selic", "Incidencia Empresa", "Valor Atualizado", "Incidencia RAT", "Valor Atualizado", "Incidencia Terceiros", "Valor Atualizado", "Total Apurado", "Total Atualizado"};
    String[] cabecalho_tabela2 = {"Ano", "Codigo Evento", "Valor Evento", "Incidencia Empresa", "Valor Atualizado", "Incidencia RAT", "Valor Atualizado", "Indicencia Terceiros", "Valor Atualizado","Total Apurado", "Total Atualizado"};
    String[] cabecalho_tabela3 = {"Ano", "Reduçao da' Base de Cálculo", "Indicencia Empresa", "Incidencia RAT", "Incidencia Terceiros"};
    int tipo_cabecalho = 3;
    int mes_inicial = 0, ano_inicial = 0, mes_final = 0, ano_final = 0;
    
    ArrayList<ArrayList<Apuraçao>> matriz_apuraçao_cod;
    ArrayList<Apuraçao> list_apuraçao, list_apuraçao_mensal, list_apuraçao_ano, list_apuraçao_resumo;
    Apuraçao total_apuraçao_resumo, total_apuraçao_ano;
    ArrayList<Selic> list_selic_tratada;
    
    public int getTipo_cabecalho() {
        return tipo_cabecalho;
    }

    
    public void setTipo_cabecalho(int tipo_cabecalho) {
        this.tipo_cabecalho = tipo_cabecalho;
        if(tipo_cabecalho == 1){
            list_apuraçao = matriz_apuraçao_cod.get(0);
        }
        else if(tipo_cabecalho == 2){
            list_apuraçao = list_apuraçao_ano;
        }
        else{
            list_apuraçao = list_apuraçao_resumo;
        }
        
        this.fireTableStructureChanged();
        this.fireTableDataChanged();
    }
    
    
    @Override
    public int getRowCount() {
        return list_apuraçao.size();
    }

    
    @Override
    public int getColumnCount() {
        int retorno;
        switch(tipo_cabecalho){
            case 1:
                retorno = cabecalho_tabela1.length;
                break;
            case 2:
                retorno = cabecalho_tabela2.length;
                break;
            default:
                retorno = cabecalho_tabela3.length;
        }
        return retorno;
    }
    
    
    @Override
    public String getColumnName(int index) {
        String retorno;
        switch(tipo_cabecalho){
            case 1:
                retorno = cabecalho_tabela1[index];
                break;
            case 2:
                retorno = cabecalho_tabela2[index];
                break;
            default:
                retorno = cabecalho_tabela3[index];
        }
        return retorno;
    }

    
    @Override
    public Object getValueAt(int linha, int coluna) {
        String retorno = null;
        DecimalFormat df = new DecimalFormat("0.00");
        Apuraçao apuraçao = list_apuraçao.get(linha);
        switch(tipo_cabecalho){
            case 1:
//Tabela mes               
                switch(coluna){
                    case 0:
                        if(apuraçao.getAno().equals("Total") || apuraçao.getAno().equals("Soma"))
                            retorno = apuraçao.getAno();
                        else
                            retorno = apuraçao.getMes()+"/"+apuraçao.getAno();
                        break;
                    case 1:
                        retorno = df.format(apuraçao.getValor_evento());
                        break;
                    case 2:
                        retorno = df.format(apuraçao.getSelic());
                        break;
                    case 3:
                        retorno = df.format(apuraçao.getEmpresa());
                        break;
                    case 4:
                        retorno = df.format(apuraçao.getEmpresa_atualizado());
                        break;
                    case 5:
                        retorno = df.format(apuraçao.getRat());
                        break;
                    case 6:
                        retorno = df.format(apuraçao.getRat_atualizado());
                        break;
                    case 7:
                        retorno = df.format(apuraçao.getTerceiros());
                        break;
                    case 8:
                        retorno = df.format(apuraçao.getTerceiros_atualizado());
                        break;
                    case 9:
                        retorno = df.format(apuraçao.getTotal_apurado());
                        break;
                    default:
                        retorno = df.format(apuraçao.getTotal_atualizado());  
                }
                break;
            case 2:
//Tabela ano             
                switch(coluna){
                    case 0:
                        retorno = apuraçao.getAno();
                        break;
                    case 1:
                        retorno = apuraçao.getCod_rubr();
                        break;
                    case 2:
                        retorno = df.format(apuraçao.getValor_evento());
                        break;
                    case 3:
                        retorno = df.format(apuraçao.getEmpresa());
                        break;
                    case 4:
                        retorno = df.format(apuraçao.getEmpresa_atualizado());
                        break;
                    case 5:
                        retorno = df.format(apuraçao.getRat());
                        break;
                    case 6:
                        retorno = df.format(apuraçao.getRat_atualizado());
                        break;
                    case 7:
                        retorno = df.format(apuraçao.getTerceiros());
                        break;
                    case 8:
                        retorno = df.format(apuraçao.getTerceiros_atualizado());
                        break;
                    case 9:
                        retorno = df.format(apuraçao.getTotal_apurado());
                        break;
                    default:
                        retorno = df.format(apuraçao.getTotal_atualizado());  
                }
                break;
            default:
//Tabela resumo
                switch(coluna){
                    case 0:
                        retorno = apuraçao.getAno();
                        break;
                    case 1:
                        retorno = df.format(apuraçao.getValor_evento());
                        break;
                    case 2:
                        retorno = df.format(apuraçao.getEmpresa_atualizado());
                        break;
                    case 3:
                        retorno = df.format(apuraçao.getRat_atualizado());
                        break;
                    default:
                        retorno = df.format(apuraçao.getTerceiros_atualizado());
                }
        }
        return retorno;
    }
    
    
    public void setDados(ArrayList<ArrayList<Apuraçao>> list_rubricas_apuradas, ArrayList<ArrayList<Selic>> matriz_selic, float empresa, float rat, float terceiros){

        matriz_apuraçao_cod = new ArrayList<ArrayList<Apuraçao>>(); 
        list_selic_tratada = new ArrayList<Selic>();
        
        for(ArrayList<Apuraçao> rubr_dt_comp : list_rubricas_apuradas){
            ArrayList<Apuraçao> list_dt_comp = new ArrayList<Apuraçao>();
            
            float total_evento = 0, total_empresa = 0, total_empresa_atualizado = 0; 
            float total_rat = 0, total_rat_atualizado = 0, total_terceiro = 0, total_terceiro_atualizado = 0;
            float total_total_apurado = 0, total_total_atualizado = 0;
            
            float soma_evento = 0, soma_empresa = 0, soma_empresa_atualizado = 0; 
            float soma_rat = 0, soma_rat_atualizado = 0, soma_terceiro = 0, soma_terceiro_atualizado = 0;
            float soma_total_apurado = 0, soma_total_atualizado = 0;
            
            String ano_atual = rubr_dt_comp.get(0).getAno();
            
            Ordenar_tabela(rubr_dt_comp);
            for(int i = 0; i < rubr_dt_comp.size(); i++){
                Apuraçao apuraçao_rubr = rubr_dt_comp.get(i);
                Apuraçao apuraçao = new Apuraçao();
                
                apuraçao.setCod_rubr(apuraçao_rubr.getCod_rubr());
                apuraçao.setDes_rubr(apuraçao_rubr.getDes_rubr());
                apuraçao.setMes(apuraçao_rubr.getMes());
                apuraçao.setAno(apuraçao_rubr.getAno());
                apuraçao.setValor_evento(apuraçao_rubr.getValor_evento());
                apuraçao.setSelic(Calcular_selic(Integer.parseInt(apuraçao_rubr.getAno()), Integer.parseInt(apuraçao_rubr.getMes()), Integer.parseInt(rubr_dt_comp.get(rubr_dt_comp.size()-1).getAno()), Integer.parseInt(rubr_dt_comp.get(rubr_dt_comp.size()-1).getMes()), matriz_selic));
                apuraçao.setEmpresa((apuraçao.getValor_evento()/100)*empresa);
                apuraçao.setEmpresa_atualizado(apuraçao.getEmpresa()+((apuraçao.getEmpresa()/100)*apuraçao.getSelic()));
                apuraçao.setRat((apuraçao.getValor_evento()/100)*rat);
                apuraçao.setRat_atualizado(apuraçao.getRat()+((apuraçao.getRat()/100)*apuraçao.getSelic()));
                apuraçao.setTerceiros((apuraçao.getValor_evento()/100)*terceiros);
                apuraçao.setTerceiros_atualizado(apuraçao.getTerceiros()+((apuraçao.getTerceiros()/100)*apuraçao.getSelic()));
                apuraçao.setTotal_apurado(apuraçao.getEmpresa()+apuraçao.getRat()+apuraçao.getTerceiros());
                apuraçao.setTotal_atualizado(apuraçao.getEmpresa_atualizado()+apuraçao.getRat_atualizado()+apuraçao.getTerceiros_atualizado());
                
                
//Calculando soma
                if(!apuraçao.getAno().equals(ano_atual)){
                    Apuraçao apuraçao_soma = new Apuraçao();
                    apuraçao_soma.setAno("Soma");
                    apuraçao_soma.setValor_evento(soma_evento);
                    apuraçao_soma.setEmpresa(soma_empresa);
                    apuraçao_soma.setEmpresa_atualizado(soma_empresa_atualizado);
                    apuraçao_soma.setRat(soma_rat);
                    apuraçao_soma.setRat_atualizado(soma_rat_atualizado);
                    apuraçao_soma.setTerceiros(soma_terceiro);
                    apuraçao_soma.setTerceiros_atualizado(soma_terceiro_atualizado);
                    apuraçao_soma.setTotal_apurado(soma_total_apurado);
                    apuraçao_soma.setTotal_atualizado(soma_total_atualizado);

                    list_dt_comp.add(apuraçao_soma);

                    soma_evento = 0;
                    soma_empresa = 0;
                    soma_empresa_atualizado = 0;
                    soma_rat = 0;
                    soma_rat_atualizado = 0;
                    soma_terceiro = 0;
                    soma_terceiro_atualizado = 0;
                    soma_total_apurado = 0;
                    soma_total_atualizado = 0;
                }

                list_dt_comp.add(apuraçao);
                
                soma_evento += apuraçao.getValor_evento();
                soma_empresa += apuraçao.getEmpresa();
                soma_empresa_atualizado += apuraçao.getEmpresa_atualizado();
                soma_rat += apuraçao.getRat();
                soma_rat_atualizado += apuraçao.getRat_atualizado();
                soma_terceiro += apuraçao.getTerceiros();
                soma_terceiro_atualizado += apuraçao.getTerceiros_atualizado();
                soma_total_apurado += apuraçao.getTotal_apurado();
                soma_total_atualizado += apuraçao.getTotal_atualizado();

//Calculando total                    
                total_evento += apuraçao.getValor_evento();
                total_empresa += apuraçao.getEmpresa();
                total_empresa_atualizado += apuraçao.getEmpresa_atualizado();
                total_rat += apuraçao.getRat();
                total_rat_atualizado += apuraçao.getRat_atualizado();
                total_terceiro += apuraçao.getTerceiros();
                total_terceiro_atualizado += apuraçao.getTerceiros_atualizado();
                total_total_apurado += apuraçao.getTotal_apurado();
                total_total_atualizado += apuraçao.getTotal_atualizado();
                
                ano_atual = apuraçao.getAno();
            }   
            
            Apuraçao apuraçao_soma = new Apuraçao();
            apuraçao_soma.setAno("Soma");
            apuraçao_soma.setValor_evento(soma_evento);
            apuraçao_soma.setEmpresa(soma_empresa);
            apuraçao_soma.setEmpresa_atualizado(soma_empresa_atualizado);
            apuraçao_soma.setRat(soma_rat);
            apuraçao_soma.setRat_atualizado(soma_rat_atualizado);
            apuraçao_soma.setTerceiros(soma_terceiro);
            apuraçao_soma.setTerceiros_atualizado(soma_terceiro_atualizado);
            apuraçao_soma.setTotal_apurado(soma_total_apurado);
            apuraçao_soma.setTotal_atualizado(soma_total_atualizado);

            list_dt_comp.add(apuraçao_soma);
            
            
            Apuraçao apuraçao_total = new Apuraçao();
            apuraçao_total.setAno("Total");
            apuraçao_total.setValor_evento(total_evento);
            apuraçao_total.setEmpresa(total_empresa);
            apuraçao_total.setEmpresa_atualizado(total_empresa_atualizado);
            apuraçao_total.setRat(total_rat);
            apuraçao_total.setRat_atualizado(total_rat_atualizado);
            apuraçao_total.setTerceiros(total_terceiro);
            apuraçao_total.setTerceiros_atualizado(total_terceiro_atualizado);
            apuraçao_total.setTotal_apurado(total_total_apurado);
            apuraçao_total.setTotal_atualizado(total_total_atualizado);
            
            list_dt_comp.add(apuraçao_total);
            
            matriz_apuraçao_cod.add(list_dt_comp);
        }
        
        list_apuraçao_ano = Gerar_tabela_ano();
        list_apuraçao_resumo = Gerar_tabela_resumo();
        list_apuraçao = list_apuraçao_resumo;
        this.fireTableStructureChanged();
        this.fireTableDataChanged();
    }
      
    public float Calcular_selic(int ano_atual, int mes_atual, int ano_final, int mes_final, ArrayList<ArrayList<Selic>> matriz_selic){
        float retorno = 1.0f;    
//Localizar indice correspondente ao ano selic
        int indice_selic_anual = -1;
        for(int i =0; i< matriz_selic.size(); i++){
            if(matriz_selic.get(i).get(0).getAno() == ano_atual){
                indice_selic_anual = i;
                break;
            }               
        }
        if(indice_selic_anual != -1){
            for(int i = ano_atual; i <= ano_final; i++){   
                int c = 1;
                boolean sair = false;
                if(i == ano_atual){
                    c = mes_atual; 
                }     
                
                for(int i2 = c; i2 < 13; i2++){ 
                    retorno += (retorno * matriz_selic.get(indice_selic_anual).get(i2-1).getPorcentagem())/100;
                    if(i == ano_final && i2 == mes_final){
                        sair = true;
                        break;
                    }
                       
                } 
                
                if(sair)
                    break;
                
                indice_selic_anual++;
            }
            retorno = (retorno-1) * 100;
        }
        else{
            System.out.println("Ano nao localizado");
            retorno = 0;
        }
// Localizar indice da matriz_selic_tratada por ano e mes
        Selic selic = new Selic();
        selic.setAno(ano_atual);
        selic.setMes(mes_atual);
        selic.setPorcentagem(retorno);
        list_selic_tratada.add(selic);
        
        return retorno;
    }

    
    public void Selecionar_rubr_exibida(int index){
        list_apuraçao = matriz_apuraçao_cod.get(index);    
        this.fireTableDataChanged(); 
    }

    
    private ArrayList<Apuraçao> Gerar_tabela_ano(){
        ArrayList<Apuraçao> list_aux_apuraçao = new ArrayList<Apuraçao>();
        
        for(ArrayList<Apuraçao> list_aux : matriz_apuraçao_cod){
            float total_evento = 0, total_empresa = 0, total_empresa_atualizado = 0; 
            float total_rat = 0, total_rat_atualizado = 0, total_terceiro = 0, total_terceiro_atualizado = 0;
            float total_total_apurado = 0, total_total_atualizado = 0;
            
            
            for(Apuraçao apuraçao : list_aux){ 
                int indice = Verificar_indice(list_aux_apuraçao, apuraçao.getCod_rubr(), apuraçao.getAno());
                if(indice != -2){
                    if(indice > -1){
                        Apuraçao apuraçao_aux = list_aux_apuraçao.get(indice);
                        apuraçao_aux.setDes_rubr(apuraçao.getDes_rubr());
                        apuraçao_aux.setValor_evento(apuraçao_aux.getValor_evento()+apuraçao.getValor_evento());
                        apuraçao_aux.setEmpresa(apuraçao_aux.getEmpresa()+apuraçao.getEmpresa());
                        apuraçao_aux.setEmpresa_atualizado(apuraçao_aux.getEmpresa_atualizado()+apuraçao.getEmpresa_atualizado());
                        apuraçao_aux.setRat(apuraçao_aux.getRat()+apuraçao.getRat());
                        apuraçao_aux.setRat_atualizado(apuraçao_aux.getRat_atualizado()+apuraçao.getRat_atualizado());
                        apuraçao_aux.setTerceiros(apuraçao_aux.getTerceiros()+apuraçao.getTerceiros());
                        apuraçao_aux.setTerceiros_atualizado(apuraçao_aux.getTerceiros_atualizado()+apuraçao.getTerceiros_atualizado());
                        apuraçao_aux.setTotal_apurado(apuraçao_aux.getTotal_apurado()+apuraçao.getTotal_apurado());
                        apuraçao_aux.setTotal_atualizado(apuraçao_aux.getTotal_atualizado()+apuraçao.getTotal_atualizado());

                    }
                    else{
                        Apuraçao apuraçao_aux = new Apuraçao();
                        apuraçao_aux.Clonar(apuraçao);
                        list_aux_apuraçao.add(apuraçao_aux);
                    }
//Calculando total                    
                    total_evento += apuraçao.getValor_evento();
                    total_empresa += apuraçao.getEmpresa();
                    total_empresa_atualizado += apuraçao.getEmpresa_atualizado();
                    total_rat += apuraçao.getRat();
                    total_rat_atualizado += apuraçao.getRat_atualizado();
                    total_terceiro += apuraçao.getTerceiros();
                    total_terceiro_atualizado += apuraçao.getTerceiros_atualizado();
                    total_total_apurado += apuraçao.getTotal_apurado();
                    total_total_atualizado += apuraçao.getTotal_atualizado();
                }
            }
//Inserir obj total
            Apuraçao apuraçao_total = new Apuraçao();
            apuraçao_total.setAno("Total");
            apuraçao_total.setValor_evento(total_evento);
            apuraçao_total.setEmpresa(total_empresa);
            apuraçao_total.setEmpresa_atualizado(total_empresa_atualizado);
            apuraçao_total.setRat(total_rat);
            apuraçao_total.setRat_atualizado(total_rat_atualizado);
            apuraçao_total.setTerceiros(total_terceiro);
            apuraçao_total.setTerceiros_atualizado(total_terceiro_atualizado);
            apuraçao_total.setTotal_apurado(total_total_apurado);
            apuraçao_total.setTotal_atualizado(total_total_atualizado);
            
            list_aux_apuraçao.add(apuraçao_total);
            
        }
        
        return list_aux_apuraçao;
    } 
    
    
    private ArrayList<Apuraçao> Gerar_tabela_resumo(){
        ArrayList<Apuraçao> list_aux_apuraçao = new ArrayList<Apuraçao>();
        
        
        for(Apuraçao apuraçao:list_apuraçao_ano){
            int indice = Verificar_indice(list_aux_apuraçao, null, apuraçao.getAno());
            if(indice>-1){
                Apuraçao apuraçao_aux = list_aux_apuraçao.get(indice);
                apuraçao_aux.setDes_rubr(apuraçao.getDes_rubr());
                apuraçao_aux.setValor_evento(apuraçao_aux.getValor_evento()+apuraçao.getValor_evento());
                apuraçao_aux.setEmpresa_atualizado(apuraçao_aux.getEmpresa_atualizado()+apuraçao.getEmpresa_atualizado());
                apuraçao_aux.setRat_atualizado(apuraçao_aux.getRat_atualizado()+apuraçao.getRat_atualizado());
                apuraçao_aux.setTerceiros_atualizado(apuraçao_aux.getTerceiros_atualizado()+apuraçao.getTerceiros_atualizado());
            }
            else if(indice == -1){
                Apuraçao apuraçao_aux = new Apuraçao();
                apuraçao_aux.Clonar(apuraçao);
                list_aux_apuraçao.add(apuraçao_aux);
            }
            else{
//Ignora por ser campo de total
                
            }
        }    
        float total_evento = 0, total_empresa = 0, total_rat = 0, total_terceiro = 0;
        for(Apuraçao apuraçao : list_aux_apuraçao){
            total_evento += apuraçao.getValor_evento();
            total_empresa += apuraçao.getEmpresa_atualizado();
            total_rat += apuraçao.getRat_atualizado();
            total_terceiro += apuraçao.getTerceiros_atualizado();
            
        }
        
        total_apuraçao_resumo = new Apuraçao();
        total_apuraçao_resumo.setAno("Total");
        total_apuraçao_resumo.setValor_evento(total_evento);
        total_apuraçao_resumo.setEmpresa_atualizado(total_empresa);
        total_apuraçao_resumo.setRat_atualizado(total_rat);
        total_apuraçao_resumo.setTerceiros_atualizado(total_terceiro);
        
        list_aux_apuraçao.add(total_apuraçao_resumo);
        
        return list_aux_apuraçao;
    } 
    
    
    private int Verificar_indice(ArrayList<Apuraçao> list_aux_apuraçao, String cod, String ano){
        int indice = -1;
        
        if(ano.equals("Total") || ano.equals("Soma"))
            return -2;
        
        if(list_aux_apuraçao.size()>0){
            int i = 0;
// Ano            
            if(cod != null){
                for(Apuraçao apuraçao : list_aux_apuraçao){
                    if(apuraçao.getAno().equals(ano) && apuraçao.getCod_rubr().equals(cod))
                        indice = i;
                    i++;
                }
            }
// Resumo            
            else{
                for(Apuraçao apuraçao : list_aux_apuraçao){
                    if(apuraçao.getAno().equals(ano))
                        indice = i;
                    i++;
                }            
            }
        }
        
        return indice;
    }
    private void Ordenar_tabela(ArrayList<Apuraçao> list_apuraçao){
        
        for(int i = 0; i < list_apuraçao.size() - 1; i++){
            
            for(int c = i; c < list_apuraçao.size(); c++){
                
                if(Integer.parseInt(list_apuraçao.get(i).getAno()) > Integer.parseInt(list_apuraçao.get(c).getAno())){
                    Apuraçao aux_apuraçao = list_apuraçao.get(i);
                    list_apuraçao.set(i, list_apuraçao.get(c));
                    list_apuraçao.set(c, aux_apuraçao);
                    
                }
                else if(Integer.parseInt(list_apuraçao.get(i).getAno()) == Integer.parseInt(list_apuraçao.get(c).getAno())){
                    if(Integer.parseInt(list_apuraçao.get(i).getMes()) > Integer.parseInt(list_apuraçao.get(c).getMes())){
                        Apuraçao aux_apuraçao = list_apuraçao.get(i);
                        list_apuraçao.set(i, list_apuraçao.get(c));
                        list_apuraçao.set(c, aux_apuraçao);
                    }
                }
            }
                
        }
        
        if(ano_inicial == 0 || (Integer.parseInt(list_apuraçao.get(0).getAno()) <= ano_inicial && Integer.parseInt(list_apuraçao.get(0).getMes()) < mes_inicial)){
            mes_inicial = Integer.parseInt(list_apuraçao.get(0).getMes());
            ano_inicial = Integer.parseInt(list_apuraçao.get(0).getAno());
        }
        
        if(ano_final == 0 || (Integer.parseInt(list_apuraçao.get(list_apuraçao.size()-1).getAno()) >= ano_final && Integer.parseInt(list_apuraçao.get(list_apuraçao.size()-1).getMes()) >= mes_final)){
            mes_final = Integer.parseInt(list_apuraçao.get(list_apuraçao.size()-1).getMes());
            ano_final = Integer.parseInt(list_apuraçao.get(list_apuraçao.size()-1).getAno());
        }
        
    }

    public ArrayList<Apuraçao> getList_apuraçao_mensal() {
        list_apuraçao_mensal = new ArrayList<Apuraçao>();
        
        for(ArrayList<Apuraçao> list_aux_apuraçao : matriz_apuraçao_cod){
            for(Apuraçao apuraçao : list_aux_apuraçao){
                 list_apuraçao_mensal.add(apuraçao);
            }
        }
        
        return list_apuraçao_mensal;
    }

    public ArrayList<Apuraçao> getList_apuraçao_ano() {
        return list_apuraçao_ano;
    }

    public ArrayList<Apuraçao> getList_apuraçao_resumo() {
        return list_apuraçao_resumo;
    }

    public int getMes_inicial() {
        return mes_inicial;
    }

    public int getAno_inicial() {
        return ano_inicial;
    }

    public int getMes_final() {
        return mes_final;
    }

    public int getAno_final() {
        return ano_final;
    }

    public ArrayList<Selic> getList_selic_tratada() {
        return list_selic_tratada;
    }

    
    
    
    
}
