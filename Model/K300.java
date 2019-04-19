/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Everlen
 */
public class K300 {
    String cnpj;
    int ind_fl;
    String cod_ltc;
    String cod_reg_trab;
    int dt_comp;
    String cod_rubr;
    float vlr_rubr;
    char ind_rubr;
    int ind_base_irrf;
    int ind_base_ps;
    
    String String_IND_FL;
    String String_IND_RUBR;
    String String_IND_BASE_IRRF;
    String String_IND_BASE_PS;
    
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

    public String getCod_rubr() {
        return cod_rubr;
    }

    public void setCod_rubr(String cod_rubr) {
        this.cod_rubr = cod_rubr;
    }

    public float getVlr_rubr() {
        return vlr_rubr;
    }

    public void setVlr_rubr(float vlr_rubr) {
        this.vlr_rubr = vlr_rubr;
    }

    public char getInd_rubr() {
        return ind_rubr;
    }

    public void setInd_rubr(char ind_rubr) {
        this.ind_rubr = ind_rubr;
    }

    public int getInd_base_irrf() {
        return ind_base_irrf;
    }

    public void setInd_base_irrf(int ind_base_irrf) {
        this.ind_base_irrf = ind_base_irrf;
    }

    public int getInd_base_ps() {
        return ind_base_ps;
    }

    public void setInd_base_ps(int ind_base_ps) {
        this.ind_base_ps = ind_base_ps;
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

    public String getString_IND_RUBR() {
        if(ind_rubr == 'D')
            String_IND_RUBR = "D- Desconto";
        else if(ind_rubr =='P')
            String_IND_RUBR = "P- Provento ou Vantagem";
        else
            String_IND_RUBR = "O- Outros";
        
        return String_IND_RUBR;
    }

    public String getString_IND_BASE_IRRF() {
        if(ind_base_irrf == 1)
            String_IND_BASE_IRRF = "1- Base de cálculo sálario mensal";
        else if(ind_base_irrf == 2)
            String_IND_BASE_IRRF = "2- Base de cálculo 13º sálario";
        else if(ind_base_irrf == 3)
            String_IND_BASE_IRRF = "3- Não é base de cálculo";
        else
            String_IND_BASE_IRRF = "9- Outras bases de cálculo";
        
        return String_IND_BASE_IRRF;
    }

    public String getString_IND_BASE_PS() {
        if(ind_base_ps == 1)
            String_IND_BASE_PS = "1- Base de cálculo para salário de contribuição mensal";
        else if(ind_base_ps == 2)
            String_IND_BASE_PS = "2- Base de cálculo do 13º salário";
        else if(ind_base_ps == 3)
            String_IND_BASE_PS = "3- Refere-se a valor descontado do segurado";
        else if(ind_base_ps == 4)
            String_IND_BASE_PS = "4- Refere-se a valor pago de salário família";
        else if(ind_base_ps == 5)
            String_IND_BASE_PS = "5- Base de cálculo do salário maternidade";
        else if(ind_base_ps == 6)
            String_IND_BASE_PS = "6- Base de cálculo exclusiva FGTS";
        else if(ind_base_ps == 7)
            String_IND_BASE_PS = "7- Reduções da base de cálculo";
        else if(ind_base_ps == 8)
            String_IND_BASE_PS = "8- Não é base de cálculo";
        else if(ind_base_ps == 9)
            String_IND_BASE_PS = "9- Outras bases de cálculo";
        
        return String_IND_BASE_PS;
    }
    
    
}
