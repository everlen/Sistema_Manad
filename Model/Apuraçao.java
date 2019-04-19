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
public class Apuraçao {
    
    String Ano;
    String Mes;
    String cod_rubr;
    String des_rubr;
    float valor_evento;
    float selic;
    float empresa;
    float empresa_atualizado;
    float rat;
    float rat_atualizado;
    float terceiros;
    float terceiros_atualizado;
    float total_apurado;
    float total_atualizado;
    
    public String getAno() {
        return Ano;
    }

    public void setAno(String Ano) {
        this.Ano = Ano;
    }

    public String getMes() {
        return Mes;
    }

    public void setMes(String Mes) {
        this.Mes = Mes;
    }

    public String getCod_rubr() {
        return cod_rubr;
    }

    public void setCod_rubr(String cod_rubr) {
        this.cod_rubr = cod_rubr;
    }

    public String getDes_rubr() {
        return des_rubr;
    }

    public void setDes_rubr(String des_rubr) {
        this.des_rubr = des_rubr;
    }

    public float getValor_evento() {
        return valor_evento;
    }

    public void setValor_evento(float valor_evento) {
        this.valor_evento = valor_evento;
    }

    public float getSelic() {
        return selic;
    }

    public void setSelic(float selic) {
        this.selic = selic;
    }

    public float getEmpresa() {
        return empresa;
    }

    public void setEmpresa(float empresa) {
        this.empresa = empresa;
    }

    public float getEmpresa_atualizado() {
        return empresa_atualizado;
    }

    public void setEmpresa_atualizado(float empresa_atualizado) {
        this.empresa_atualizado = empresa_atualizado;
    }

    public float getRat() {
        return rat;
    }

    public void setRat(float rat) {
        this.rat = rat;
    }

    public float getRat_atualizado() {
        return rat_atualizado;
    }

    public void setRat_atualizado(float rat_atualizado) {
        this.rat_atualizado = rat_atualizado;
    }

    public float getTerceiros() {
        return terceiros;
    }

    public void setTerceiros(float terceiros) {
        this.terceiros = terceiros;
    }

    public float getTerceiros_atualizado() {
        return terceiros_atualizado;
    }

    public void setTerceiros_atualizado(float terceiros_atualizado) {
        this.terceiros_atualizado = terceiros_atualizado;
    }

    public float getTotal_apurado() {
        return total_apurado;
    }

    public void setTotal_apurado(float total_apurado) {
        this.total_apurado = total_apurado;
    }

    public float getTotal_atualizado() {
        return total_atualizado;
    }

    public void setTotal_atualizado(float total_atualizado) {
        this.total_atualizado = total_atualizado;
    }

    public void Clonar(Apuraçao apuraçao){
        
        this.setAno(apuraçao.getAno());
        this.setCod_rubr(apuraçao.getCod_rubr());
        this.setDes_rubr(apuraçao.getDes_rubr());
        this.setEmpresa(apuraçao.getEmpresa());
        this.setEmpresa_atualizado(apuraçao.getEmpresa_atualizado());
        this.setMes(apuraçao.getMes());
        this.setRat(apuraçao.getRat());
        this.setRat_atualizado(apuraçao.getRat_atualizado());
        this.setSelic(apuraçao.getSelic());
        this.setTerceiros(apuraçao.getTerceiros());
        this.setTerceiros_atualizado(apuraçao.getTerceiros_atualizado());
        this.setTotal_apurado(apuraçao.getTotal_apurado());
        this.setTotal_atualizado(apuraçao.getTotal_atualizado());
        this.setValor_evento(apuraçao.getValor_evento());
    }
    
}
