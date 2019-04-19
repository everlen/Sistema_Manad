/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Victony
 */
public class Rubr_folha_pagamento {
    String cod;
    String descriçao;
    float valor;
    char ind_rubr;

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getDescriçao() {
        return descriçao;
    }

    public void setDescriçao(String descriçao) {
        this.descriçao = descriçao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public char getInd_rubr() {
        return ind_rubr;
    }

    public void setInd_rubr(char ind_rubr) {
        this.ind_rubr = ind_rubr;
    }

    
    
}
