/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Victony
 */
public class Item_folha_pagamento {   

    String dt_admissao;
    String cod_trabalhador;
    String nome_trabalhado;
    String desc_cargo;
    String data_pagamento;
    float valor_base_ps;
    ArrayList<Rubr_folha_pagamento> list_rubr;

    public String getDt_admissao() {
        return dt_admissao;
    }

    public void setDt_admissao(String dt_admissao) {
        this.dt_admissao = dt_admissao;
    }

    public String getCod_trabalhador() {
        return cod_trabalhador;
    }

    public void setCod_trabalhador(String cod_trabalhador) {
        this.cod_trabalhador = cod_trabalhador;
    }

    public String getNome_trabalhado() {
        return nome_trabalhado;
    }

    public void setNome_trabalhado(String nome_trabalhado) {
        this.nome_trabalhado = nome_trabalhado;
    }

    public String getDesc_cargo() {
        return desc_cargo;
    }

    public void setDesc_cargo(String desc_cargo) {
        this.desc_cargo = desc_cargo;
    }

    public ArrayList<Rubr_folha_pagamento> getList_rubr() {
        return list_rubr;
    }

    public void setList_rubr(ArrayList<Rubr_folha_pagamento> list_rubr) {
        this.list_rubr = list_rubr;
    }

    public float getValor_base_ps() {
        return valor_base_ps;
    }

    public void setValor_base_ps(float valor_base_ps) {
        this.valor_base_ps = valor_base_ps;
    }

    public String getData_pagamento() {
        return data_pagamento;
    }

    public void setData_pagamento(String data_pagamento) {
        this.data_pagamento = data_pagamento;
    }
    
    public int Contabilizar_quant_linhas(){
        int retorno_p = 0, retorno_d = 0;
        
        for(Rubr_folha_pagamento rubr : list_rubr){           
            if(rubr.getInd_rubr() == 'P')
                retorno_p++;  
            else if(rubr.getInd_rubr() == 'D')
                retorno_d++;
        }
        
        if(retorno_p > retorno_d)
            return retorno_p;
        else
            return retorno_d;

    }
    
}
