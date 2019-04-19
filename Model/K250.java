/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author Everlen
 */
public class K250 {
    String cnpj;
    int ind_fl;
    String cod_ltc;
    String cod_reg_trab;
    int dt_comp;
    Date dt_pgto;
    int cod_cbo;
    int cod_ocorr;
    String desc_cargo;
    int qtd_dep_ir;
    int qtd_dep_sf;
    float vl_base_irrf;
    float vl_base_ps;
    
    String String_IND_FL;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public int getInd_fl() {
        return ind_fl;
    }

    public void setInd_fl(int ind_fl) {
        this.ind_fl = ind_fl;
    }

    public String getCod_ltc() {
        return cod_ltc;
    }

    public void setCod_ltc(String cod_ltc) {
        this.cod_ltc = cod_ltc;
    }

    public String getCod_reg_trab() {
        return cod_reg_trab;
    }

    public void setCod_reg_trab(String cod_reg_trab) {
        this.cod_reg_trab = cod_reg_trab;
    }

    public int getDt_comp() {
        return dt_comp;
    }

    public void setDt_comp(int dt_comp) {
        this.dt_comp = dt_comp;
    }

    public Date getDt_pgto() {
        return dt_pgto;
    }

    public void setDt_pgto(Date dt_pgto) {
        this.dt_pgto = dt_pgto;
    }

    public int getCod_cbo() {
        return cod_cbo;
    }

    public void setCod_cbo(int cod_cbo) {
        this.cod_cbo = cod_cbo;
    }

    public int getCod_ocorr() {
        return cod_ocorr;
    }

    public void setCod_ocorr(int cod_ocorr) {
        this.cod_ocorr = cod_ocorr;
    }

    public String getDesc_cargo() {
        return desc_cargo;
    }

    public void setDesc_cargo(String desc_cargo) {
        this.desc_cargo = desc_cargo;
    }

    public int getQtd_dep_ir() {
        return qtd_dep_ir;
    }

    public void setQtd_dep_ir(int qtd_dep_ir) {
        this.qtd_dep_ir = qtd_dep_ir;
    }

    public int getQtd_dep_sf() {
        return qtd_dep_sf;
    }

    public void setQtd_dep_sf(int qtd_dep_sf) {
        this.qtd_dep_sf = qtd_dep_sf;
    }

    public float getVl_base_irrf() {
        return vl_base_irrf;
    }

    public void setVl_base_irrf(float vl_base_irrf) {
        this.vl_base_irrf = vl_base_irrf;
    }

    public float getVl_base_ps() {
        return vl_base_ps;
    }

    public void setVl_base_ps(float vl_base_ps) {
        this.vl_base_ps = vl_base_ps;
    }

    

    public String getString_IND_FL() {
        if(ind_fl==1)
            String_IND_FL = "1- Folha normal";
        else if(ind_fl==2)
            String_IND_FL = "2- Folha de 13º salário";
        else if(ind_fl==3)
            String_IND_FL = "3- Folha de férias";
        else if(ind_fl==4)
            String_IND_FL = "4- Folha complementar à normal";
        else if(ind_fl==5)
            String_IND_FL = "5- Folha complementar ao 13º";
        else
            String_IND_FL = ind_fl + "- Outras folhas";
        
        
        return String_IND_FL;
    }
    
    
}
