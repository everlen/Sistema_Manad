/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Everlen
 */
public class K050 {
    String cnpj;
    Date dt_inc_alt = null;
    String cod_reg_trab;
    char[] cpf = new char[11];
    char[] nit = new char[11];
    int cod_categ;
    String nome_trab;
    Date dt_nasc;
    Date dt_admissao;
    Date dt_demissao = null;
    int ind_vinc;
    int tipo_ato_nom = 0;
    String nm_ato_nom = null;
    Date dt_ato_nom = null;
    String String_IND_VINC;
    String String_TIPO_ATO_NOM;
    
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Date getDt_inc_alt() {
        return dt_inc_alt;
    }

    public void setDt_inc_alt(Date dt_inc_alt) {
        this.dt_inc_alt = dt_inc_alt;
    }

    public String getCod_reg_trab() {
        return cod_reg_trab;
    }

    public void setCod_reg_trab(String cod_reg_trab) {
        this.cod_reg_trab = cod_reg_trab;
    }

    public char[] getCpf() {
        return cpf;
    }

    public void setCpf(char[] cpf) {
        this.cpf = cpf;
    }

    public char[] getNit() {
        return nit;
    }

    public void setNit(char[] nit) {
        this.nit = nit;
    }

    public int getCod_categ() {
        return cod_categ;
    }

    public void setCod_categ(int cod_categ) {
        this.cod_categ = cod_categ;
    }

    public String getNome_trab() {
        return nome_trab;
    }

    public void setNome_trab(String nome_trab) {
        this.nome_trab = nome_trab;
    }

    public Date getDt_nasc() {
        return dt_nasc;
    }

    public void setDt_nasc(Date dt_nasc) {
        this.dt_nasc = dt_nasc;
    }

    public Date getDt_admissao() {
        return dt_admissao;
    }

    public void setDt_admissao(Date dt_admissao) {
        this.dt_admissao = dt_admissao;
    }

    public Date getDt_demissao() {
        return dt_demissao;
    }

    public void setDt_demissao(Date dt_demissao) {
        this.dt_demissao = dt_demissao;
    }

    public int getInd_vinc() {
        return ind_vinc;
    }

    public void setInd_vinc(int ind_vinc) {
        this.ind_vinc = ind_vinc;
    }

    public int getTipo_ato_nom() {
        return tipo_ato_nom;
    }

    public void setTipo_ato_nom(int tipo_ato_nom) {
        this.tipo_ato_nom = tipo_ato_nom;
    }

    public String getNm_ato_nom() {
        return nm_ato_nom;
    }

    public void setNm_ato_nom(String nm_ato_nom) {
        this.nm_ato_nom = nm_ato_nom;
    }

    public Date getDt_ato_nom() {
        return dt_ato_nom;
    }

    public void setDt_ato_nom(Date dt_ato_nom) {
        this.dt_ato_nom = dt_ato_nom;
    }

    public String getString_IND_VINC() {
        if(ind_vinc==1)
            String_IND_VINC = "1- Vínculo normal";
        else if(ind_vinc==2)
            String_IND_VINC = "2- Vínculo temporário com redução de contribuições/obrigação";
        else if(ind_vinc==3)
            String_IND_VINC = "3- Servidor público Efetivo Estatutário";
        else if(ind_vinc==4)
            String_IND_VINC = "4- Servidor público Efetivo CLT";
        else if(ind_vinc==5)
            String_IND_VINC = "5- Servidor público Comissionado";
        else if(ind_vinc==6)
            String_IND_VINC = "6- Servidor público Cedido";
        else if(ind_vinc==7)
            String_IND_VINC = "7- Agentes Políticos";
        else if(ind_vinc==8)
            String_IND_VINC = "8- Contribuinte Individual";
        else
            String_IND_VINC = "9- Outros vínculos";
          
        return String_IND_VINC;
    }

    public String getString_TIPO_ATO_NOM() {
        if(tipo_ato_nom==1)
            String_TIPO_ATO_NOM = "1- Lei";
        else if(tipo_ato_nom==2)
            String_TIPO_ATO_NOM = "2- Decreto";
        else if(tipo_ato_nom==3)
            String_TIPO_ATO_NOM = "3- Portaria";
        else if(tipo_ato_nom==4)
            String_TIPO_ATO_NOM = "4- Contrato";
        else if(tipo_ato_nom==9)
            String_TIPO_ATO_NOM = "9- Outros";
        else
            String_TIPO_ATO_NOM = "-";
        
        return String_TIPO_ATO_NOM;
    }

    
}
