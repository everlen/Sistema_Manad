/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Everlen
 */
public class Requisitos_busca {
    ArrayList<String> tipo_folha = null;
    ArrayList<String> cod_rubr = null;
    ArrayList<String> cod_ltc = null;
    ArrayList<String> ind_base_ps = null;  
    String periodo = null;
    
    public ArrayList<String> getTipo_folha() {
        return tipo_folha;
    }

    public void setTipo_folha(ArrayList<String> tipo_folha) {
        this.tipo_folha = tipo_folha;
    }

    public ArrayList<String> getCod_rubr() {
        return cod_rubr;
    }

    public void setCod_rubr(ArrayList<String> cod_rubr) {
        this.cod_rubr = cod_rubr;
    }

    public ArrayList<String> getCod_ltc() {
        return cod_ltc;
    }

    public void setCod_ltc(ArrayList<String> cod_ltc) {
        this.cod_ltc = cod_ltc;
    }

    public ArrayList<String> getInd_base_ps() {
        return ind_base_ps;
    }

    public void setInd_base_ps(ArrayList<String> ind_base_ps) {
        this.ind_base_ps = ind_base_ps;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    
}
